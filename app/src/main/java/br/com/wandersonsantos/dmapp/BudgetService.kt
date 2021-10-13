package br.com.wandersonsantos.dmapp

import android.content.Context

object BudgetService {
    fun getBudget(context: Context): List<Budget>{
        val budgets = mutableListOf<Budget>()

        for (i in 1..4){
            var b = Budget()
            b.nome = "Budget $i"
            b.funcionario = "Funcionario $i"
            b.foto = "https://lh3.googleusercontent.com/proxy/27lhYOKsspedhU8joCmfZiCBU60kCu0O14xr_72zrX_VvVKJuQM4rdklImnxkgi142j1aSLeq8VWQ2OnlHuEJqrIhNlcSyPinztsJ793GevewUYe30utXy5bE9GBQSc"
            budgets.add(b)
        }

        return budgets

    }
}