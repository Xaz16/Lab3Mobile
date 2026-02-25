package edu.istu.achipiga.lb3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar = findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        val day = intent.getIntExtra(EXTRA_DAY, 1)
        val tip = TipsDataSource.getTips().find { it.dayNumber == day }
        if (tip == null) {
            finish()
            return
        }

        findViewById<TextView>(R.id.detail_day_number).text = getString(R.string.day_label, tip.dayNumber)
        findViewById<TextView>(R.id.detail_title).text = getString(tip.titleResId)
        findViewById<ImageView>(R.id.detail_image).setImageResource(tip.imageResId)
        findViewById<TextView>(R.id.detail_full_description).text = getString(tip.fullDescriptionResId)
    }

    companion object {
        const val EXTRA_DAY = "extra_day"
    }
}
