package com.example.pizzaappxxxx

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    companion object{
        var name = "Stevi Ema Wijayanti"
        var email = "stevi.ema@amikom.ac.id"
        var password = "kasir123"
        var level = "Cashier"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //login validation -> if true call activity Account
        val txtUsername:EditText = findViewById(R.id.editTextText3)
        val txtPassword:EditText = findViewById(R.id.editTextText4)
        val btnLogin:Button = findViewById(R.id.button2)
        btnLogin.setOnClickListener {
            if(txtUsername.text.toString().equals(email) &&
                txtPassword.text.toString().equals(password)){
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Login failed, Check your email and password",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}