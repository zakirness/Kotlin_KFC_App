package com.example.rosticsnew

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    public var orderCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        onClickNavButton()
        hideNavView(true)
        createButtons()
    }

    fun onClickItem(index: Int){
        var textOrderCount = findViewById<TextView>(R.id.textOrderCount)

        when(index){
            1->orderCount+=1099
            2->orderCount+=899
            3->orderCount+=139
            4->orderCount+=99
            5->orderCount+=129
            6->orderCount+=159
            7->orderCount+=89
            8->orderCount+=79
            9->{
                Toast.makeText(applicationContext, "Тут будет оплата", Toast.LENGTH_SHORT).show();
            }
        }

        textOrderCount.text = "К оплате: " + orderCount.toString() + ".00РУБ"
    }

    fun createButtons() {
        val combo1 = findViewById<ImageView>(R.id.combo1)
        val combo2 = findViewById<ImageView>(R.id.combo2)
        val burger = findViewById<ImageView>(R.id.burgerButton)
        val potato = findViewById<ImageView>(R.id.potatoButton)
        val chicken = findViewById<ImageView>(R.id.chickenButton)
        val basket = findViewById<ImageView>(R.id.basketButton)
        val cola = findViewById<ImageView>(R.id.colaButton)
        val desert = findViewById<ImageView>(R.id.desertButton)
        val buy = findViewById<ImageView>(R.id.navBuyButton)

        combo1.setOnClickListener({onClickItem(1)})
        combo2.setOnClickListener({onClickItem(2)})
        burger.setOnClickListener({onClickItem(3)})
        potato.setOnClickListener({onClickItem(4)})
        chicken.setOnClickListener({onClickItem(5)})
        basket.setOnClickListener({onClickItem(6)})
        cola.setOnClickListener({onClickItem(7)})
        desert.setOnClickListener({onClickItem(8)})
        buy.setOnClickListener({onClickItem(9)})
    }

    fun onClickNavButton(){
        val navButton = findViewById<ImageView>(R.id.navButtonOpen)
        navButton.setOnClickListener({hideNavView(false)})
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home->openActivity(2)
            R.id.nav_exit->openActivity(1)
            R.id.nav_hide->hideNavView(true)
        }
        return true
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

    fun hideNavView(isHide: Boolean){
        val navView = findViewById<NavigationView>(R.id.navMenuView)
        navView.setNavigationItemSelectedListener(this)

        if(isHide){
            navView.visibility = View.GONE
        }else{
            navView.visibility = View.VISIBLE
        }
    }
}