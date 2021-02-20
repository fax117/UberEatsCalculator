package com.example.ubereatscalculator

import android.text.Editable
import kotlin.math.roundToInt
import kotlin.math.roundToLong

data class OrderClass(var subtotal: Float){
    var id : Int = 0
    var small_fee: Float = subtotal * 0.02F
    var service_fee: Float = subtotal * 0.05F
    var delivery_fee: Float = subtotal * 0.10F
    var tip: Float = 0.0F
    var total_final: Float = 0.0F
    var notes: String = ""
    override fun toString(): String = "Order $id = $ $total_final"
}

fun main(){
    var order1 = OrderClass(subtotal = 0.0F)

    order1.tip = order1.subtotal * 0.10F // tip depends on the user

    order1.total_final = order1.subtotal + order1.small_fee + order1.service_fee + order1.delivery_fee + order1.tip

    println(order1)
    println(order1.subtotal)
    println(order1.small_fee)
    println(order1.service_fee)
    println(order1.delivery_fee)
    println(order1.tip)
    println(order1.total_final)
}