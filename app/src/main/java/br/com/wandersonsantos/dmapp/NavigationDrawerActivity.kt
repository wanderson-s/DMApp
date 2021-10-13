package br.com.wandersonsantos.dmapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

open class NavigationDrawerActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    protected fun configuraMenuLateral(){
        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar,
            R.string.abrir,
            R.string.fechar
        )
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        nav_menu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_budget ->{
                if (className != "BudgetActivity") {
                    val intent = Intent(this, BudgetActivity::class.java)
                    startActivity(intent)
                }
            }
            R.id.nav_funcinarios -> {
                if (className != "FuncionariosActivity"){
                    val intent = Intent(this, FuncionariosActivity::class.java)
                    startActivity(intent)
                }
            }
            R.id.nav_produtos -> {
                if (className != "ProdutosActivity"){
                val intent = Intent(this, ProdutosActivity::class.java)
                startActivity(intent)
                }
            }
            R.id.nav_sair -> {
                finishAffinity()
            }

        }
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }
}