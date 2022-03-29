package com.orbitalsonic.navigationcomponentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController:NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar =findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        val navDrawer = findViewById<NavigationView>(R.id.nav_drawer)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment,R.id.settingsFragment,R.id.notificationFragment),drawerLayout
        )

        bottomNavView.setupWithNavController(navController)
        navDrawer.setupWithNavController(navController)
        setupActionBarWithNavController(navController,appBarConfiguration)
//        toolbar.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.item_about_app -> {
                val action = MainNavGraphDirections.actionGlobalAboutFragment()
                navController.navigate(action)
                return true
            }

            else -> item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }

    }
}