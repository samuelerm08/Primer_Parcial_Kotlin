package com.example.a1erparcial_kotlin_samuel_rivera

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class StudentAdapter(val context: Context) :
    ListAdapter<Student, StudentAdapter.ViewHolder>(DiffCallBack){
    lateinit var onItemClickListener: (Student) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val studentName: TextView = view.findViewById(R.id.studentName)
        private val studentPhoto: ImageView = view.findViewById(R.id.studentPhoto)

        fun bind(student: Student) {
            studentName.text = "Student: ${student.name}"
            Glide.with(context)
                .load(student.picUrl)
                .into(studentPhoto)
            view.setOnClickListener {
                onItemClickListener(student)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.student_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = getItem(position)
        holder.bind(student)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Student>() {
        override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem == newItem
        }
    }
}