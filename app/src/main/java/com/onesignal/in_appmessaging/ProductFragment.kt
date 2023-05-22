package com.onesignal.in_appmessaging

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.onesignal.in_appmessaging.databinding.FragmentProductBinding


class ProductFragment : Fragment() {
    private var binding: FragmentProductBinding? = null
    private val args: ProductFragmentArgs by navArgs()
    private var productName = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        productName = args.productName

        binding?.tvProductName?.text = productName
    }
}