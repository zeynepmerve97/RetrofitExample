package com.example.apiexample.utils

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.apiexample.R

lateinit var alertDialog: AlertDialog


fun AppCompatActivity.showLoading() {

    val alertDialogBuilder = AlertDialog.Builder(this)
    alertDialogBuilder.setView(R.layout.alert_dialog)
    alertDialogBuilder.setCancelable(false)
    alertDialog = alertDialogBuilder.create()
    alertDialog.window?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.transparent, null)))
    alertDialog.show()
}

fun AppCompatActivity.hideLoading() {
    alertDialog.dismiss()
}