package com.example.otg_campaigns.repository

import com.example.otg_campaigns.utils.Resource
import com.example.otg_campaigns.api.CampaignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CampaignsRepository @Inject constructor(private val api: CampaignApi) {

    suspend fun getCampaigns() = flow {
        emit(Resource.loading(null))
        emit(api.getAllCampaigns()) // reference the campaign api
    }.flowOn(Dispatchers.IO)
}
