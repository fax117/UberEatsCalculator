package com.example.ubereatscalculator

import android.graphics.Color.RED
import android.graphics.Color.red
import android.hardware.camera2.params.RggbChannelVector.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.lang.Float.parseFloat
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    val orders = mutableListOf<OrderClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeText()
    }

    fun onclick0(view: View) {
        createOrder(0.00F)
    }
    fun onclick10(view: View) {
        createOrder(0.10F)
    }
    fun onclick15(view: View) {
        createOrder(0.15F)
    }
    fun onclick20(view: View) {
        createOrder(0.20F)
    }
    fun onclick25(view: View) {
        createOrder(0.25F)
    }

    fun changeText(){
        subtotal_number_field.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                createOrder(0.0F)
            }
        })
    }

    fun createOrder(tip: Float){

        var order: OrderClass = if (subtotal_number_field.text== null || subtotal_number_field.text.isEmpty() || subtotal_number_field.text.isBlank()) {
            OrderClass(subtotal = 0.0F )
        } else{
            OrderClass(subtotal = parseFloat(subtotal_number_field.text.toString()))
        }

        order.id = orders.size + 1
        order.notes = notes_miltiline_field.text.toString()

        order.tip = order.subtotal * tip // tip depends on the user

        order.total_final =
            order.subtotal + order.small_fee + order.service_fee + order.delivery_fee + order.tip

        smal_order_fee_label.text = String.format("$ %.2f", order.small_fee)
        service_fee_label.text = String.format("$ %.2f", order.service_fee)
        delivery_fee_label.text = String.format("$ %.2f", order.delivery_fee)
        place_order_button.text = String.format("Place Order - Delivery \t\t $ %.2f", order.total_final)

        place_order_button.setOnClickListener{
            placeOrder(order)
        }
    }

    fun placeOrder(order: OrderClass){
        orders.add(order)
        subtotal_number_field.text.clear()
        changeText()

        Log.d("order", "Orders: ${orders.toString()}")
    }
}
