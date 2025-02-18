package com.example.countriesapp
import android.widget.ImageView
import java.util.Locale
import android.graphics.drawable.PictureDrawable
import com.caverock.androidsvg.SVG
import com.squareup.picasso.Picasso
import java.io.InputStream

fun convert( list : Map<String, String>) : String {
    return list.values.joinToString { it }
}

fun getFlag (url: Map<String, String>) : String {
    return url["png"].toString()
}

fun loadSvgWithPicasso(imageView: ImageView, url: String) {
    Picasso.get().load(url).into(imageView)
}

