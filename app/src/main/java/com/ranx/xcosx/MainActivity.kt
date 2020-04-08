package com.ranx.xcosx

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val lvCards =
            findViewById<ListView>(R.id.list_cards)
        val adapter = CardsAdapter(this)

        lvCards.adapter = adapter
        adapter.addAll(
            CardModel(R.drawable.mercury, R.string.mercury, R.string.mercury_sub),
            CardModel(R.drawable.venus, R.string.venus, R.string.venus_sub),
            CardModel(R.drawable.earth, R.string.earth, R.string.earth_sub),
            CardModel(R.drawable.mars, R.string.mars, R.string.mars_sub),
            CardModel(R.drawable.jupiter, R.string.jupiter, R.string.jupiter_sub),
            CardModel(R.drawable.saturn, R.string.saturn, R.string.saturn_sub),
            CardModel(R.drawable.uranus, R.string.uranus, R.string.uranus_sub),
            CardModel(R.drawable.neptune, R.string.neptune, R.string.neptune_sub),
            CardModel(R.drawable.pluto, R.string.pluto, R.string.pluto_sub)
        )

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level dest  inations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                 R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun onNavigationItemSelected(menuItem: MenuItem): Boolean {


        //  Toast.makeText(Main2Activity.this, "Helooo", Toast.LENGTH_SHORT).show();
        var fragment: Fragment
        val id = menuItem.itemId
        Log.d("show_id", "" + id)
        if (id == R.id.nav_share) {
            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Love Story")
                var shareMessage = "\nLet me recommend you this application\n\n"
                shareMessage =
                    """
                    ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                    
                    
                    """.trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                startActivity(Intent.createChooser(shareIntent, "choose one"))
            } catch (e: Exception) {
                //e.toString();
            }
        }
        if (id == R.id.nav_send) {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + this.packageName)
                    )
                )
            } catch (e: Exception) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + this.opPackageName)
                        )
                    )
                }
            }
        }
        //if (id == R.id.help) {
          //  popupHelp()
        //}
        return true
    }


    fun popupHelp() {
        // An activity may have been overkill AND for some reason
        // it appears in the task switcher and doesn't allow returning to the
        // emergency configuration mode. So a dialog is better for this.
        //IntroActivity.open(FreeButtonActivity.this);
        val messages = arrayOf(
            "Welcome to Love Story.",
            "To Read Details Click on Listed Item."
        )

        // inverted order - They all popup and you hit "ok" to see the next one.
        //  popup("3/3", messages[2]);
        popup("2/2", messages[1])
        popup("1/2", messages[0])
    }


    private fun popup(title: String, text: String) {
        val builder =
            AlertDialog.Builder(this)
        builder.setMessage(text)
            .setTitle(title)
            .setCancelable(true)
            .setPositiveButton(
                "ok"
            ) { dialog, id -> dialog.cancel() }
        val alert = builder.create()
        alert.show()
    }

}
