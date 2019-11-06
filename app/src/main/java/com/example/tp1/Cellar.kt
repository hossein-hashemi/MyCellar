package com.example.tp1

class Cellar {

    val bottleArray: ArrayList<Bottle> = arrayListOf()

    fun addBottle(name: String, price: Float){
        val bottle = Bottle(name, price)

        bottleArray.add(bottle)
    }

    fun getBottle(name: String): Bottle?{
        val bottle:Bottle?

        bottle = bottleArray.find { bottle -> bottle.name == name }

        return bottle
    }

    fun getTotalPriceInEuros():Float{
        var sum = 0f
        for (bottle in bottleArray) {
            sum =+ bottle.price
        }
        return sum
    }

    fun getTotalPriceInDollars(): Float{
        val euro = getTotalPriceInEuros()

        return euro/0.8f
    }

    fun getNumberOfBottle(): Int{
        return bottleArray.size
    }
}