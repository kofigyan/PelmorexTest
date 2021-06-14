package com.example.pelmorextest.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.pelmorextest.R
import com.example.pelmorextest.util.startActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_weather_info).setOnClickListener {
            startActivity<WeatherInfoActivity>()
        }

        findViewById<Button>(R.id.btn_comment).setOnClickListener {
            startActivity<CommentActivity>()
        }

        findViewById<Button>(R.id.btn_photos_display).setOnClickListener {
            startActivity<PhotoActivity>()
        }
    }
}