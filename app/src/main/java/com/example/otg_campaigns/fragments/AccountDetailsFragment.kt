@file:Suppress("RedundantNullableReturnType")

package com.example.otg_campaigns.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.otg_campaigns.R
import com.example.otg_campaigns.databinding.FragmentAccountDetailsBinding


@Suppress("RedundantNullableReturnType", "RedundantNullableReturnType")
class AccountDetailsFragment : Fragment() {
lateinit var binding: FragmentAccountDetailsBinding

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
}
override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    // Inflate the layout for this fragment

    binding = FragmentAccountDetailsBinding.inflate(inflater, container, false)

    binding.dashboardLaunch.setOnClickListener {
        callDashBoard()
    }
    return binding.root
}
// calls the dashboard fragment
private fun callDashBoard() {
    val dashboardFragment = DashboardFragment()
    val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
    transaction.replace(R.id.container, dashboardFragment)
    transaction.commit()
}
}
