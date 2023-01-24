
package com.example.otg_campaigns.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.otg_campaigns.databinding.FragmentLocalBankTransferBinding

@Suppress("RedundantNullableReturnType")

class LocalBankTransferFragment : Fragment() {
lateinit var binding: FragmentLocalBankTransferBinding
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
}
override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    // Inflate the layout for this fragment
    binding = FragmentLocalBankTransferBinding.inflate(inflater, container, false)

    hideFragemnt()
    return binding.root
}
private fun hideFragemnt() {
    binding.imageViewCancel.setOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed()
    }
}
}
