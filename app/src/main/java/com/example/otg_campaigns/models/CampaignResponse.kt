@file:Suppress("unused")

package com.example.otg_campaigns.models

@Suppress("unused")

class CampaignResponse: ArrayList<CampaignResponseItem>()

@Suppress("unused")
data class CampaignResponseItem(
    val createdDate: String,
    val deepLink: String,
    val description: String,
    val endDate: String,
    val id: Int,
    val image: List<Image>,
    val platformOptions: List<String>,
    val startDate: String,
    val title: String
)

data class Image(
    val code: String,
    val downloadUri: String,
    val filePath: String,
    val id: Int,
    val name: String,
    val type: String
)
