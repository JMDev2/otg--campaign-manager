package com.example.otg_campaigns.api

import com.example.otg_campaigns.models.CampaignResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CampaignApiService {
@GET("campaigns/platform-options")
suspend fun getAllCampaigns(
    @Query("platformOptions") platform: String,
): Response<CampaignResponse>
}
