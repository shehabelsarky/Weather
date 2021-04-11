package com.example.weather.ui.activity

import android.os.Bundle
import com.example.weather.R
import com.examples.core.base.activity.PermissionsActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Shehab Elsarky
 */
@AndroidEntryPoint
class WeatherActivity : PermissionsActivity() {

    override var permissions: Array<String> = arrayOf(
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION
    )

    override var navGraphResourceId: Int = R.navigation.nav_graph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestPermissions.launch(permissions)
        changeBackButtonVisibility(false)
    }
}
