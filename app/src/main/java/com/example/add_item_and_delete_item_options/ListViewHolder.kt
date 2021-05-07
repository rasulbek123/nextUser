package com.example.add_item_and_delete_item_options

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ListViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    fun populeatmodel(user: User,OnClickOptions:()->Unit){
        itemView.userName.text = user.Name
        itemView.userLastname.text = user.LastName
        itemView.btnOptions.setOnClickListener {
            OnClickOptions()
        }
    }
}