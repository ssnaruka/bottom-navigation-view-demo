package com.surendrasingh.bottomnavdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.surendrasingh.bottomnavdemo.R
import com.surendrasingh.bottomnavdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val navController by lazy{
        (supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment).navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set bottom navigation view with navigation component
        binding.bottomNavView.setupWithNavController(navController)

        setupBottomNavAnimation()
    }

    private fun setupBottomNavAnimation() {
        binding.bottomNavView.menu.apply {
            add(Menu.NONE, 0, Menu.NONE, R.string.home)
            add(Menu.NONE, 1, Menu.NONE, R.string.wallet)
            add(Menu.NONE, 2, Menu.NONE, R.string.bookings)
            add(Menu.NONE, 3, Menu.NONE, R.string.profile)

            findItem(0).icon =
                getLottieDrawable(LottieAnimation.HOME, binding.bottomNavView)

            findItem(1).icon =
                getLottieDrawable(LottieAnimation.WALLET, binding.bottomNavView)

            findItem(2).icon =
                getLottieDrawable(LottieAnimation.BOOKING, binding.bottomNavView)

            findItem(3).icon =
                getLottieDrawable(LottieAnimation.PROFILE, binding.bottomNavView)
        }

        binding.bottomNavView.setOnItemSelectedListener { menuItem ->
            val icon = menuItem.icon as? LottieDrawable
            icon?.apply {
                playAnimation()
            }

            return@setOnItemSelectedListener true
        }

        navController.addOnDestinationChangedListener { controller, destination, arguments ->

        }
    }

    enum class LottieAnimation(val value: String){
        HOME("bn_home.json"),
        WALLET("bn_wallet.json"),
        BOOKING("bn_booking.json"),
        PROFILE("bn_profile.json")
    }

    private fun getLottieDrawable(
        animation: LottieAnimation,
        view: BottomNavigationView
    ): LottieDrawable{
        return LottieDrawable().apply {
            val result = LottieCompositionFactory.fromAssetSync(this@MainActivity,
                animation.value)

            callback = view
            composition = result.value
        }
    }
}