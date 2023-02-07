package com.training.codeinlove.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startGreenActivityBtn = findViewById<Button>(R.id.start_activity_green_btn)
        startGreenActivityBtn.setOnClickListener {
            println("Start green activity button clicked !")
            val intent = Intent(this, GreenActivity::class.java)
            intent.action = Intent.ACTION_VIEW
            intent.addCategory("UserViewer")
            intent.putExtra("name", "Bob")
            intent.putExtra("age", 16)
            startActivity(intent)
        }
    }
}