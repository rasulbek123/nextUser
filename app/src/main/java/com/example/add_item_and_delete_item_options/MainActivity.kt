package com.example.add_item_and_delete_item_options

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var adapter = ListViewAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter
        adapter.OnClickOpstions = {
            fun onOptionButtonClick(view: View) {
                val optionMenu = PopupMenu(this, view)
                val menuInflater = optionMenu.menuInflater
                menuInflater.inflate(R.menu.menu_option_item, optionMenu.menu)
                optionMenu.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.add -> {
                            adapter.UserAdd()
                        }
                        R.id.delete -> {
                            adapter.removerUser()
                        }

                    }
                    return@setOnMenuItemClickListener true
                }
                optionMenu.show()
            }
        }
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        setData(1)
    }

    fun setData(count: Int) {
        var models: MutableList<User> = mutableListOf()
        for (i in 0 until count) {
            var model: User = User("User name ${i + 1}", "User Lastname ${i + 1}")
            models.add(model)
        }
        adapter.models = models
    }
}
