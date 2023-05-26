package dev.bogibek.dastgoh.ui

import android.os.Build
import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.appcompat.app.AppCompatActivity
import dev.bogibek.dastgoh.databinding.ActivityDetailBinding
import dev.bogibek.dastgoh.model.Detal

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        val detal = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("detal", Detal::class.java)
        } else {
            intent.getSerializableExtra("detal") as Detal
        }

        binding.apply {
            ivBack.setOnClickListener {
                finish()
            }
            detal.let {
                image.setImageResource(it!!.image)
                title.text = it.title
                desc.text = it.desc
            }
        }

    }

    override fun getOnBackInvokedDispatcher(): OnBackInvokedDispatcher {
        finish()
        return super.getOnBackInvokedDispatcher()
    }
}