package com.alexandrite.hellokotlin

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>, private val listener : (Item)-> Unit) :
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, p0, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        holder.bindItem(items[p1], listener)
    }

    class ViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView){

        //listener: (Item)-> Unit
        fun bindItem(items: Item, listener: (Item)-> Unit){
            itemView.name.text = items.name
            Glide.with(itemView.context).load(items.image).into(itemView.image)
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }

}