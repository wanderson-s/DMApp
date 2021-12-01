package br.com.wandersonsantos.dmapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationUtil {
    val CHANNEL_ID = "1"

    fun createChannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val contexto = DMApplication.getInstance().applicationContext
            val manager = contexto.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val ch = NotificationChannel(CHANNEL_ID, "DMApp", NotificationManager.IMPORTANCE_HIGH)

            manager.createNotificationChannel(ch)
        }
    }

    fun create (id: Int, intent: Intent, titulo: String, texto: String) {
        createChannel()
        val contexto = DMApplication.getInstance().applicationContext
        val p = PendingIntent.getActivity(contexto, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(contexto, CHANNEL_ID)

            .setContentIntent(p)
            .setContentTitle(titulo)
            .setContentText(texto)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)

        with(NotificationManagerCompat.from(DMApplication.getInstance())) {
            val n = builder.build()
            notify(id, n)
        }
    }
}