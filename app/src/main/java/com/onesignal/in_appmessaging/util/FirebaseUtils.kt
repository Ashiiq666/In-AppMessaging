package com.onesignal.in_appmessaging.util

import android.net.Uri
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.google.firebase.dynamiclinks.ktx.androidParameters

fun generateSharingLink(
    deepLink: Uri,
    previewImageLink: Uri,
    getShareableLink: (String) -> Unit = {},
) {
    FirebaseDynamicLinks.getInstance().createDynamicLink().run {
        // What is this link parameter? You will get to know when we will actually use this function.
        link = deepLink

        // [domainUriPrefix] will be the domain name you added when setting up Dynamic Links at Firebase Console.
        // You can find it in the Dynamic Links dashboard.
        domainUriPrefix = Constant.PREFIX

        // Pass your preview Image Link here;
        setSocialMetaTagParameters(
            DynamicLink.SocialMetaTagParameters.Builder()
                .setImageUrl(previewImageLink)
                .build()
        )

        // Required
        androidParameters {
            build()
        }

        // Finally
        buildShortDynamicLink()
    }.also {
        it.addOnSuccessListener { dynamicLink ->
            // This lambda will be triggered when short link generation is successful

            // Retrieve the newly created dynamic link so that we can use it further for sharing via Intent.
            getShareableLink.invoke(dynamicLink.shortLink.toString())
        }
        it.addOnFailureListener {
            // This lambda will be triggered when short link generation failed due to an exception

            // Handle
        }
    }
}