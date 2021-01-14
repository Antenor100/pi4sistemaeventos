package com.example.teste.activities

import android.content.Intent
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import android.widget.ViewAnimator
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.teste.R
import com.example.teste.dto.DtoUser
import com.example.teste.services.RetrofitService
import com.example.teste.ui.home.HomeFragment
import com.example.teste.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_cadastro_de_usuario.*
import kotlinx.android.synthetic.main.fragment_ingresso.*
import kotlinx.android.synthetic.main.fragment_perfil.*
import kotlinx.android.synthetic.main.fragment_perfil.et_cadastro_evento_titulo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

    fun radioOnline(view: View){
        et_cadastro_evento_cep.visibility = View.INVISIBLE
    }

    fun radioPresencial(view: View){
        et_cadastro_evento_cep.visibility = View.INVISIBLE
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

    fun entrar(view: View) {
        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.obterUsuarios()?.enqueue(object : Callback<List<DtoUser>> {
            override fun onResponse(
                call: Call<List<DtoUser>?>?,
                response: Response<List<DtoUser>?>?
            ) {

                var email = et_cadastro_evento_titulo.text.toString()
                var senha = et_cadastro_usuario_passwordLogin.text.toString()
                var resposta = 0
                val lista = response?.body();
                if (lista != null) {
                    for (user in lista) {
                        if(user.email == email && user.senha == senha) {
                         resposta = 1
                        }
                    }
                    if(resposta == 1){
                        Toast.makeText(
                            this@MainActivity,
                            "Login Efetuado!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    else{
                        Toast.makeText(
                            this@MainActivity,
                            "Email ou Senha está Incorreto!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

            override fun onFailure(call: Call<List<DtoUser>?>?, t: Throwable?) {
                Log.e("Erro", "************** erro **********\n" + t?.message.toString())
            }
        })
    }
    }


