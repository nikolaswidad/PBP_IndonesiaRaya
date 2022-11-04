package com.example.android_service_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {


    private var acapella: Button? = null
    private var intro: Button? = null
    private var stanza: Button? = null
    private var stop: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        acapella = findViewById<View>(R.id.btn_acapela) as Button
        intro = findViewById<View>(R.id.btn_intro) as Button
        stanza = findViewById<View>(R.id.btn_stanza) as Button
        stop = findViewById<View>(R.id.btn_stop) as Button

        acapella!!.setOnClickListener(this)
        intro!!.setOnClickListener(this)
        stanza!!.setOnClickListener(this)
        stop!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        if (view.id == R.id.btn_acapela) {
            val intent = Intent(this, MusicService::class.java)
            intent.putExtra("type", "acapella")
            startService(intent)
        } else if (view.id == R.id.btn_intro) {
            val intent = Intent(this, MusicService::class.java)
            intent.putExtra("type", "intro")
            startService(intent)
        } else if (view.id == R.id.btn_stanza) {
            val intent = Intent(this, MusicService::class.java)
            intent.putExtra("type", "stanza")
            startService(intent)
        }

        else if (view === stop) {

            stopService(Intent(this, MusicService::class.java))

        }
    }
}