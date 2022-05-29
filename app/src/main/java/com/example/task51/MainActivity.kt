package com.example.task51

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.*
import java.io.IOException
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = ArrayList<Hero>()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        val okHttpClient = OkHttpClient()
        val request = Request.Builder().url("https://api.opendota.com/api/herostats").build()
        okHttpClient.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                this@MainActivity.runOnUiThread{

                    val type = Types.newParameterizedType(List::class.java, Hero::class.java)
                    val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                    val adapter = moshi.adapter<ArrayList<Hero>>(type)
                    val allHeroes: ArrayList<Hero>? = adapter.fromJson(response.body!!.string())
                    recyclerView.adapter = Adapter(allHeroes!!, this@MainActivity)
                }
            }

        })

    }
}
data class Users (val user: List<Hero>)