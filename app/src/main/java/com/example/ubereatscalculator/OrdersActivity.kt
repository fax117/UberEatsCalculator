package com.example.ubereatscalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.list_orders.*
import kotlin.random.Random

class OrdersActivity : AppCompatActivity() {
    private lateinit var orderAdapter: OrderAdapter
    private lateinit var orders : ArrayList<Order>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)
        initRecycler()
    }

    fun initRecycler(){
        orders = ArrayList<Order>()
        orderAdapter = OrderAdapter(orders)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = orderAdapter
        for( i in 0..30){
            val tip = String.format( "%.2f" , Random.nextDouble()* 30 ).toDouble()
            val subtotal = String.format( "%.2f" , Random.nextDouble()* 1000 ).toDouble()
            val total = subtotal + subtotal * tip

            val order = Order(i, subtotal, total, tip)
            orders.add(order)
        }
    }
}