package co.edu.uan.android.simpsonsapp215

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class SimpsonsAdapter(val activity: Activity, val layout: Int, val data: ArrayList<String>)
    : ArrayAdapter<String>(activity, layout, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = activity.layoutInflater.inflate(layout, null)
        val tv = view.findViewById<TextView>(R.id.tvName)
        tv.text = data[position]
        val iv = view.findViewById<ImageView>(R.id.ivPhoto)
        val id = activity.resources.getIdentifier(data[position], "drawable", activity.packageName)
        iv.setImageResource(id)
        return view
    }
}