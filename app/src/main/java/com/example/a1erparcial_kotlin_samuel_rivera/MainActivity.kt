package com.example.a1erparcial_kotlin_samuel_rivera

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var inputName: EditText
    private lateinit var addStudentButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputName = findViewById(R.id.nameInput)
        addStudentButton = findViewById(R.id.toStudentsList_button)

        addStudentButton.setOnClickListener {
            val nameEntered = inputName.text.toString().trim()
            if (nameEntered.isNotEmpty())
                sendName(nameEntered)
            else
                Toast.makeText(this, "Must enter at least one name... Try again", Toast.LENGTH_SHORT).show()
        }
    }
    private fun sendName(studentName: String) {
        val sharedPreference = getSharedPreferences("studentName_Preference", Activity.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putString("studentName", studentName)
        editor.apply()
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        val intentToList = Intent(this, StudentList::class.java)
        startActivity(intentToList)
    }
}
