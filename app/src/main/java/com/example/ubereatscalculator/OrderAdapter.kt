package com.example.ubereatscalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter(private val orders: List<Order>): RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {
    inner class OrderViewHolder(renglon: View): RecyclerView.ViewHolder(renglon){
        var order_total = renglon.findViewById<TextView>(R.id.total)
        var order_id = renglon.findViewById<TextView>(R.id.order_id)
    }

    // Crea el renglón
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val renglon_layout = inflater.inflate(R.layout.renglon_layout, parent, false)
        return OrderViewHolder(renglon_layout)
    }

    // Asocia datos con los elementos del renglón
    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val dato = orders[position]
        val order_subtotal = dato.subtotal
        val order_total = dato.total
        val order_id = dato.id
        val order_tip = dato.tip * 100
        holder.order_total.text = "Oder # $order_id Total: $order_total"
        holder.order_id.text = "$order_subtotal with tip of: % $order_tip"
    }

    // Cuantos elementos tiene la lista
    override fun getItemCount(): Int {
        return orders.size
    }
}