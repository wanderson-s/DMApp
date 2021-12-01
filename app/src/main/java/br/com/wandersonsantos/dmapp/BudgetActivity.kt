package br.com.wandersonsantos.dmapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_budget.*
import kotlinx.android.synthetic.main.activity_funcionarios.*
import kotlinx.android.synthetic.main.activity_funcionarios.nav_menu_lateral
import kotlinx.android.synthetic.main.toolbar.*

class BudgetActivity : NavigationDrawerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget)
        setSupportActionBar(toolbar)
        nav_menu_lateral.setCheckedItem(R.id.nav_budget)
        configuraMenuLateral()

        recyclerBudget?.layoutManager = LinearLayoutManager(this)
        recyclerBudget?.itemAnimator = DefaultItemAnimator()
        recyclerBudget?.setHasFixedSize(true)
    }

    fun onClickBudget(budget: Budget){
        Toast.makeText(this, "Cliclou no Budget ${budget.nome}", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
        taskBudgets()
    }

    var budgets = listOf<Budget>()

    fun taskBudgets(){
        Thread {
            this.budgets = BudgetService.getBudget(this)
            runOnUiThread {
                recyclerBudget?.adapter = BudgetAdapter(budgets) { onClickBudget(it) }
                sendNotification(this.budgets.get(1))
            }
        }.start()
    }

    fun sendNotification(budget: Budget) {
        val intent = Intent(this, SegundaTela::class.java)
        NotificationUtil.create(1, intent, "DMApp", "Você tem uma nova atividade de ${budget.nome}")
    }
}