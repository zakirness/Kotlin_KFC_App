package com.example.rosticsnew

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.rosticsnew.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // find buttons and set click functions
        createButtons()
    }

    fun createButtons(){
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnRegistr = findViewById<Button>(R.id.btn_register)

        btnLogin.setOnClickListener({openActivity(1)})
        btnRegistr.setOnClickListener({openActivity(2)})
    }

    fun openActivity(numberActivity: Int){
        val loginPage = Intent(this, LoginActivity::class.java)
        val registrPage = Intent(this, RegistrActivity::class.java)

        when(numberActivity){
            1->startActivity(loginPage)
            2->startActivity(registrPage)
        }
        finish()
    }
}