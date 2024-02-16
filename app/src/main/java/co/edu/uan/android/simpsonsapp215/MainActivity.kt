package co.edu.uan.android.simpsonsapp215

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.uan.android.simpsonsapp215.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBart.setOnClickListener {
            changeSimpson("bart")
        }
        binding.btnHomer.setOnClickListener {
            changeSimpson("homer")
        }
        binding.btnMarge.setOnClickListener {
            changeSimpson("marge")
        }
        binding.btnLisa.setOnClickListener {
            changeSimpson("lisa")
        }
    }

    fun changeSimpson(name: String) {
        when (name) {
            "homer" -> {
                binding.imgSimpson.setImageResource(R.drawable.homer)
            }
            "marge" -> {
                binding.imgSimpson.setImageResource(R.drawable.marge)
            }
            "lisa" -> {
                binding.imgSimpson.setImageResource(R.drawable.lisa)
            }
            else -> {
                binding.imgSimpson.setImageResource(R.drawable.bart)
            }
        }
    }
}