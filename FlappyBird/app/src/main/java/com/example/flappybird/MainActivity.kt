package com.example.flappybird


import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flappybird.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var ulas : ActivityMainBinding

    private var muzukcalar = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        ulas = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(ulas.root)

       skorYaz()

        ulas.buttonBasla.setOnClickListener {
            startActivity(Intent(this@MainActivity,OyunEkraniActivity::class.java))
        }

    }

    fun skorYaz(){
        val sp = getSharedPreferences("sonuc", MODE_PRIVATE)
        val enYuksekSkor = sp.getInt("EnyuksekSkor",0)
        ulas.textViewEnYuksekSkorMain.text = enYuksekSkor.toString()
    }

    override fun onBackPressed() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid())
        super.onBackPressed()
    }
}