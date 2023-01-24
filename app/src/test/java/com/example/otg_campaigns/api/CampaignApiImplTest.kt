@file:Suppress("MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate")

package com.example.otg_campaigns.api
import com.example.otg_campaigns.MockFileReader
import com.example.otg_campaigns.utils.Status
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

@Suppress("MemberVisibilityCanBePrivate")
@RunWith(JUnit4::class)
class CampaignApiImplTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var campaignApiImpl: CampaignApiImpl
    private var okHttpClient = OkHttpClient.Builder()
        .build()
    private val response = MockFileReader("campaign_response.json").content
    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        val campaignApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CampaignApiService::class.java)
        campaignApiImpl = CampaignApiImpl(campaignApi)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `for multiple Campaigns, api must return all Campaigns`() = runTest {

        val expectedResponse = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(response)
        mockWebServer.enqueue(expectedResponse)

        val actualResponse = campaignApiImpl.getAllCampaigns()

        assertEquals(Status.SUCCESS, actualResponse.status)
    }

    @Test
    fun `for server error, api must return with http code 500`() = runTest {
        val expectedResponse = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR)
        mockWebServer.enqueue(expectedResponse)

        val actualResponse = campaignApiImpl.getAllCampaigns()
        assertEquals(Status.ERROR, actualResponse.status)
    }
}
