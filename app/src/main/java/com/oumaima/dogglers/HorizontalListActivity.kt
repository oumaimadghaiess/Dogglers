package com.oumaima.dogglers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oumaima.dogglers.adapter.DogCardAdapter
import com.oumaima.dogglers.const.Layout
import com.oumaima.dogglers.databinding.ActivityHorizontalListBinding

class HorizontalListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHorizontalListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorizontalListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.horizontalRecyclerView.adapter = DogCardAdapter(
            applicationContext,
            Layout.HORIZONTAL
        )

        // Specify fixed size to improve performance
        binding.horizontalRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
