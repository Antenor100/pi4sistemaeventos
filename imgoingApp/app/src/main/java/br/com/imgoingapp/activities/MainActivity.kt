package com.example.teste.activities

import android.content.Intent
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ViewAnimator
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.teste.R


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home,
            R.id.navigation_pesquisa,
            R.id.navigation_ingresso,
            R.id.navigation_favoritos,
            R.id.navigation_perfil
        ))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


    fun cadastrarUsuario(view: View) {
        val intent = Intent(this, CadastroDeUsuarioActivity::class.java)
        startActivity(intent)
        }


    fun sliderImagem(view: View){
        val rocketImage: ImageView = findViewById(R.id.slider)
        rocketImage.setImageResource(R.drawable.evento_banner)

        val rocketAnimation = rocketImage.drawable
        if (rocketAnimation is Animatable) {
            rocketAnimation.start()
        }
    }
    }


