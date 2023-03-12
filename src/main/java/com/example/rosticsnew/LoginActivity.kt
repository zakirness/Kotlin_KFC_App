package com.example.rosticsnew

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.rosticsnew.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        createButtons()
    }

    fun createButtons(){
        val btnReturnMain = findViewById<Button>(R.id.btn_returnReg)
        val btnLogin = findViewById<Button>(R.id.btn_loginInput)

        btnReturnMain.setOnClickListener({openActivity(1)})
        btnLogin.setOnClickListener({onClickLogin()})
    }

    fun openActivity(numberActivity: Int){
        val mainPage = Intent(this, MainActivity::class.java)
        val homePage = Intent(this, HomeActivity::class.java)

        when(numberActivity){
            1->startActivity(mainPage)
            2->startActivity(homePage)
        }
        finish()
    }

    fun onClickLogin(){
        val loginInput = findViewById<EditText>(R.id.loginInputText)
        val passwordInput = findViewById<EditText>(R.id.passwordInputText)
        val loginText = loginInput.getText().toString()
        val passwordText = passwordInput.getText().toString()

        // check prefs
        var pref = getSharedPreferences("prefs", Context.MODE_PRIVATE)

        if(loginText == pref.getString("login","0")!! && passwordText == pref.getString("password","0")!!){
            Toast.makeText(applicationContext, "Добро пожаловать, " + pref.getString("name", "0")!!, Toast.LENGTH_LONG).show()
            openActivity(2)
        }else{
            Toast.makeText(applicationContext, "Пользователя нет", Toast.LENGTH_LONG).show()
        }
    }
}