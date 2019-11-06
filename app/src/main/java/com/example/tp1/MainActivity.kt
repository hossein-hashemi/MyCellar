package com.example.tp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val CREATE_BOTTLE_REQUEST_CODE = 42

    val bottleArray: ArrayList<Bottle> = arrayListOf(
        Bottle("Bordeaux", 100.4F),
        Bottle("Cote du Rhones", 42F),
        Bottle("ChateauBrillant", 55F))

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddBottle = findViewById<Button>(R.id.button_add_bottle)
        btnAddBottle.setOnClickListener { view: View? ->
            val intent = Intent(this, CreateBottleActivity::class.java)
            this.startActivityForResult(intent,CREATE_BOTTLE_REQUEST_CODE)
        }

        val adapter = BottleAdapter(bottleArray)
        recyclerView = findViewById<RecyclerView>(R.id.rcv_bottles)
        recyclerView.adapter = adapter
        val layourManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layourManager
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CREATE_BOTTLE_REQUEST_CODE) {
            val bottle: Bottle = data?.getSerializableExtra("CREATED_BOTTLE_EXTRA_KEY") as Bottle
            bottleArray.add(bottle)
            recyclerView.adapter?.notifyDataSetChanged()
            System.out.println(bottleArray)
        }
    }
}
