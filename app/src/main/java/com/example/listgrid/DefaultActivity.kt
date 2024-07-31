package com.example.listgrid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class DefaultActivity : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var imageView: ImageView
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_default)
        mAuth = FirebaseAuth.getInstance()

        loginButton = findViewById(R.id.loginButton)
        registerButton = findViewById(R.id.registerButton)
        imageView = findViewById(R.id.imageView)  // Pastikan ID ini sesuai dengan yang ada di file XML Anda

        loginButton.setOnClickListener {
            startActivity(Intent(this@DefaultActivity, LoginActivity::class.java))
        }
        registerButton.setOnClickListener {
            startActivity(Intent(this@DefaultActivity, RegisterActivity::class.java))
        }

    }

    private fun checkUserSession() {
        val currentUser: FirebaseUser? = mAuth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this@DefaultActivity, MainActivity::class.java))
            finish()
        }
    }
}
