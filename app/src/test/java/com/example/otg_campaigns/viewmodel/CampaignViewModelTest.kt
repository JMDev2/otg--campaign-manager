package com.example.otg_campaigns.viewmodel
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.otg_campaigns.MockFileReader
import com.example.otg_campaigns.utils.Resource
import com.example.otg_campaigns.TestCoroutineRule
import com.example.otg_campaigns.models.CampaignResponse
import com.example.otg_campaigns.repository.CampaignsRepository
import com.google.gson.Gson
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
@RunWith(JUnit4::class)
class CampaignViewModelTest {
    @Rule
    @JvmField
    val instantRunExecutorRule = InstantTaskExecutorRule()
    @ExperimentalCoroutinesApi
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()
    private lateinit var campaignViewModel: CampaignViewModel
    private lateinit var campaignsRepository: CampaignsRepository
    private val response = MockFileReader("campaign_response.json").content



    @Before
    fun setUp() {
        campaignsRepository = mockk()
        campaignViewModel = CampaignViewModel(campaignsRepository)
    }

    @Test
    fun `for Loading multiple Campaigns, api must return all Campaigns`() {
        val jsonResponse = Gson().fromJson(response, CampaignResponse::class.java)
        val responseResource = Resource.success(jsonResponse)
        coEvery { campaignsRepository.getCampaigns() } returns flow {
            emit(Resource.loading(null))
            emit(responseResource)
        }

        campaignViewModel.getAllCampaigns()
        val campaigns = campaignViewModel.observeCampaignLiveData().value
        assertEquals(responseResource, campaigns)
    }
}
