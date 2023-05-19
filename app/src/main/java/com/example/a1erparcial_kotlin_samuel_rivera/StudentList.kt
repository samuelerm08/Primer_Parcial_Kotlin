package com.example.a1erparcial_kotlin_samuel_rivera

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StudentList : AppCompatActivity(){
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter
    private lateinit var nameToInsert: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.student_list)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = StudentAdapter(applicationContext)
        recyclerView.adapter = adapter

        val sharedPreferences = getSharedPreferences("studentName_Preference", Activity.MODE_PRIVATE)
        nameToInsert = sharedPreferences.getString("studentName", "") ?: ""

        adapter.submitList(createStudentList(nameToInsert))
        adapter.onItemClickListener = { student ->
            val intent = Intent(this, StudentDetail::class.java)
            intent.putExtra("name", student.name)
            intent.putExtra("age", student.age.toString())
            intent.putExtra("url", student.picUrl)
            startActivity(intent)
        }
    }
    private fun createStudentList(name: String): MutableList<Student>? {
        return mutableListOf(
            Student(1, name, 24, "https://e7.pngegg.com/pngimages/788/767/png-clipart-steve-jobs-steve-jobs-thumbnail.png"),
            Student(2, "John", 23, "https://banner2.cleanpng.com/20180712/qvg/kisspng-student-university-and-college-admission-institute-medical-students-5b47ed72b04f14.8766271215314404987222.jpg"),
            Student(3, "Derek", 18, "https://img.freepik.com/premium-psd/student-man-doing-okay-gesture_1187-6944.jpg?w=2000"),
            Student(4, "Tom", 21, "https://w7.pngwing.com/pngs/594/932/png-transparent-man-holding-books-student-humour-english-education-learning-student-people-student-png-arm.png"),
            Student(5, "Andrew", 20, "https://www.pinpng.com/pngs/m/113-1138406_guy-with-bookbag-guy-with-books-png-transparent.png"),
            Student(6, "Kevin", 15, "https://toppng.com/uploads/preview/college-student-png-for-kids-financial-aid-smarts-getting-money-for-school-11562919981qpofd6kn4f.png"),
            Student(7, "Michael", 17, "https://spng.pngfind.com/pngs/s/21-212517_student-free-png-image-college-student-standing-transparent.png"),
            Student(8, "Brian", 18, "https://www.pngfind.com/pngs/m/50-506688_free-png-download-dance-png-images-background-png.png"),
            Student(9, "Phillip", 14, "https://www.pngfind.com/pngs/m/652-6522544_teenager-png-png-download-man-transparent-png.png"),
            Student(10, "Joe", 22, "https://w7.pngwing.com/pngs/6/1/png-transparent-graphy-adolescence-teenager-miscellaneous-tshirt-photography.png")
        )
    }
}