package com.example.ubereatscalculator

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        window.setFlags(
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
        )

        progressBar.max = 1000
        val current_progress = 1000
        ObjectAnimator.ofInt(progressBar, "progress", current_progress).setDuration(3000).start()

        Handler().postDelayed({
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
            finish() }, 3500)
    }
}