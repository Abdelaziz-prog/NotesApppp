package com.ramez.notesapp

import NavigationScreen
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.ramez.notesapp.data.Prefs


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Prefs.init(this)

        //  enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val db = remember { AppDataBase.getDataBase(context) }
            val userDao = remember { db.userDao() }
            val noteDao =remember { db.noteDao() }
            // RegisterScreen()
            //NoteScreen(noteDao = noteDao)
            //Homescreen(noteDao)
            //LoginScreen()
NavigationScreen()
        }
    }
}
