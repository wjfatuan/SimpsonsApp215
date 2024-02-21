package co.edu.uan.android.simpsonsapp215

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import co.edu.uan.android.simpsonsapp215.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val simpsonNames = arrayListOf<String>("bart", "lisa")


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
        binding.rbBart.setOnClickListener {
            changeSimpson("bart")
        }
        binding.rbHomer.setOnClickListener {
            changeSimpson("homer")
        }
        binding.rbMarge.setOnClickListener {
            changeSimpson("marge")
        }
        binding.rbLisa.setOnClickListener {
            changeSimpson("lisa")
        }

        val myadapter = SimpsonsAdapter(this, R.layout.list_simpsons, simpsonNames)
        binding.lvSimpsons.adapter = myadapter

        binding.lvSimpsons.setOnItemClickListener { parent, view, position, id ->
            println("parent: $parent, view: $view, position $position, id: $id")
            changeSimpson(simpsonNames[position].lowercase())
            simpsonNames.add("marge")
            simpsonNames[0]="homer"
            myadapter.notifyDataSetChanged()
            println("array data $simpsonNames")
        }
    }

    fun changeSimpson(name: String) {
        val id = resources.getIdentifier(name, "drawable", packageName)
        binding.imgSimpson.setImageResource(id)
    }
}