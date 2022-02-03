package com.dicoding.movieyes.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.movieyes.databinding.ActivitySplashScreenBinding
import com.dicoding.movieyes.ui.main.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    private var activitySplashScreenBinding: ActivitySplashScreenBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        activitySplashScreenBinding = binding
        setContentView(binding.root)

        Handler(mainLooper).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}