package com.example.android_service_kotlin

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings


class MusicService : Service() {

    // declaring object of MediaPlayer
    private lateinit var mp:MediaPlayer


    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val type = intent.getStringExtra("type")
        if (type == "stanza") {
            mp = MediaPlayer.create(this, R.raw.stanza)
        } else if (type == "acapella") {
            mp = MediaPlayer.create(this, R.raw.acapella)
        } else if (type == "intro") {
            mp = MediaPlayer.create(this, R.raw.intro)
        }
        mp.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.stop()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}


