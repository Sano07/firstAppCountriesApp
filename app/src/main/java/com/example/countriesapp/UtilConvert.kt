package com.example.countriesapp

import android.widget.ImageView
import coil3.ImageLoader
import coil3.load
import coil3.request.ImageRequest
import coil3.request.target
import coil3.svg.SvgDecoder
import java.util.Locale

fun convert( list : Map<String, String>) : String {
    return list.values.joinToString { it }
}

fun getFlag (url: Map<String, String>) : String {
    return url["svg"].toString() ?: " "
}

suspend fun loadSvg(imageView: ImageView, url: String) {
    if (url.lowercase(Locale.ENGLISH).endsWith("svg")) {
        val imageLoader = ImageLoader.Builder(imageView.context)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()

        val request = ImageRequest.Builder(imageView.context)
            .data(url)
            .target(imageView)
            .build()

        imageLoader.enqueue(request)
    } else {
        imageView.load(url)
    }
}


