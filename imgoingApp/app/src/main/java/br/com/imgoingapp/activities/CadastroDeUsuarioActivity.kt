package com.example.teste.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.teste.dto.DtoUser
import com.example.teste.services.RetrofitService
import com.example.teste.R
import kotlinx.android.synthetic.main.activity_cadastro_de_usuario.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.LocalDate.*
import java.time.format.DateTimeFormatter
import java.util.*


class CadastroDeUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_de_usuario)
    }

    val i =intent

    fun cadastrar(view: View) {
        var TAG = "CadastroDeUsuarioActivity"


        var nome = et_cadastro_usuario_nome.text.toString()
        var razaoSocial = et_cadastro_usuario_sobrenome.text.toString()
        var email = et_cadastro_usuario_email.text.toString()
        var senha = et_cadastro_usuario_password.text.toString()
        var telefone = et_cadastro_usuario_phone.text.toString()
        var dataNascimento = et_cadastro_usuario_data.text.toString()
        var cpfcnpj = et_cadastro_usuario_cpfcnpj.text.toString()

        val dtoUser: DtoUser = DtoUser()

        dtoUser.nome = nome
        dtoUser.razaoSocial = razaoSocial
        dtoUser.email = email
        dtoUser.senha = senha
        dtoUser.telefone = telefone
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        val date = parse (dataNascimento, formatter)
        dtoUser.dataNascimento = date.toString()
        if(cpfcnpj.length == 11){
            dtoUser.cpf = cpfcnpj
        }
        else if (cpfcnpj.length == 14){
            dtoUser.cnpj = cpfcnpj
        }

        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.cadastrarUsuario(dtoUser)?.enqueue(object : Callback<DtoUser> {
            override fun onResponse(call: Call<DtoUser>, response: Response<DtoUser>) {
                Log.d("Responsta","Usuario cadastrado com ID: " + response.body()?.id.toString())
            }

            override fun onFailure(call: Call<DtoUser>, t: Throwable) {
                Log.e("Erro", "************** erro **********\n" + t?.message.toString())
            }
        })
    }

    private fun buscaDados() {
        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.obterUsuarios()?.enqueue(object : Callback<List<DtoUser>> {
            override fun onResponse(
                call: Call<List<DtoUser>?>?,
                response: Response<List<DtoUser>?>?
            ) {
                val lista = response?.body();
                if (lista != null) {
                    for (user in lista) {
                        Log.d("Resposta", user.nome.toString())
                    }
                }
            }

            override fun onFailure(call: Call<List<DtoUser>?>?, t: Throwable?) {
                Log.e("Erro", "************** erro **********\n" + t?.message.toString())
            }
        })
    }
}