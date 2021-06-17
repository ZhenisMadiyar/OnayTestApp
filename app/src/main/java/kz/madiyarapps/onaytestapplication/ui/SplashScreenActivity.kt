package kz.madiyarapps.onaytestapplication.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kz.madiyarapps.onaytestapplication.MainActivity
import kz.madiyarapps.onaytestapplication.R

class SplashScreenActivity : AppCompatActivity() {

    private var TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        loadSplashScreen()
    }

    private fun loadSplashScreen() {
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, TIME_OUT)
    }
}