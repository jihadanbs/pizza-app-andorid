package com.example.pizzaappxxxx

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_account)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //set data
        val txtNama:EditText = findViewById(R.id.editTextText)
        val txtEmail:EditText = findViewById(R.id.editTextText2)
        val txtPassword:EditText = findViewById(R.id.editTextText3)
        val txtLevel:EditText = findViewById(R.id.editTextText4)

        txtNama.setText(LoginActivity.name)
        txtEmail.setText(LoginActivity.email)
        txtPassword.setText(LoginActivity.password)
        txtLevel.setText(LoginActivity.level)

        //implicit intent
        //call dial number activity
        val dial:LinearLayout = findViewById(R.id.linearLayout)
        dial.setOnClickListener {
            val dialIntent:Intent = Uri.parse("tel:085743439096").let {
                number->Intent(Intent.ACTION_DIAL,number)
            }
            startActivity(dialIntent)
        }

        //call web page activity
        val website:LinearLayout = findViewById(R.id.linearLayout2)
        website.setOnClickListener {
            val webIntent:Intent = Uri.parse("https://home.amikom.ac.id/").let {
                webpage->Intent(Intent.ACTION_VIEW,webpage)
            }
            startActivity(webIntent)
        }

        //call maps activity
        val maps:LinearLayout = findViewById(R.id.linearLayout3)
        maps.setOnClickListener {
            val mapIntent:Intent = Uri.parse("geo:47.6,-122,3?z=11").let {
                    gmaps->Intent(Intent.ACTION_VIEW,gmaps)
            }
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}