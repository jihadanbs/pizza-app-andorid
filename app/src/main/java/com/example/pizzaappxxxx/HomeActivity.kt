package com.example.pizzaappxxxx

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity() {
    // Function for replace fragment
    private fun replaceFragment(fragment:Fragment){
        val fragmenManager = supportFragmentManager
        val fragmentTrx = fragmenManager.beginTransaction()
        fragmentTrx.replace(R.id.fragmentContainerView, fragment)
        fragmentTrx.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //instance
        val txtAccount:TextView = findViewById(R.id.txtMenuAccount)
        val txtPizza:TextView = findViewById(R.id.txtMenuPizza)
        val txtTransaction:TextView = findViewById(R.id.txtMenuShopping)
        val txtReport:TextView = findViewById(R.id.txtMenuReport)

        //event txtMenuAccount click
        txtAccount.setOnClickListener{
            replaceFragment(AccountFragment())
        }

        //event txtMenuAccount click
        txtPizza.setOnClickListener{
            replaceFragment(MenuFragment())
        }

        //event txtMenuAccount click
        txtTransaction.setOnClickListener{
            replaceFragment(TransactionFragment())
        }

        //event txtMenuAccount click
        txtReport.setOnClickListener{
            replaceFragment(ReportFragment())
        }
    }
}