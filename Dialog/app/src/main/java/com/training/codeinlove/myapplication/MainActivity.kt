package com.training.codeinlove.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.show_dialog_btn).setOnClickListener {
            val fragment = ConfirmDeleteDialogFragment()
            fragment.listener = object : ConfirmDeleteDialogFragment.ConfirmDeleteListener {
                override fun onDialogPositiveClick() {
                    Log.i("MainActivity", "onDialogPositiveClick()")
                    val fileListDialogFragment = FileListDialogFragment()
                    fileListDialogFragment.show(supportFragmentManager, "fileList")
                }

                override fun onDialogNegativeClick() {
                    Log.i("MainActivity", "onDialogNegativeClick()")
                }

            }
            fragment.show(supportFragmentManager, "confirmDialog")
        }
    }
}