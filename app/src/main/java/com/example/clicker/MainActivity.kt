package com.example.clicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.clicker.src.User
import com.google.android.material.navigation.NavigationView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(){
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var clickerImage: ImageView
    private lateinit var powerTextView: TextView
    private lateinit var user: User
    private var fragment: Fragment? = null
    private lateinit var goldTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        clickerImage = findViewById(R.id.click_image)
        powerTextView = findViewById(R.id.power)
        goldTextView = findViewById(R.id.gold)
        user = User()
        Picasso.get().load(user.sourcePicture).into(clickerImage)
        powerTextView.text = "Сила: " + user.power.toString()
        goldTextView.text = "Золото: " + user.gold.toString()
        clickerImage.setOnClickListener{
            user.increaseGold()
            goldTextView.text = "Золото: " + user.gold.toString()
        }

        setMenu()
    }

    private fun goHome(){
        val fragmentManager = supportFragmentManager
        val fragmentTranscation = fragmentManager.beginTransaction()
        if(fragment != null){
            fragmentTranscation.remove(fragment!!)
            fragmentTranscation.commit()
        }
        clickerImage.visibility = View.VISIBLE
        drawerLayout.closeDrawers()
    }

    private fun upPowerFragment(fragment: Fragment){
        clickerImage.visibility = View.GONE
        val fragmentManager = supportFragmentManager
        val fragmentTranscation = fragmentManager.beginTransaction()
        fragmentTranscation.replace(R.id.frame_layout, fragment)
        fragmentTranscation.commit()
        this.fragment = fragment
        drawerLayout.closeDrawers()
    }

    private fun uploadViaInternetFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTranscation = fragmentManager.beginTransaction()
        fragmentTranscation.replace(R.id.frame_layout, fragment)
        fragmentTranscation.commit()
        this.fragment = fragment
        drawerLayout.closeDrawers()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    private fun setMenu(){
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            when (it.itemId) {
                R.id.nav_home -> goHome()
                R.id.nav_power -> upPowerFragment(UpPower(user, goldTextView, powerTextView))
                R.id.nav_internet -> uploadViaInternetFragment(UploadViaInternet(user, clickerImage))
            }
            true
        }
    }

}


