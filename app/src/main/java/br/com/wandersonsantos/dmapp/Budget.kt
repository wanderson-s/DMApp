package br.com.wandersonsantos.dmapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budget")
class Budget {

    @PrimaryKey
    var id: Long? = null
    var nome = ""
    var funcionario = ""
    var foto = ""
}