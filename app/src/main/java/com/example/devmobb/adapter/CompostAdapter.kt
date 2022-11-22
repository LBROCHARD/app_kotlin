package com.example.devmobb.adapter

import Compost
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.devmobb.R
import com.example.devmobb.ui.compost.CompostMapsActivity
//import com.example.devmobb.ui.compost.CompostDetailActivity
import currentLocation
import compostSelected

class CompostAdapter(private val composts:List<Compost>, private val context: Context) : RecyclerView.Adapter<CompostAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView : CardView = itemView.findViewById(R.id.cardView)
        var nom_txt : TextView = itemView.findViewById(R.id.nom_txt)
        val lieu_txt : TextView = itemView.findViewById(R.id.lieu_txt)
        val adress_txt : TextView = itemView.findViewById(R.id.adress_txt)
        val categorie_txt : TextView = itemView.findViewById(R.id.categorie_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_compost, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val compost = composts[position]
        holder.nom_txt.text = compost.nom
        holder.adress_txt.text = compost.adresse
        holder.lieu_txt.text = compost.lieu
        holder.categorie_txt.text = compost.categorie

        holder.cardView.setOnClickListener {
            val intent = Intent(context, CompostMapsActivity::class.java)
            intent.putExtra("compost", compost.lieu)
            compostSelected = compost
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return composts.size
    }
}