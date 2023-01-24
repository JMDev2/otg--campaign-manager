@file:Suppress("unused")

package com.example.otg_campaigns.api

import com.example.otg_campaigns.utils.Resource
import com.example.otg_campaigns.models.CampaignResponse

@Suppress("unused")
interface CampaignApi {

    // overides campaign impl class
    suspend fun getAllCampaigns(): Resource<CampaignResponse?>
}
