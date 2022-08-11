package com.example.rlogin

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.util.PatternsCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.rlogin.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            validarEYP()
            val correo = findViewById<EditText>(R.id.editTextTextPersonName)
            val intent = Intent(this, Menu::class.java)
            intent.putExtra("usuario", correo?.text.toString())
            startActivity(intent)
            Toast.makeText(this, "Credenciales correctas", Toast.LENGTH_LONG).show()
        }
    }
    private fun validarEYP()
    {
        val resultValidar = arrayOf(validarE(), validarP())
        if(false in resultValidar)
        {
            return
        }
        Toast.makeText(this, "Credenciales correctas", Toast.LENGTH_LONG).show()
    }
    private fun validarE() : Boolean{
        val Email = binding.editTextTextPersonName?.text.toString()
        //Si el campo esta vacio
        return  if(Email.isEmpty())
        {
            binding.editTextTextPersonName.error= "El campo esta vacío"
            false
        }else if (!PatternsCompat.EMAIL_ADDRESS.matcher(Email).matches()){
            binding.editTextTextPersonName.error= "Ingrese un Email valido"
            false
        }else if(!Email.equals("susan@gmail.com")){
            binding.editTextTextPersonName.error= "Email incorrecto"
            false
        }else{
            binding.editTextTextPersonName.error= null
            true
        }
    }
    private fun validarP() : Boolean{
        val Password = binding.editTextTextPassword2?.text.toString()
        return  if(Password.isEmpty())
        {
            binding.editTextTextPassword2.error= "El campo esta vacío"
            false
        }else if(!Password.equals("susan")) {
            binding.editTextTextPassword2.error = "Password incorrecto"
            false
        }else {
            binding.editTextTextPassword2.error= null
            true
        }
    }
}