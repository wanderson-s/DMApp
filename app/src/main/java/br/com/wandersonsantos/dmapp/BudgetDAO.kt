package br.com.wandersonsantos.dmapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BudgetDAO {

    @Query("SELECT * FROM budget WHERE id=:id")
    fun getById(id: Long): Budget?

    @Query("SELECT * FROM budget")
    fun findAll(): List<Budget>

    @Insert
    fun insert(budget: Budget)

    @Delete
    fun delete(budget: Budget)
}