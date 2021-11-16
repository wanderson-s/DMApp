package br.com.wandersonsantos.dmapp


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*


class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        imagem_login.setImageResource(R.drawable.imagem_login)

        campo_usuario.setText(Prefs.getString("nome_usuario"))
        campo_senha.setText(Prefs.getString("senha_usuario"))
        checkLogin.isChecked = Prefs.getBoolean("lembar_login")

        botao_login.setOnClickListener {

            progressLogin.visibility = View.VISIBLE

            val nome_usuario = campo_usuario.text.toString()
            val senha_usuario = campo_senha.text.toString()
            val check_login = checkLogin.isChecked

            if (check_login){
                Prefs.setString("nome_usuario", nome_usuario)
                Prefs.setString("senha_usuario", senha_usuario)
            } else {
                Prefs.setString("nome_usuario", "")
                Prefs.setString("senha_usuario", "")
            }
            Prefs.setBoolean("lembrar_login", check_login)

            var intent = Intent(this, TelaInicialActivity::class.java)

            intent.putExtra("nome_usuario", nome_usuario)
            intent.putExtra("senha_usuario", senha_usuario)

            Handler(Looper.getMainLooper()).postDelayed({
                progressLogin.visibility = View.INVISIBLE
                if (nome_usuario == "aluno" && senha_usuario == "impacta") {
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "login ou senha inválido", Toast.LENGTH_SHORT).show()
                }

            }, 1000)
        }
    }
}