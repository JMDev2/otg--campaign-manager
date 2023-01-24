package com.example.otg_campaigns.api

import com.example.otg_campaigns.utils.Resource
import com.example.otg_campaigns.models.CampaignResponse
import javax.inject.Inject

class CampaignApiImpl @Inject constructor(private val api: CampaignApiService) : CampaignApi {
    override suspend fun getAllCampaigns(): Resource<CampaignResponse?> {
        val response = api.getAllCampaigns("RETAIL")
        return if (response.isSuccessful) {
            Resource.success(response.body())
        } else {
            Resource.error("No Campaigns found. Check your network connection", null)
        }
    }
}
