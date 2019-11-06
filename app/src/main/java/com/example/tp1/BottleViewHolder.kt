package com.example.tp1

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BottleViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
    var txvName: TextView
    var tvxPrice: TextView

    init {
        this.txvName = rootView.findViewById(R.id.r_bottle_txv_name)
        this.tvxPrice = rootView.findViewById(R.id.r_bottle_txv_price)
    }
}
