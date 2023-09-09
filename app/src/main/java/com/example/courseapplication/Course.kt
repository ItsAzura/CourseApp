package com.example.courseapplication

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(
    @StringRes val title: Int,
    @DrawableRes val pic: Int,
    val member: Int,
)
