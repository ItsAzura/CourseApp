package com.example.courseapplication

class Database() {
    fun loadCourse(): List<Course>{
        return listOf<Course>(
            Course(R.string.course1, R.drawable.course1, 100),
            Course(R.string.course2, R.drawable.course2, 100),
            Course(R.string.course3, R.drawable.course3, 100),
            Course(R.string.course4, R.drawable.course4, 100),
            Course(R.string.course5, R.drawable.course5, 100),
            Course(R.string.course6, R.drawable.course6, 100),
            Course(R.string.course7, R.drawable.course7, 100),
            Course(R.string.course8, R.drawable.course8, 100),
        )
    }

}