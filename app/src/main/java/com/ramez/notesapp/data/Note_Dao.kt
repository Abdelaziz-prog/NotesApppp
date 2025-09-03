package com.ramez.notesapp.data

import android.icu.text.CaseMap
import android.provider.ContactsContract
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface Note_Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  addNote (noteEntity:Note_Entity)

    @Query  ("SELECT * FROM Note_Table WHERE id =:id")
    suspend fun getNoteById(id: Int): Note_Entity

    @Query("SELECT * From Note_Table  WHERE userId = :UserId ")
    fun readAllDate (UserId:Int): Flow<List<Note_Entity>>
    @Delete
    suspend fun deleteNote(Note : Note_Entity)

    @Update
    suspend fun UpdateNote (Note: Note_Entity)


//    @Query("SELECT * FROM note_table WHERE userId = :userId")
//    suspend fun getNotesForUser(userId: Int): List<Note_Entity>





}