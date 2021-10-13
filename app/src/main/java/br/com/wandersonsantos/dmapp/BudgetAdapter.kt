package br.com.wandersonsantos.dmapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class BudgetAdapter (
    val budgets: List<Budget>,
    val onClick: (Budget) -> Unit
): RecyclerView.Adapter<BudgetAdapter.BudgetViewHolder>(){

    class BudgetViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardImg: ImageView
        val cardProgresss: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImg = view.findViewById(R.id.card_image)
            cardProgresss = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.card_budget)

        }

    }

    override fun getItemCount() = this.budgets.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_budget, parent, false)
        val holder = BudgetViewHolder(view)

        return holder
    }
    override fun onBindViewHolder(holder: BudgetViewHolder, position: Int){
        val context = holder.itemView.context

        val budget = this.budgets[position]

        holder.cardNome.text = budget.nome
        holder.cardProgresss.visibility = View.VISIBLE

        Picasso.with(context).load(budget.foto).fit().into(holder.cardImg,
            object : com.squareup.picasso.Callback {
                override fun onSuccess(){
                    holder.cardProgresss.visibility = View.GONE
                }
                override  fun onError(){
                    holder.cardProgresss.visibility = View.GONE
                }

            }
            )
        holder.itemView.setOnClickListener {onClick(budget)}



    }
}