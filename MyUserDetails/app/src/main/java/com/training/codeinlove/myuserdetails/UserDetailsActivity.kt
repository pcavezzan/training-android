package com.training.codeinlove.myuserdetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        val user = intent.extras?.getParcelable<User>("user")
        findViewById<TextView>(R.id.name).text = "Nom: ${user?.name}"
        findViewById<TextView>(R.id.age).text = "Age: ${user?.age}"
    }
}