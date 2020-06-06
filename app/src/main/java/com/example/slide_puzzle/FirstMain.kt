package com.example.slide_puzzle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView

class FirstMain : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    lateinit var btn : Button
    lateinit var txt : TextView
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    lateinit var f1: FrameLayout

    val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_main)

        btn = findViewById(R.id.button)
        txt = findViewById(R.id.textmain)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        navView.bringToFront();
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        p0.isChecked = true
        when (p0.itemId) {
            R.id.nav_rule -> {
                showMainFragment()
            }
            R.id.nav_about -> {
                Toast.makeText(this, "Sliding Puzzle is a combination puzzle that challenges a player to slide pieces along certain routes to establish a certain end-configuration.", Toast.LENGTH_LONG).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    private fun showMainFragment() {


//        f1=findViewById(R.id.)
//        f1.removeAllViews()
        //transaction.add(R.id.detail_fragment_container,fragment)
        //                transaction.remove(R.id.textmain,R.id.button)
        //.addToBackStack(null)
        val transaction = supportFragmentManager
        val fragment = Fragment_Rules()

        transaction.beginTransaction().add(R.id.frag, fragment).commit()

        txt.setVisibility(View.INVISIBLE)
        btn.setVisibility(View.INVISIBLE)
    }

}
