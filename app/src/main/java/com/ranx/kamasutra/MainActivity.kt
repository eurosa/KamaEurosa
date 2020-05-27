package com.ranx.kamasutra

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
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.gms.ads.*
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var appBarConfiguration: AppBarConfiguration
    var drawerLayout: DrawerLayout? =null

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/***************************************************************************************
*
*
* **************************************************************************************/

       MobileAds.initialize(this) {}
        mAdView = this.findViewById(R.id.adView)
       val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        mInterstitialAd.adListener = object : AdListener() {
            override fun onAdClosed() {
                mInterstitialAd.loadAd(AdRequest.Builder().build())
            }
        }

        /*********************************************************************************************
 ********************************************************************************************/



        val lvCards =
            findViewById<ListView>(R.id.list_cards)
        val adapter = CardsAdapter(this,mInterstitialAd)

        lvCards.adapter = adapter
        adapter.addAll(
            CardModel(R.drawable.love_couple, R.string.intro_duction_1, R.string.intro_sex_des),
            CardModel(R.drawable.kamasutra, R.string.kama_intro, R.string.kamsutra_des),
            CardModel(R.drawable.banana, R.string.better_sex_food, R.string.better_food_des),

            CardModel(R.drawable.pos_1, R.string.po_1, R.string.pos_1),
            CardModel(R.drawable.pos_2, R.string.po_2, R.string.pos_2),
            CardModel(R.drawable.pos_3, R.string.po_3, R.string.pos_3),
            CardModel(R.drawable.pos_4, R.string.po_4, R.string.pos_4),
            CardModel(R.drawable.pos_5, R.string.po_5, R.string.pos_5),
            CardModel(R.drawable.pos_6, R.string.po_6, R.string.pos_6),
            CardModel(R.drawable.pos_7, R.string.po_7, R.string.pos_7),
            CardModel(R.drawable.pos_8, R.string.po_8, R.string.pos_8),
            CardModel(R.drawable.pos_9, R.string.po_9, R.string.pos_9),
            CardModel(R.drawable.pos_10, R.string.po_10, R.string.pos_10),
            CardModel(R.drawable.pos_11, R.string.po_11, R.string.pos_11),
            CardModel(R.drawable.pos_12, R.string.po_12, R.string.pos_12),
            CardModel(R.drawable.pos_13, R.string.po_13, R.string.pos_13),
            CardModel(R.drawable.pos_14, R.string.po_14, R.string.pos_14),
            CardModel(R.drawable.pos_15, R.string.po_15, R.string.pos_15),
            CardModel(R.drawable.pos_16, R.string.po_16, R.string.pos_16),
            CardModel(R.drawable.pos_17, R.string.po_17, R.string.pos_17),
            CardModel(R.drawable.pos_18, R.string.po_18, R.string.pos_18),
            CardModel(R.drawable.pos_19, R.string.po_19, R.string.pos_19),
            CardModel(R.drawable.pos_20, R.string.po_20, R.string.pos_20),
            CardModel(R.drawable.pos_21, R.string.po_21, R.string.pos_21),
            CardModel(R.drawable.pos_22, R.string.po_22, R.string.pos_22),
            CardModel(R.drawable.pos_23, R.string.po_23, R.string.pos_23),
            CardModel(R.drawable.pos_24, R.string.po_24, R.string.pos_24),
            CardModel(R.drawable.pos_25, R.string.po_25, R.string.pos_25),
            CardModel(R.drawable.pos_26, R.string.po_26, R.string.pos_26),
            CardModel(R.drawable.pos_27, R.string.po_27, R.string.pos_27),
            CardModel(R.drawable.pos_28, R.string.po_28, R.string.pos_28),
            CardModel(R.drawable.pos_29, R.string.po_29, R.string.pos_29),
            CardModel(R.drawable.pos_30, R.string.po_30, R.string.pos_30),
            CardModel(R.drawable.pos_31, R.string.po_31, R.string.pos_31),
            CardModel(R.drawable.pos_32, R.string.po_32, R.string.pos_32),
            CardModel(R.drawable.pos_33, R.string.po_33, R.string.pos_33),
            CardModel(R.drawable.pos_34, R.string.po_34, R.string.pos_34),
            CardModel(R.drawable.pos_35, R.string.po_35, R.string.pos_35),
            CardModel(R.drawable.pos_36, R.string.po_36, R.string.pos_36),
            CardModel(R.drawable.pos_37, R.string.po_37, R.string.pos_37),
            CardModel(R.drawable.pos_38, R.string.po_38, R.string.pos_38),
            CardModel(R.drawable.pos_39, R.string.po_39, R.string.pos_39),
            CardModel(R.drawable.pos_40, R.string.po_40, R.string.pos_40),
            CardModel(R.drawable.pos_41, R.string.po_41, R.string.pos_41),
            CardModel(R.drawable.pos_43, R.string.po_43, R.string.pos_43),
            CardModel(R.drawable.pos_45, R.string.po_45, R.string.pos_45),
            CardModel(R.drawable.pos_46, R.string.po_46, R.string.pos_46),
            CardModel(R.drawable.pos_47, R.string.po_47, R.string.pos_47),
            CardModel(R.drawable.pos_48, R.string.po_48, R.string.pos_48),
            CardModel(R.drawable.pos_49, R.string.po_49, R.string.pos_49),
            CardModel(R.drawable.pos_50, R.string.po_50, R.string.pos_50)

            )

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

       // val fab: FloatingActionButton = findViewById(R.id.fab)
        //fab.setOnClickListener { view ->
          //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //    .setAction("Action", null).show()
       // }
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(false);
        drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        navView.setNavigationItemSelectedListener(this)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level dest  inations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                 R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )
            setupActionBarWithNavController(navController, appBarConfiguration)



        //navView.setupWithNavController(navController)
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



    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            // User chose the "Settings" item, show the app settings UI...
            popupHelp()

            true
        }




        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }


    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {


       // Toast.makeText(this, "Helooo", Toast.LENGTH_SHORT).show();
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
       drawerLayout!!.closeDrawer(GravityCompat.START)
        return true
    }


    fun popupHelp() {
        // An activity may have been overkill AND for some reason
        // it appears in the task switcher and doesn't allow returning to the
        // emergency configuration mode. So a dialog is better for this.
        //IntroActivity.open(FreeButtonActivity.this);
        val messages = arrayOf(
            "Welcome to kama Sutra Sex Position",
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

    override fun onResume() {
        super.onResume()



    }


}
