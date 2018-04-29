package it.sileo.associazionelucana.activity

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import it.sileo.associazionelucana.R
import it.sileo.associazionelucana.fragment.HomeFragment
import it.sileo.associazionelucana.fragment.ItemFragment

import it.sileo.associazionelucana.utils.OnFragmentInteractionListener
import kotlinx.android.synthetic.main.activity_alsteg.*
import kotlinx.android.synthetic.main.app_bar_alsteg.*

class ALSTEGActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener {

    companion object {
        public val STORY: String = "STORY"
        public val IMAGE: String = "IMAGE"
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alsteg)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.story_label, R.string.home_label)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        var fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_layout,HomeFragment.newInstance("","")).commit()

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.alsteg, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        var fragmentTransaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.nav_home -> {
                fragmentTransaction.replace(R.id.fragment_layout, HomeFragment.newInstance("",""))
                        .commit()
            }
            R.id.nav_story -> {
                  fragmentTransaction.replace(R.id.fragment_layout, ItemFragment.newInstance(STORY,""))
                        .commit()

            }
            R.id.nav_gallery -> {
                fragmentTransaction.replace(R.id.fragment_layout, ItemFragment.newInstance(IMAGE,""))
                        .commit()
            }
            R.id.nav_videos -> {

            }
            R.id.nav_festival -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
