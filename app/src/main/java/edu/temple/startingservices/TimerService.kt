package edu.temple.startingservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        TODO()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        runTimer(intent?.getStringExtra("timer")!!.toInt())
        return super.onStartCommand(intent, flags, startId)
    }

    private fun runTimer(num : Int) {
        CoroutineScope(Job() + Dispatchers.Default).launch {
            for(i in num downTo 0){
                Log.d("countdown", (i).toString())
                delay(1000)
            }
            stopSelf()
        }.start()
    }
}