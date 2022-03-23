package com.aula.motivation.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.aula.motivation.R
import com.aula.motivation.infra.MotivationConstants
import com.aula.motivation.infra.MotivationConstants.FraseFilter.FELIZ
import com.aula.motivation.infra.MotivationConstants.FraseFilter.INFINITO
import com.aula.motivation.infra.MotivationConstants.FraseFilter.SOL
import com.aula.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //valor default quando a tela é ativada
    private var mFraseFilter : Int = MotivationConstants.FraseFilter.INFINITO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shared = this.getSharedPreferences("motivation", Context.MODE_PRIVATE)
        textName.text = shared.getString("name", "")

        if (supportActionBar != null){
            supportActionBar!!.hide()
        }

        //lógica inicial de seleção de uma frase
        imageInfinito.setColorFilter(resources.getColor(R.color.colorAccent))
        handleNovaFrase()

        buttonNovaFrase.setOnClickListener(this)
        imageInfinito.setOnClickListener(this)
        imageFeliz.setOnClickListener(this)
        imageSol.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id

        if (id == R.id.buttonNovaFrase) {
            handleNovaFrase();
        } else if (id == R.id.imageInfinito) {
            handleFilter(INFINITO);
        } else if (id == R.id.imageFeliz) {
            handleFilter(FELIZ);
        } else if (id == R.id.imageSol) {
            handleFilter(SOL);
        }
    }

    //vai buscar uma nova frase
    //vai filtrar as mensagens de acordo com o botão clicado
    private fun handleFilter(id: Int) {
        //garantindo que as imagens serão brancas
        imageInfinito.setColorFilter(resources.getColor(R.color.white))
        imageFeliz.setColorFilter(resources.getColor(R.color.white))
        imageSol.setColorFilter(resources.getColor(R.color.white))

        when (id) {
            INFINITO -> {
                //deixando as imagens rosa claro ao clicar
                imageInfinito.setColorFilter(resources.getColor(R.color.colorAccent))
                //atualiza com a categoria selecionada
                mFraseFilter = MotivationConstants.FraseFilter.INFINITO
            }
            FELIZ -> {
                imageFeliz.setColorFilter(resources.getColor(R.color.colorAccent))
                //atualiza com a categoria selecionada
                mFraseFilter = MotivationConstants.FraseFilter.FELIZ
            }
            SOL -> {
                imageSol.setColorFilter(resources.getColor(R.color.colorAccent))
                //atualiza com a categoria selecionada
                mFraseFilter = MotivationConstants.FraseFilter.SOL
            }
        }

    }

    private fun handleNovaFrase() {
        //mFraseFilter é a categoria escolhida para retornar a frase
        textFrase.text = Mock().getFrase(mFraseFilter)
    }


}

