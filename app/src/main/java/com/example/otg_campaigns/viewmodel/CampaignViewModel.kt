package com.example.otg_campaigns.viewmodel
import androidx.lifecycle.*
import com.example.otg_campaigns.utils.Resource
import com.example.otg_campaigns.models.CampaignResponse
import com.example.otg_campaigns.repository.CampaignsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CampaignViewModel @Inject constructor(private val repository: CampaignsRepository) : ViewModel() {

    private var campaignLiveData = MutableLiveData<Resource<CampaignResponse?>>()

    init {
        getAllCampaigns()
    }

    fun getAllCampaigns() = viewModelScope.launch {
        repository.getCampaigns().collect {
            campaignLiveData.postValue(it)
        }
    }

    fun observeCampaignLiveData(): LiveData<Resource<CampaignResponse?>> {
        return campaignLiveData
    }
}
