package com.driverco.famycheck

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class SplashActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private val splashDur = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT*/
        setContentView(R.layout.activity_splash)
        auth = FirebaseAuth.getInstance()
        var intent: Intent
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                Log.v("SPLASH","preselection")

                if (auth.currentUser != null) {
                    Log.v("SPLASH","is not null")
                    intent = Intent(this, MainActivity::class.java)
                }else{
                    Log.v("SPLASH","is null")
                    intent = Intent(this, SignInActivity::class.java)
                }
                startActivity(intent)
                finish()
            }, splashDur.toLong())
        }
    }
}