package br.com.fabricadesinapse.pokemon_pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fabricadesinapse.pokemon_pokedex.R
import br.com.fabricadesinapse.pokemon_pokedex.domain.Pokemon
import br.com.fabricadesinapse.pokemon_pokedex.domain.PokemonType

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val recyclerView = findViewById<RecyclerView>(R.id.recyclerviewPokemons)

    val Charmander = Pokemon(
      "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
      4,
      "Charmander",
      listOf(PokemonType("Fire"))
    )
    val pokemons = listOf(Charmander,Charmander,Charmander,Charmander,Charmander)
    val layoutManager = LinearLayoutManager(this)

    recyclerView.layoutManager = layoutManager

    recyclerView.adapter = PokemonAdapter(pokemons)
  }
}