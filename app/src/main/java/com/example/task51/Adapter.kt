package com.example.task51

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class Adapter(private val data: ArrayList<Hero>, private val activity: Activity): RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val icon = view.findViewById<ImageView>(R.id.icon)!!
        val name = view.findViewById<TextView>(R.id.name)!!
        val health = view.findViewById<TextView>(R.id.text_health)!!
        val mana = view.findViewById<TextView>(R.id.text_mana)!!
        val card = view.findViewById<CardView>(R.id.card)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hero = data[position]
        holder.name.text = hero.name
        holder.health.text = hero.health.toString()
        holder.mana.text = hero.mana.toString()
        holder.icon.load("https://api.opendota.com${hero.iconUrl}")
        holder.card.setOnClickListener{
            val intent = Intent(activity, ActivityHero::class.java)
            intent.putExtra("name", hero.name)
            intent.putExtra("imageUrl", "https://api.opendota.com${hero.imageUrl}")
            intent.putExtra("mana", hero.mana.toString())
            intent.putExtra("health", hero.health.toString())
            intent.putExtra("roles", hero.roles)
            intent.putExtra("attackType", hero.attackType)
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = data.size
}