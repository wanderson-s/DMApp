package br.com.wandersonsantos.dmapp

import androidx.room.Room

object DatabaseManager {
    private var dbInstance: DMDatabase

    init {
        val context = DMApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            DMDatabase::class.java,
            "dm.sqlite"
        ).build()
    }

    fun getBudgetDAO(): BudgetDAO {
        return dbInstance.budgetDAO()
    }
}