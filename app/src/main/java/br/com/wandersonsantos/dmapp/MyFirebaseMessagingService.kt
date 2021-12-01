package br.com.wandersonsantos.dmapp

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService () {

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d("DMFirebase", "Novo token: $token")
        Prefs.setString("FB_TOKEN", token!!)
    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage?) {

        if (mensagemRemota?.notification != null) {
            val titulo = mensagemRemota?.notification?.title
            var corpo = mensagemRemota?.notification?.body
            Log.d("DMFirebase", "titulo: ${titulo}")
            Log.d("DMFirebase", "corpo: ${corpo}")

            if (mensagemRemota?.data.isNotEmpty()){
                val budgetId = mensagemRemota.data.get("budgetId")
                corpo += "$budgetId"
            }

            val intent = Intent(this, SegundaTela::class.java)

            NotificationUtil.create(1, intent, titulo!!, corpo!!)
        }
    }
}