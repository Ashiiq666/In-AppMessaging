package com.onesignal.in_appmessaging.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import com.onesignal.in_appmessaging.databinding.FragmentProductBinding
import com.onesignal.in_appmessaging.model.Post
import com.onesignal.in_appmessaging.util.Constant
import com.onesignal.in_appmessaging.util.generateSharingLink


class ProductFragment : Fragment() {
    private var binding: FragmentProductBinding? = null


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
//        binding?.tvProductName?.setOnClickListener {
//            // Using the function we created to generate Sharing Link.
//            generateSharingLink(
//                deepLink = "${Constant.PREFIX}/post/${post.id}".toUri(),
//                previewImageLink = post.image.toUri()
//            ) { generatedLink ->
//                shareDeepLink(generatedLink)
//            }
//        }
    }

}