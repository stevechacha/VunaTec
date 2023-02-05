package com.dev.chacha.vunatec.core.presentation.activities

import android.os.Build
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.dev.chacha.vunatec.R
import com.dev.chacha.vunatec.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigation()

    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.apply {
            val navView: BottomNavigationView = findViewById(R.id.bottomNavigation)
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
            navHostFragment.navController.apply {
                setupWithNavController(this,)
                addOnDestinationChangedListener { _, _, args ->
                    // Top level items should have such argument with value set to true
                    isVisible = args?.getBoolean("hasBottomNav", false) == true
                }
                setOnItemReselectedListener {
                    when(it.itemId){
                        R.id.paymentsFragment ->{
                        }
                        R.id.detectionFragment ->{
                        }
                        R.id.myFarmFragment ->{
                        }
                        R.id.calenderFragment ->{
                        }
                        R.id.alertsFragment ->{
                        }

                    }
                    return@setOnItemReselectedListener

                    // Do nothing when selecting same item
                }
                // Set the bottom navigation view/bar background color

            }
        }
    }

    override fun onBackPressed() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
            // Workaround for Android Q memory leak issue in IRequestFinishCallback$Stub.
            // (https://issuetracker.google.com/issues/139738913)
            finishAfterTransition()
        } else {
            super.onBackPressed()
        }
    }

}