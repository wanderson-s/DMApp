package br.com.wandersonsantos.dmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_funcionarios.*
import kotlinx.android.synthetic.main.toolbar.*

class FuncionariosActivity : NavigationDrawerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funcionarios)
        setSupportActionBar(toolbar)
        nav_menu_lateral.setCheckedItem(R.id.nav_funcinarios)
        configuraMenuLateral()
    }
}