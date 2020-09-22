package com.joaodanieljr.reciclapandroid.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.joaodanieljr.reciclapandroid.R
import com.joaodanieljr.reciclapandroid.model.Materiais
import kotlinx.android.synthetic.main.activity_lista_materiais.*
import kotlinx.android.synthetic.main.lista_materiais_adapter.view.*

class MateriaisAdapter(private val list:List<Materiais>, var clickListener: MaterialListClickListener): RecyclerView.Adapter<MateriaisAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

        private val nome: TextView? = itemView.textView_material
        private val empresa: TextView? = itemView.textView_empresa

        fun bindView(holder:Materiais){

            nome?.text = holder.nome
            empresa?.text = holder.empresa
        }

        fun initialize(item: Materiais,action:MaterialListClickListener){
            nome?.text = item.nome
            empresa?.text = item.empresa

            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista_materiais_adapter,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(list[position])
        holder.initialize(list[position], clickListener)
    }

    override fun getItemCount() = list.count()




}

interface MaterialListClickListener{
    fun onItemClick(item:Materiais, position: Int)
}