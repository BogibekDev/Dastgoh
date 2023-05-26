package dev.bogibek.dastgoh.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import dev.bogibek.dastgoh.model.Detal
import dev.bogibek.dastgoh.R

class Adapter(private val list: ArrayList<Detal>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var itemClick: ((Detal) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DetalViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val detal = list[position]
        if (holder is DetalViewHolder) {
            holder.apply {
                image.setImageResource(detal.image)
                title.text = detal.title
                item.setOnClickListener {
                    itemClick?.invoke(detal)
                }
            }
        }
    }

    class DetalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val item = view.findViewById<CardView>(R.id.item)
        val image = view.findViewById<ImageView>(R.id.image)
        val title = view.findViewById<TextView>(R.id.title)
    }
}