package com.training.codeinlove.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class GreenActivity : AppCompatActivity() {
    companion object {
        private val TAG = GreenActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_green)
        val action = intent.action
        val hasCategory = intent.hasCategory("UserViewer")
        val extras = intent.extras
        val name = extras?.getString("name")
        val age = extras?.getInt("age")
        Log.i(TAG, "action: $action, isUserViewer: $hasCategory, name: $name, age: $age")
    }
}