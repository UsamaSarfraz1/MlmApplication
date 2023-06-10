package com.myapp.mlmapplication

import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.myapp.mlmapplication.databinding.ActivityMainBinding
import com.myapp.mlmapplication.fragments.*
import com.myapp.mlmapplication.utils.SharedPreferencesManager

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener  {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreference: SharedPreferencesManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreference = SharedPreferencesManager(this)
        binding.navView.setNavigationItemSelectedListener(this)
        replaceFragment(HomeFragment(),"")
        // Set up the action bar with the drawer toggle button
        binding.btnDrawer.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }


        /*binding.btnSignOut.setOnClickListener {
            sharedPreference.clearToken()
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
            finish()
        }
        binding.btnProfile.setOnClickListener {
            startActivity(Intent(this@MainActivity,ProfileActivity::class.java))
        }*/
    }


    private fun replaceFragment(fragment: Fragment, tag: String) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.host_fragment, fragment, tag)
        transaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = Fragment()
        fragment=when (item.itemId) {
            /*R.id.nav_user ->  UserFragment()*/

            R.id.nav_dashboard -> HomeFragment()
            R.id.nav_panel_user -> PanelUserFragment()
            R.id.nav_create_user -> CreateUserFragment()
            R.id.nav_app_user -> AppUserFragment()
            else -> {
               HomeFragment()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        Handler().postDelayed({
            replaceFragment(fragment,"")
        }, 250)

        return true
    }

}