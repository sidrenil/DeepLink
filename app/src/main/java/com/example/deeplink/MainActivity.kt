package com.example.deeplink

import android.content.ClipData
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    private var siteUrl: String? = null
    lateinit var banner1 : AdView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}

        val banner1 : AdView = findViewById(R.id.banner1)
        val adRequest = AdRequest.Builder().build()
        banner1.loadAd(adRequest)

        val editT: EditText = findViewById(R.id.editT)
        val git_button: Button = findViewById(R.id.git_button)
        val uri = getIntent().data

        if (uri != null) {
            openWebSite(uri.toString())
        }

        git_button.setOnClickListener {
            siteUrl = editT.text.toString()

            if (siteUrl.isNullOrEmpty()) {
                Toast.makeText(this, "url gir", Toast.LENGTH_SHORT).show()

            } else {
                openWebSite(siteUrl!!)
            }
        }
    }
    private fun openWebSite(uri: String) {
        val site = DataClass(uri)
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("siteUrl", site)
        startActivity(intent)
    }
}





