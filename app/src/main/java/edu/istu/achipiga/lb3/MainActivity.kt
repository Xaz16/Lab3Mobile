package edu.istu.achipiga.lb3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar).apply {
            setTitle(R.string.screen_title)
        }

        val recycler = findViewById<RecyclerView>(R.id.recycler_tips)
        recycler.layoutManager = LinearLayoutManager(this)
        val tips = TipsDataSource.getTips()
        recycler.adapter = TipsAdapter(tips) { tip ->
            startActivity(Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_DAY, tip.dayNumber)
            })
        }
    }
}
