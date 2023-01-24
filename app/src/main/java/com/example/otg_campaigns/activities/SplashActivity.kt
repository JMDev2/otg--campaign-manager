package com.example.otg_campaigns.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.otg_campaigns.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)
    window.setFlags(
        WindowManager.LayoutParams.FLAGS_CHANGED,
        WindowManager.LayoutParams.FLAGS_CHANGED
    )
    Handler(Looper.getMainLooper()).postDelayed({
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }, 3000) // 3000 is the delayed time in milliseconds.
}
}
