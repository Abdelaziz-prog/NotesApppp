package com.ramez.notesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface User_Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun  adduser(user: UserEntity)

    @Query("SELECT * FROM user_table WHERE id =:id")
    suspend fun getUserById(id: Int): UserEntity

    @Query("SELECT * From user_table ")
    fun readAllDate (): Flow<List<UserEntity>>
    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Update
    suspend fun UpdateUser (user: UserEntity)

    @Query("SELECT * FROM user_table WHERE email = :email AND password = :password LIMIT 1")
    suspend fun login(email: String, password: String): UserEntity?
 @Dao
 interface UserDao {

  @Insert
  suspend fun insertUser(user: UserEntity)


 }


}