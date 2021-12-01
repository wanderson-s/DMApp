package br.com.wandersonsantos.dmapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : NavigationDrawerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)


        setSupportActionBar(toolbar)
        supportActionBar?.title = "Taimin"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nome_usuario_prefs = Prefs.getString("nome_usuario")
        Toast.makeText(this, "Nome usuário Prefs: $nome_usuario_prefs", Toast.LENGTH_SHORT).show()


        var intent = Intent(this, SegundaTela::class.java)

        var params = Bundle()

        botao_receitas.setOnClickListener{
            params.putString("nome", "RECEITAS")
            intent.putExtras(params)
            startActivity(intent)

        }
        botao_despesas.setOnClickListener{
            params.putString("nome", "DESPESAS")
            intent.putExtras(params)
            startActivity(intent)
        }
        botao_total.setOnClickListener {
            params.putString("nome", "TOTAL")
            intent.putExtras(params)
            startActivity(intent)
        }
        configuraMenuLateral()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView?)?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.action_buscar){
            Toast.makeText(this, "Botão de buscar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_atualizar){
            Toast.makeText(this, "Botão de atualizar", Toast.LENGTH_SHORT).show()
        }else if (id == R.id.action_adicionar){
            Toast.makeText(this, "Botão de adicionar", Toast.LENGTH_SHORT).show()
        }else if (id == android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)
    }




}
