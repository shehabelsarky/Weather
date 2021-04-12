package com.example.weather.ui.fragment.cities

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.View
import android.widget.AutoCompleteTextView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.weather.R
import com.example.weather.ui.dialog.AddCityDialog
import com.example.weather.ui.fragment.HomeViewModel
import com.examples.core.base.fragment.BaseFragment
import com.examples.core.utils.NetworkingUtils
import com.examples.core.utils.showToast
import com.examples.entities.city.local.City
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_cities.*
import kotlinx.android.synthetic.main.list_layout.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlin.properties.Delegates

/**
 * Created by Shehab Elsarky
 */
@ExperimentalCoroutinesApi
@FlowPreview
@AndroidEntryPoint
class CitiesFragment : BaseFragment<HomeViewModel>() {

    override var layoutResourceId: Int = R.layout.fragment_cities
    override val viewModel by viewModels<HomeViewModel>()
    private lateinit var citiesAdapter: CitiesAdapter
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var citiesList: ArrayList<City> = arrayListOf()
    private var dropdownCitiesList: ArrayList<City> = arrayListOf()
    private var numberOfAddedCities: Int by Delegates.notNull()
    private var coroutineScope = CoroutineScope(Dispatchers.Main)
    private val permissionGranted = PackageManager.PERMISSION_GRANTED
    private val permissionFineLocation = Manifest.permission.ACCESS_FINE_LOCATION
    private val permissionCoarseLocation = Manifest.permission.ACCESS_COARSE_LOCATION

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberOfAddedCities = 0
        initCitiesList()
        collectCitiesList()
        initFabAddCity()
    }

    private fun initCitiesList() {
        citiesAdapter = CitiesAdapter({ cityDetails ->
            if (isNetworkConnected)
                navigateToWeatherFragment(cityDetails.cityName)
            else
                requireContext().showToast("No internet connection")
        }, { city, position ->
            if (isNetworkConnected)
                coroutineScope.launch {
                    citiesList.removeAt(position)
                    citiesAdapter.notifyItemRemoved(position)
                }
            else
                requireContext().showToast("No internet connection")
        })
        rvList.adapter = citiesAdapter
    }

    private fun collectCitiesList() {
        lifecycleScope.launch {
            with(viewModel) {
                if (NetworkingUtils.isNetworkConnected)
                    getCities()
                else
                    selectCities()

                citiesChannel.asFlow().collect {
                    initCitiesAndCitiesDropdownLists(
                        citiesList,
                        dropdownCitiesList,
                        it as ArrayList<City>
                    )
                    citiesAdapter.submitList(citiesList)
                    initCitiesDropDownList(dropdownCitiesList)
                    initLocationService()
                }
            }
        }
    }

    private fun initFabAddCity() {
        fabAddCity.setOnClickListener {
            val addCityDialog = AddCityDialog { cityName ->
                if (numberOfAddedCities < 5) {
                    coroutineScope.launch {
                        viewModel.addCity(citiesList, cityName, 0)
                        citiesAdapter.notifyDataSetChanged()
                        numberOfAddedCities++
                    }
                } else
                    requireContext().showToast("Max number of added cities is 5")
            }
            addCityDialog.showDialog(requireContext())
        }
    }

    private fun initCitiesDropDownList(citiesList: List<City>) {
        val citiesDropDownAdapter = CitiesArrayAdapter(requireContext(), citiesList)
        (input_layout_type)?.run {
            setAdapter(citiesDropDownAdapter)
            setOnItemClickListener { _, _, position, _ ->
                input_layout_type.setText(citiesList[position].cityName)
                input_layout_type.setSelection(citiesList[position].cityName.length)
                navigateToWeatherFragment(citiesList[position].cityName)
            }
        }
        input_layout_type.setOnClickListener {
            input_layout_type.requestFocus()
        }
    }

    private fun navigateToWeatherFragment(cityName: String) = findNavController().navigate(
        CitiesFragmentDirections.actionCitiesFragmentToWeatherFragment(cityName)
    )

    private fun initLocationService() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                permissionFineLocation
            ) != permissionGranted
            && ActivityCompat.checkSelfPermission(
                requireContext(),
                permissionCoarseLocation
            ) != permissionGranted
        ) {
            return
        }
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                if (location != null) {
                    val city =
                        getCityFromLatLng(requireContext(), location.latitude, location.longitude)
                    if (city.isNotEmpty()) {
                        coroutineScope.launch {
                            if (!citiesList.contains(City(cityName = city))) {
                                viewModel.addCity(citiesList, city, 0)
                                citiesAdapter.notifyDataSetChanged()
                            }
                        }
                    }
                }
            }
    }
}