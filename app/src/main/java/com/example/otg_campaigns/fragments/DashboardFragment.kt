@file:Suppress("CascadeIf")

package com.example.otg_campaigns.fragments
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.otg_campaigns.utils.Status
import com.example.otg_campaigns.adaptor.CampaignAdapter
import com.example.otg_campaigns.databinding.FragmentDashboardBinding
import com.example.otg_campaigns.viewmodel.CampaignViewModel
import dagger.hilt.android.AndroidEntryPoint
@Suppress("CascadeIf", "RedundantOverride", "RedundantOverride", "RedundantOverride",
"RedundantOverride", "RedundantOverride"
)
@AndroidEntryPoint
class DashboardFragment : Fragment() {

private val viewModel: CampaignViewModel by viewModels()
private lateinit var campaignAdapter: CampaignAdapter

private lateinit var binding: FragmentDashboardBinding
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
}

override fun onCreateView(
inflater: LayoutInflater,
container: ViewGroup?,
savedInstanceState: Bundle?
): View {
// Inflate the layout for this fragment
binding = FragmentDashboardBinding.inflate(inflater, container, false)

hideDashboardFragment() // calling the hidedashboard method

return binding.root
}
// hiding the dashboard fragment
private fun hideDashboardFragment() {
binding.cancelImageview.setOnClickListener {
    binding.dashboardFragment.visibility = View.GONE
}
}
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
super.onViewCreated(view, savedInstanceState)
observeCampagin()
}
// on campaign click listener
private fun onCampaignClick() {
campaignAdapter.onItemClick = { campaign ->
    val navigate = findNavController()

    val uri = Uri.parse(campaign.deepLink)
    if (navigate.graph.hasDeepLink(uri)) {
        val options = NavOptions.Builder()
            .build()
        findNavController().navigate(uri, options)
    }
}
}
// setting the campaign recyclerview
private fun setRecyclerView() {
binding.campaignRecyclerView.apply {
    layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    adapter = campaignAdapter
}
}
// setting the observer method to show data states
private fun observeCampagin() {
viewModel.observeCampaignLiveData().observe(
    viewLifecycleOwner
) { campaignResponse ->
    when (campaignResponse.status) {
        Status.SUCCESS -> {
            //TODO Dismiss progress dialog
            val response = campaignResponse.data
            binding.progressBar2.visibility = View.GONE
                response?.let {
                    campaignAdapter = CampaignAdapter(it)

                    binding.campaignRecyclerView.visibility = View.VISIBLE

                    setRecyclerView()  //calling the recyclerview
                    onCampaignClick()//calling the campaign click method
            }
        }
        // if error state
        Status.ERROR -> {
            // TODO Dismiss progress dialog
            // TODO Show error message in dialog.
            binding.progressBar2.visibility = View.GONE
            Toast.makeText(requireContext(), campaignResponse.message, Toast.LENGTH_LONG)
               .show()
        }
        // if still loading
        Status.LOADING -> {
            // TODO Show progress dialog
            binding.progressBar2.visibility = View.VISIBLE
            binding.campaignRecyclerView.visibility = View.GONE
        }
    }
}
}
}
