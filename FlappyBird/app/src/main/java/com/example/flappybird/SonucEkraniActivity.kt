package com.example.flappybird


import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flappybird.databinding.ActivitySonucEkraniBinding

class SonucEkraniActivity : AppCompatActivity() {
    private lateinit var ulas : ActivitySonucEkraniBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        ulas = ActivitySonucEkraniBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(ulas.root)

       skorYaz()

        ulas.buttonYenidenBasla.setOnClickListener {
            startActivity(Intent(this,OyunEkraniActivity::class.java))
            finish()
        }

        ulas.buttonAnaMenuDon.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }

    fun skorYaz(){
        val sp = getSharedPreferences("sonuc", MODE_PRIVATE)
        val enYuksekSkor = sp.getInt("EnyuksekSkor",0)

        val gelenSkor = intent.getIntExtra("skor",0)
        ulas.textViewSonucSkor.text = gelenSkor.toString()

        if (gelenSkor > enYuksekSkor){
            val editor = sp.edit()
            editor.putInt("EnyuksekSkor",gelenSkor)
            editor.commit()
            ulas.textViewSonucEnYuksekSkor.text = gelenSkor.toString()
        }
        else{
            ulas.textViewSonucEnYuksekSkor.text = enYuksekSkor.toString()
        }

    }

}