package br.com.wandersonsantos.dmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_funcionarios.*
import kotlinx.android.synthetic.main.toolbar.*

class ProdutosActivity : NavigationDrawerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtos)
        setSupportActionBar(toolbar)
        nav_menu_lateral.setCheckedItem(R.id.nav_produtos)
        configuraMenuLateral()
    }
}