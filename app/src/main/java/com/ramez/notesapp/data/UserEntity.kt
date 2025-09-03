package com.ramez.notesapp.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity("User_Table")

data class UserEntity (
        @PrimaryKey(autoGenerate = true)
        val id : Int?=null,
        val name : String?,
        val password : String,
        val email: String?
)
