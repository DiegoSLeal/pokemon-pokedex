package br.com.fabricadesinapse.pokemon_pokedex.view
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Chronometer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fabricadesinapse.pokemon_pokedex.R
import br.com.fabricadesinapse.pokemon_pokedex.api.PokemonRepository
import br.com.fabricadesinapse.pokemon_pokedex.domain.Pokemon
import br.com.fabricadesinapse.pokemon_pokedex.viewmodel.PokemonViewModel
import br.com.fabricadesinapse.pokemon_pokedex.viewmodel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {

  lateinit var  recyclerView: RecyclerView

  private val viewModel by lazy {
    ViewModelProvider(this, PokemonViewModelFactory())
      .get(PokemonViewModel::class.java)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    recyclerView = findViewById<RecyclerView>(R.id.recyclerviewPokemons)

    viewModel.pokemons.observe(this, Observer{
      loadRecyclerView(it)
    })
  }

  private fun loadRecyclerView(pokemons: List<Pokemon?>) {
      recyclerView.layoutManager = LinearLayoutManager(this)
      recyclerView.adapter = PokemonAdapter(pokemons)
  }

  private fun test(){

  }
}
