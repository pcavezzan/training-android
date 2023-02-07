package com.training.codeinlove.myuserdetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = User(name = "Bob", age = 10)
        val showUserDetailsBtn = findViewById<Button>(R.id.show_user_details_btn)
        showUserDetailsBtn.setOnClickListener {
            val intent = Intent(this, UserDetailsActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }
}