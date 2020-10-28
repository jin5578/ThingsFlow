package com.tistory.jeongs0222.thingsflow.ui.detail

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("circleImg")
fun circleImg(imageView: ImageView, url: String) {
    Glide.with(imageView)
        .load(url)
        .apply(RequestOptions.circleCropTransform())
        .into(imageView)
}