package br.com.wandersonsantos.dmapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Budget::class), version = 1)
abstract class DMDatabase: RoomDatabase() {
    abstract  fun budgetDAO() : BudgetDAO
}