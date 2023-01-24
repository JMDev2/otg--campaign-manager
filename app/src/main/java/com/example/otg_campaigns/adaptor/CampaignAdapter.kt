@file:Suppress("MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate")

package com.example.otg_campaigns.adaptor
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.otg_campaigns.R
import com.example.otg_campaigns.databinding.CampaignLayoutBinding
import com.example.otg_campaigns.models.CampaignResponseItem

import com.squareup.picasso.Picasso

class CampaignAdapter(private val campaigns: ArrayList<CampaignResponseItem>) :
RecyclerView.Adapter<CampaignAdapter.CampaginViewHolder>() {
lateinit var onItemClick: ((CampaignResponseItem) -> Unit)
inner class CampaginViewHolder(val binding: CampaignLayoutBinding,val context :Context) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        campaign: CampaignResponseItem
    ) {
        binding.campaignDescription.text = campaign.title
        binding.campaignDescriptionTwo.text = campaign.description
        if (campaign.image.isNotEmpty()) {
            val image = campaign.image[0]
            Picasso.get().load(image.downloadUri).into(binding.campaignImage)
        }else {
            binding.campaignImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.campaign))
        }
    }
}
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampaginViewHolder {
    return CampaginViewHolder(
        CampaignLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false),parent.context
    )
}
override fun onBindViewHolder(holder: CampaginViewHolder, position: Int) {
    holder.bind(campaigns[position])

    holder.itemView.setOnClickListener {
        onItemClick.invoke(campaigns[position])
    }
}
override fun getItemCount(): Int = campaigns.size
}