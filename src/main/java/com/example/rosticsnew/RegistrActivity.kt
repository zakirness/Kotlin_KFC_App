package com.example.rosticsnew

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rosticsnew.R

class RegistrActivity : AppCompatActivity() {
    var pref:SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registr)

        createButtons()

        // create prefs
        pref = getSharedPreferences("prefs", Context.MODE_PRIVATE)
    }

    fun createButtons(){
        val btnReturnMain = findViewById<Button>(R.id.btn_returnReg)
        val btnRegistr = findViewById<Button>(R.id.btn_registrInput)

        btnReturnMain.setOnClickListener({openActivity(1)})
        btnRegistr.setOnClickListener({onClickRegistr()})
    }

    fun onClickRegistr(){
        val nameInput = findViewById<EditText>(R.id.nameRegInputText)
        val loginInput = findViewById<EditText>(R.id.loginRegInputText)
        val passwordInput = findViewById<EditText>(R.id.passwordRegInputText)
        val nameText = nameInput.getText().toString()
        val loginText = loginInput.getText().toString()
        val passwordText = passwordInput.getText().toString()

        val editor = pref?.edit()
        editor?.putString("name", nameText) //login key
        editor?.putString("login", loginText) //login key
        editor?.putString("password", passwordText) //password key
        editor?.apply()

        Toast.makeText(applicationContext, "Регистрация прошла успешно", Toast.LENGTH_LONG).show()
        openActivity(1)
    }

    fun openActivity(numberActivity: Int){
        val mainPage = Intent(this, MainActivity::class.java)

        when(numberActivity){
            1->startActivity(mainPage)
        }
        finish()
    }
}