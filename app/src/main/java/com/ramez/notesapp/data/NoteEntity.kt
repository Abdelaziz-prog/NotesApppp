package com.ramez.notesapp.data;

import android.icu.text.CaseMap
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity("Note_Table")

data class Note_Entity (
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null ,
    val title: String?,
    val body : String?,
    val timestamp: Long = System.currentTimeMillis(),
    val userId: Int,
// 34an el timestamp
)

