@file:Suppress("unused", "unused", "unused")

package com.example.otg_campaigns.di
import com.example.otg_campaigns.Constants.Constants.BASE_URL
import com.example.otg_campaigns.utils.NetworkInterceptor
import com.example.otg_campaigns.api.CampaignApi
import com.example.otg_campaigns.api.CampaignApiImpl
import com.example.otg_campaigns.api.CampaignApiService
import com.example.otg_campaigns.repository.CampaignsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Suppress("unused", "unused", "unused")
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
private var retrofit: Retrofit? = null
@Singleton
@Provides
fun provideOkHttpClient(): OkHttpClient = OkHttpClient
    .Builder()
    .addInterceptor(NetworkInterceptor())
    .build()
@Singleton
@Provides
fun getRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
          .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
@Singleton
@Provides
fun getRetrofitServiceInstance(retrofit: Retrofit): CampaignApiService {
    return retrofit.create(CampaignApiService::class.java)
}
@Singleton
@Provides
fun getCampaignApi(campaignApiService: CampaignApiService): CampaignApi {
    return CampaignApiImpl(campaignApiService)
}
@Singleton
@Provides
fun getCampaignRepository(campaignApi: CampaignApi): CampaignsRepository {
    return CampaignsRepository(campaignApi)
}
}
