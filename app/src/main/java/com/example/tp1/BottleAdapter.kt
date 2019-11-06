package com.example.tp1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BottleAdapter(private val bottleArray: ArrayList<Bottle>) :
    RecyclerView.Adapter<BottleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottleViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_bottle, parent,
            false)

        return BottleViewHolder(row)
    }

    override fun onBindViewHolder(viewholder: BottleViewHolder, position: Int) {
        val (name, price) = this.bottleArray[position]

        viewholder.txvName.text = name
        viewholder.tvxPrice.text = price.toString()
    }

    override fun getItemCount(): Int {
        return this.bottleArray.size
    }
}
