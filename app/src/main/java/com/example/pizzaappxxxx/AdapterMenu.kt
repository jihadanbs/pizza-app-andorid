package com.example.pizzaappxxxx

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class AdapterMenu (private val listMenu:List<MenuModel>): RecyclerView.Adapter<AdapterMenu.ViewHolder>() {
    inner class ViewHolder(v: View):RecyclerView.ViewHolder(v) {
        val imgFotoMenu: ImageView
        val textNamaMenu: TextView
        val textHargaMenu: TextView
        val btnAddMenu: TextView
        val context = v.context;

        init {
            imgFotoMenu = v.findViewById(R.id.imageViewMenu)
            textNamaMenu = v.findViewById(R.id.textViewNamaMenu)
            textHargaMenu = v.findViewById(R.id.textViewHargaMenu)
            btnAddMenu = v.findViewById(R.id.textViewAddMenu)
        }
    }
    override fun  onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.card_layout_menu,
            parent, false)
        return ViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return  listMenu.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val modelMenu = listMenu[position]
        holder.imgFotoMenu.setImageResource(modelMenu.gambar)
        holder.textNamaMenu.text = modelMenu.namaMenu
        holder.textHargaMenu.text = modelMenu.harga
    }
}