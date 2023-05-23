package com.onesignal.in_appmessaging.fragment

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import coil.ImageLoader
import com.onesignal.in_appmessaging.components.PostItem
import com.onesignal.in_appmessaging.datasource.FakeData
import com.onesignal.in_appmessaging.navigation.Navigation
import com.onesignal.in_appmessaging.util.Constant
import com.onesignal.in_appmessaging.util.generateSharingLink
import com.onesignal.in_appmessaging.util.shareDeepLink

@Composable
fun ListPostScreen(
    imageLoader: ImageLoader,
    navController: NavController
) {
    LazyColumn(
        contentPadding = PaddingValues(20.dp)
    ) {
        items(FakeData.listOfPost) { post ->
            val context = LocalContext.current

            PostItem(imageLoader = imageLoader,
                post = post,
                onShareButtonClicked = {
                    generateSharingLink(
                        deepLink = "${Constant.PREFIX}/post/${post.id}".toUri(),
                        previewImageLink = post.imageLink.toUri(),
                        getShareableLink = { generatedLink ->
                            context.shareDeepLink(
                                deepLink = generatedLink
                            )
                        }
                    )
                },
                onPostClicked = {
                    navController.navigate("${Navigation.PostDetailScreen.route}/${post.id}")
                }
            )
        }
    }
}

