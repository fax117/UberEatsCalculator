package com.example.ubereatscalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
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
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                createOrder(0.0F)
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (s.toString() == ""){
                    createOrder(0.0F)
                }

            }

        })
    }

    fun createOrder(tip: Float){
        var order = OrderClass(subtotal = parseFloat(subtotal_number_field.text.toString()))

        order.notes = notes_miltiline_field.text.toString()

        order.tip = order.subtotal * tip // tip depends on the user

        order.total_final =
            order.subtotal + order.small_fee + order.service_fee + order.delivery_fee + order.tip

        smal_order_fee_label.text = String.format("$ %.2f", order.small_fee)
        service_fee_label.text = String.format("$ %.2f", order.service_fee)
        delivery_fee_label.text = String.format("$ %.2f", order.delivery_fee)
        place_order_button.text = String.format("Place Order - Delivery \t\t $ %.2f", order.total_final)
    }

    fun saveToList(){
        orders.add()
    }

    fun placeOrder(view: View){
        println("sup")
    }
}
