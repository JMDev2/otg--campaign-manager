
package com.example.otg_campaigns.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


import com.example.otg_campaigns.databinding.FragmentKraPaymentBinding


@Suppress("RedundantNullableReturnType")
class KraPaymentFragment : Fragment() {
lateinit var binding: FragmentKraPaymentBinding
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
}
override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    // Inflate the layout for this fragment
    binding = FragmentKraPaymentBinding.inflate(inflater, container, false)
    hideFragment()
    return binding.root
}
// closing down the fragment
private fun hideFragment() {
    binding.kraCancelImg.setOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed()
        // Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_LONG).show()
    }
}
}
