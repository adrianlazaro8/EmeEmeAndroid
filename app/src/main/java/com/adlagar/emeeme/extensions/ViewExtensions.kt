package com.adlagar.emeeme.extensions

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(message: String, time: Int = Snackbar.LENGTH_SHORT){
    Snackbar.make(this, message, time).show()
}