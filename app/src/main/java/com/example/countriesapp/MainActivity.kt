package com.example.countriesapp

import android.os.Bundle
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

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val countryName : String = binding.countryNameEditText.text.toString()

            lifecycleScope.launch {
                val countries = restCountriesAPI.getCountryByName(countryName)
                val country = countries[0]

                binding.countryNameTextWiew.text = country.name.common
                binding.capitalTextView.text = country.capital[0]
                binding.populationTextView.text = country.population.toString()
                binding.areaTextView.text = country.area.toString()
                binding.langTextView.text = country?.languages?.values?.firstOrNull() ?: "Нет данных"

            }

        }

    }
}