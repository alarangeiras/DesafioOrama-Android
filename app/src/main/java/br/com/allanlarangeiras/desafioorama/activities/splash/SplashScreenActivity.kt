package br.com.allanlarangeiras.desafioorama.activities.splash

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.allanlarangeiras.desafioorama.R
import br.com.allanlarangeiras.desafioorama.activities.funds.FundsActivity
import br.com.allanlarangeiras.desafioorama.model.dto.Fund
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity: AppCompatActivity() {

    private val splashScreenPresenter = SplashScreenPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        splashScreenPresenter.getFunds()
    }

    fun goToHome(funds: List<Fund>) {
        val goToHome = Intent(this, FundsActivity::class.java)
        goToHome.putExtra("funds", Gson().toJson(funds))
        hideProgressBar()
        goToHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(goToHome)
    }

    fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }
}