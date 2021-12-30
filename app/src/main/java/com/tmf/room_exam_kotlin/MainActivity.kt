package com.tmf.room_exam_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // https://developer.android.com/training/data-storage/room?hl=en#kts
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()// 지금은 Main Thread에서 동작하도록 허용하지만, 실무에선 background
            .build()

        result_text.text = db.todoDao().getAll().toString()
        add_button.setOnClickListener {
            db.todoDao().insert(Todo(todo_edit.text.toString()))
            result_text.text = db.todoDao().getAll().toString()
        }

    }
}
