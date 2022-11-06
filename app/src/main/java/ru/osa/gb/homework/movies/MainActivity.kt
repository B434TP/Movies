package ru.osa.gb.homework.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val father = Person("Nick", 45)
        val mother = Person("Kira", 40)

        val uncle = Prisoner("never", "BobKiller", 38)


        var cnt = Repository.getCount()

        val mainBtn = findViewById<Button>(R.id.mainBtn)
        mainBtn.setOnClickListener {
            Toast.makeText(this@MainActivity, "Repository.getCount: $cnt", Toast.LENGTH_LONG).show()
        }

    }
}

open class Person (var name: String = "Ivan", var age: Int)


class Prisoner (var outDate: String, name: String, age: Int) : Person(name, age);

data class Movie (var title: String, var year: Int)

object Repository {
    private val moviesList : List<Movie> = emptyList()


    fun getMoviesListing(): List<Movie> {
        return moviesList
    }

    fun getCount() = moviesList.size


    fun addMovie (newMovie : Movie) {
        moviesList.plus(newMovie)
    }

}

