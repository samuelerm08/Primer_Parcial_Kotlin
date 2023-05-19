package com.example.a1erparcial_kotlin_samuel_rivera

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class StudentDetail: AppCompatActivity() {
    private lateinit var studentName: TextView
    private lateinit var studentAge: TextView
    private lateinit var studentPhoto: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        studentName = findViewById(R.id.studentNameOnDetail)
        studentAge = findViewById(R.id.studentAgeOnDetail)
        studentPhoto = findViewById(R.id.studentPhotoOnDetail)

        val bundle = intent.extras
        val getName = bundle?.getString("name", "")
        val getAge = bundle?.getString("age", "")
        val getUrl = bundle?.getString("url") ?: ""

        studentName.text = "Name: $getName"
        studentAge.text = "Age: $getAge"

        Glide.with(applicationContext)
            .load(getUrl)
            .into(studentPhoto)
    }
}