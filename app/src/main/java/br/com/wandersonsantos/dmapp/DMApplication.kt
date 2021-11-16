package br.com.wandersonsantos.dmapp

import android.app.Application
import java.lang.IllegalStateException

class DMApplication : Application () {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: DMApplication? = null

        fun getInstance(): DMApplication {
            if (appInstance == null){
                throw IllegalStateException("Configurar application no Manifest")
            }
            return appInstance!!
        }
    }
}