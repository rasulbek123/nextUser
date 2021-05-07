package com.example.add_item_and_delete_item_options

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView

class ListViewAdapter:RecyclerView.Adapter<ListViewHolder>() {
    var models:MutableList<User> = mutableListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    var OnClickOpstions:()->Unit = {}
    fun UserAdd(){
        models.add(User("User name ${models.size+1}","User lastname ${models.size+1}"))
        notifyDataSetChanged()
    }
    fun removerUser(position: Int){
        models.removeAt(position)
        notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var itemView:View = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.populeatmodel(models[position],OnClickOpstions)
    }

    override fun getItemCount(): Int {
        return models.size
    }
}