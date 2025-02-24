package com.example.countriesapp

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.countriesapp.databinding.ActivityMainBinding
import com.example.countriesapp.ui.theme.CountriesAppTheme
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val countryName : String = binding.countryNameEditText.text.toString()

            lifecycleScope.launch {
                try {
                    val countries = restCountriesAPI.getCountryByName(countryName)
                    val country = countries[0]

                    binding.countryNameTextWiew.text = country.name.common
                    binding.capitalTextView.text = country.capital[0]
                    binding.populationTextView.text =
                        NumberFormat.getInstance(Locale("ru", "RU")).format(country.population)
                    binding.areaTextView.text =
                        NumberFormat.getInstance(Locale("ru", "RU")).format(country.area)
                    binding.langTextView.text = convert(country.languages)

                    loadSvgWithPicasso(binding.flagView, getFlag(country.flags))

                    binding.resultLayout.visibility = View.VISIBLE
                    binding.startLayout.visibility = View.INVISIBLE
                } catch (e: Exception) {
                    e.printStackTrace()

                    binding.errorLayout.visibility = View.VISIBLE
                    binding.resultLayout.visibility = View.INVISIBLE
                }

            }

        }

    }
}