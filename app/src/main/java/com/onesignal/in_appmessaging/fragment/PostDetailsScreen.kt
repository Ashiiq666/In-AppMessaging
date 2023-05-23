package com.onesignal.in_appmessaging.fragment

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.ImageLoader
import com.onesignal.in_appmessaging.components.PostItem
import com.onesignal.in_appmessaging.datasource.FakeData
import com.onesignal.in_appmessaging.util.Constant
import com.onesignal.in_appmessaging.util.generateSharingLink
import com.onesignal.in_appmessaging.util.shareDeepLink

@Composable
fun PostDetailScreen(
    postId: Int,
    imageLoader: ImageLoader,
) {
    val context = LocalContext.current

    val post = FakeData.listOfPost.find {
        it.id == postId
    }

    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        post?.let {
            PostItem(
                imageLoader = imageLoader, post = it,
                onShareButtonClicked = {
                    generateSharingLink(
                        deepLink = "${Constant.PREFIX}/posts/${post.id}".toUri(),
                        previewImageLink = post.imageLink.toUri(),
                        getShareableLink = { generatedLink ->
                            context.shareDeepLink(
                                deepLink = generatedLink
                            )
                        }
                    )
                },
            )
        }
    }
}
