package com.example.tp1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_create_bottle.*

class CreateBottleActivity : AppCompatActivity() {

    public val CREATED_BOTTLE_EXTRA_KEY = "CREATED_BOTTLE_EXTRA_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_bottle)

        val saveButton = findViewById<Button>(R.id.save_button)
        saveButton.setOnClickListener {
            var name: String = edit_name.text.toString()
            var price: Float = edit_price.text.toString().toFloat()
            val bottle: Bottle = Bottle(name,price)
            stopActivityAndReturnResult(bottle)
        }
    }

    fun stopActivityAndReturnResult(bottle:Bottle) {
        val returnIntent = Intent()
        returnIntent.putExtra(CREATED_BOTTLE_EXTRA_KEY, bottle)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }
}
