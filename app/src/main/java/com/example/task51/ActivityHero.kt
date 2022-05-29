package com.example.task51

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import coil.load

class ActivityHero : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero)

        val image = findViewById<ImageView>(R.id.image)
        val name = findViewById<TextView>(R.id.name)
        val health = findViewById<TextView>(R.id.text_health)
        val mana = findViewById<TextView>(R.id.text_mana)
        val attackType = findViewById<TextView>(R.id.attack_type)
        val textRoles = findViewById<TextView>(R.id.roles)

        image.load(intent.getStringExtra("imageUrl"))
        name.text = intent.getStringExtra("name")
        health.text = intent.getStringExtra("health")
        mana.text = intent.getStringExtra("mana")
        attackType.text = "Attack type: ${intent.getStringExtra("attackType")}"
        val roles = intent.getStringArrayExtra("roles")
        var stringRoles = ""
        for (i in roles!!.indices){
            stringRoles += "${roles[i]} "
        }
        textRoles.text = "Roles: $stringRoles"
    }
}