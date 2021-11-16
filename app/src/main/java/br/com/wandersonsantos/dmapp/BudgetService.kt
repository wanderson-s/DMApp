package br.com.wandersonsantos.dmapp

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.Exception
import java.net.URL

object BudgetService {
    var host = "https://api-budget-v1.azurewebsites.net"

    fun getBudget(context: Context): List<Budget>{

        try {
            var budgets = mutableListOf<Budget>()
            val url = "$host/budgets"
            val json = HttpHelper.get(url)

            Log.d("SERVICETAG", json)

            budgets = parserJson<MutableList<Budget>>(json)

            saveDB(budgets)
            return budgets
        } catch (e: Exception) {
            var budgets = DatabaseManager.getBudgetDAO().findAll()

            return budgets
        }

    }
    private fun saveDB(budgets: List<Budget>){
        for (b in budgets){
            val ex = DatabaseManager.getBudgetDAO().getById(b.id!!)
            if (ex == null){
                DatabaseManager.getBudgetDAO().insert(b)
            }
        }
    }

    fun saveBudget (budget: Budget) {
        val url = "$host/budgets"
        var json = HttpHelper.post(url, GsonBuilder().create().toJson(budget))
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson<T>(json, type)
    }
}