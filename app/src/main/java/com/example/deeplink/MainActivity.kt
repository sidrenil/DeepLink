package com.example.deeplink

import android.content.ClipData
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var siteUrl:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editT:EditText = findViewById(R.id.editT)
        val git_button: Button = findViewById(R.id.git_button)

        val uri = getIntent().data

        if (uri != null){
            openWebSite(uri.toString())
        }

        git_button.setOnClickListener{
            siteUrl = editT.text.toString()
            if (siteUrl != null){
                openWebSite(siteUrl!!)
            }else{
                Toast.makeText(this, "url gir", Toast.LENGTH_LONG).show()
            }

        }


    }
    private fun openWebSite(uri: String){
        val site = DataClass(uri)
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("siteUrl",site)
        startActivity(intent)
    }
}