import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ramez.notesapp.data.Note_Dao
import com.ramez.notesapp.data.Note_Entity
import com.ramez.notesapp.data.UserEntity
import com.ramez.notesapp.data.User_Dao

@Database(entities = [UserEntity::class, Note_Entity::class],
    version =  12 , exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao(): User_Dao
    abstract fun noteDao(): Note_Dao


    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null
        fun getDataBase(context: Context): AppDataBase {
            INSTANCE?.let { return it }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "User_dataBase"

                )
                    .fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
         }
   }
}