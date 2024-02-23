package co.edu.uan.android.simpsonsapp215

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import co.edu.uan.android.simpsonsapp215.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    val selectedCharacters = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val simpsonNames = arrayListOf<String>("bart", "lisa")


        setContentView(binding.root)
        binding.btnBart.setOnClickListener {
            binding.simpsonsContainer.removeAllViewsInLayout()
            showSingleSimpson("bart")
        }
        binding.btnHomer.setOnClickListener {
            binding.simpsonsContainer.removeAllViewsInLayout()
            showSingleSimpson("homer")
        }
        binding.btnMarge.setOnClickListener {
            binding.simpsonsContainer.removeAllViewsInLayout()
            showSingleSimpson("marge")
        }
        binding.btnLisa.setOnClickListener {
            binding.simpsonsContainer.removeAllViewsInLayout()
            showSingleSimpson("lisa")
        }
        binding.rbBart.setOnClickListener {
            changeSimpson("bart", it)
        }
        binding.rbHomer.setOnClickListener {
            changeSimpson("homer", it)
        }
        binding.rbMarge.setOnClickListener {
            changeSimpson("marge", it)
        }
        binding.rbLisa.setOnClickListener {
            changeSimpson("lisa", it)
        }

        val myadapter = SimpsonsAdapter(this, R.layout.list_simpsons, simpsonNames)
        binding.lvSimpsons.adapter = myadapter

        binding.lvSimpsons.setOnItemClickListener { parent, view, position, id ->
            println("parent: $parent, view: $view, position $position, id: $id")
            showSingleSimpson(simpsonNames[position].lowercase())
            simpsonNames.add("marge")
            simpsonNames[0]="homer"
            myadapter.notifyDataSetChanged()
            println("array data $simpsonNames")
        }
    }

    fun showSingleSimpson(name: String) {

        val singleLayout = layoutInflater.inflate(R.layout.single_simpson, null)
        val id = resources.getIdentifier(name, "drawable", packageName)
        singleLayout.findViewById<ImageView>(R.id.ivSingleImage).setImageResource(id)
        singleLayout.findViewById<TextView>(R.id.tvSingleName).text = name
        binding.simpsonsContainer.addView(singleLayout)
    }

    fun showSimpsons() {
        binding.simpsonsContainer.removeAllViewsInLayout()
        for(c in selectedCharacters) {
            showSingleSimpson(c)
        }
    }
    fun changeSimpson(name: String, view: View) {
        // add or remove the character in the array
        val cb = view as CheckBox
        if(cb.isChecked)
            selectedCharacters.add(name)
        else
            selectedCharacters.remove(name)
        // show all characters
        showSimpsons()
    }
}