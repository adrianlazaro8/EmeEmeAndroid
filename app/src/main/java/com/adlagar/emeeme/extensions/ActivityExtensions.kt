package com.adlagar.emeeme.extensions

import android.app.Activity
import android.content.Intent
import android.os.Bundle

inline fun <reified T: Activity> Activity.startActivity(extras: Bundle.() -> Unit = {}){
    val intent = Intent(this, T::class.java)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}