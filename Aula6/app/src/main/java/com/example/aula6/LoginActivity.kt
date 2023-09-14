package com.example.aula6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aula6.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    // criar objeto de login credentials
    private lateinit var loginCredentials: LoginCredentials

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        // Nova instancia de login credentials:
        loginCredentials = LoginCredentials(this)

        var view = binding.root

        setContentView(view)

        // ação de clique do botão
        binding.btnEntrar.setOnClickListener {
            validarLogin()
        }

    }

    private fun validarLogin() {

        // verifica se a checkbox foi "ticada"
        if (binding.ckbPrimeiroAcesso.isChecked) {
            intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
            return // apesar de iniciarmos nova activity acima, precisamos encerrar a execução
            // desta função nesta linha para evitar que o restante seja executado após sairmos
            // da login activity
        }

        // validações padrão de dados, como visto nas aulas passadas:
        if (binding.edtEmail.text.isEmpty() ||
            binding.edtSenha.text.isEmpty()
        ) {
            // mensagem de erro
            Util.exibirToast(this, "Preencha todos os campos!")
            return
        }

        var email = binding.edtEmail.text.toString()
        var senha = binding.edtSenha.text.toString()

        // recebe email e senha do shared preferences
        var sharedEmail = loginCredentials.getEmail()
        var sharedSenha = loginCredentials.getSenha()

        // comapra se dados digitados são diferentes aos armazenados
        if (email != sharedEmail || senha != sharedSenha) {
            Util.exibirToast(this, "E-mail ou senha inválidos!")
            binding.edtEmail.text.clear()
            binding.edtSenha.text.clear()
            return
        }

        // passsando por todas as validaçòes acima, iniciamos normalmente a main activity
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    // tirando o foco desta actiovity, ewla será encerrada
    override fun onStop() {
        super.onStop()
        finish()
    }

}