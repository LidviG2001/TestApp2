package com.example.testapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp2.room.DataView
import com.example.testapp2.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    lateinit var dataList: ArrayList<DataView>

    lateinit var recyclerRowAdapter: RecyclerRowAdapter

    lateinit var drawerLayout: DrawerLayout

    var btn_arrow: ImageButton? = null

    var title_text: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val navController = navHostFragment?.findNavController()

        val btn_close: ImageButton = findViewById(R.id.btn_close)

        btn_arrow = findViewById(R.id.btn_arrow)
        val btn_menu: ImageButton = findViewById(R.id.btn_menu)

        title_text= findViewById(R.id.title_text)

        title_text?.text = "Airplanes"

        btn_arrow?.visibility = View.INVISIBLE
        btn_menu.setOnClickListener {

            title_text?.animate()?.apply {
                duration = 500
                rotationX(360f)
            }?.start()

            if (drawerLayout .isDrawerVisible(GravityCompat.END)) {
                drawerLayout .closeDrawer(GravityCompat.END)
            } else {
                drawerLayout .openDrawer(GravityCompat.END)
            }
        }

        btn_close.setOnClickListener {
            drawerLayout.closeDrawer(GravityCompat.END)
        }

        btn_arrow?.setOnClickListener{
            navController?.navigate(R.id.action_DetailsFragment_to_MainFragment)
            btn_arrow?.visibility = View.INVISIBLE
        }

        drawerLayout = findViewById(R.id.drawerLayout)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_draw)

        dataList = mainViewModel.getListEntities() as ArrayList<DataView>



        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerRowAdapter = RecyclerRowAdapter(dataList, this, object : ClickListener {
            override fun onClick(index: Int) {
                val bundle = Bundle().apply { putInt("Position", index) }
                navController
                    ?.navigate(R.id.DetailsFragment, bundle)

                btn_arrow?.visibility = View.VISIBLE
            }
        })

        recyclerView.adapter = recyclerRowAdapter

    }
}