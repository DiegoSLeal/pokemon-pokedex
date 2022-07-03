package br.com.fabricadesinapse.pokemon_pokedex.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fabricadesinapse.pokemon_pokedex.R
import br.com.fabricadesinapse.pokemon_pokedex.domain.Pokemon

class PokemonAdapter(
  private val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)

    return ViewHolder(view)
  }

  override fun getItemCount(): Int {
    return items.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = items[position]

    holder.bindView(item)
  }

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(item: Pokemon) = with(itemView) {

      val imageViewPokemon = findViewById<ImageView>(R.id.ImageViewPokemon)
      val textViewNumber = findViewById<TextView>(R.id.textViewNumber)
      val textViewName = findViewById<TextView>(R.id.textViewName)
      val textViewType1 = findViewById<TextView>(R.id.textViewType1)
      val textViewType2 = findViewById<TextView>(R.id.textViewType2)

      //TODO: Load image with Glide

      textViewNumber.text = "N° ${item.formattedNumber}"
      textViewName.text = item.name
      textViewType1.text = item.types[0].name

      if(item.types.size > 1){
        textViewType2.visibility = View.VISIBLE
        textViewType2.text = item.types[1].name
      }else{
        textViewType2.visibility = View.GONE
      }
    }
  }

}