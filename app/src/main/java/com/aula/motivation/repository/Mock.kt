package com.aula.motivation.repository

import com.aula.motivation.infra.MotivationConstants
import java.util.*


data class Frase (val descricao: String, val categoria: Int)

class Mock {

    private val INFINITO = MotivationConstants.FraseFilter.INFINITO
    private val FELIZ = MotivationConstants.FraseFilter.FELIZ
    private val SOL = MotivationConstants.FraseFilter.SOL

    //Frase, Categoria

    private val mListFrases: List<Frase> = listOf(
        Frase("Não sabendo que era impossível, foi lá e fez.", FELIZ),
        Frase("Você não é derrotado quando perde, você é derrotado quando desiste!", FELIZ),
        Frase("Quando está mais escuro, vemos mais estrelas!", FELIZ),
        Frase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", FELIZ),
        Frase("Não pare quando estiver cansado, pare quando tiver terminado.", FELIZ),
        Frase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", FELIZ),
        Frase("A melhor maneira de prever o futuro é inventá-lo.", SOL),
        Frase("Você perde todas as chances que você não aproveita.", SOL),
        Frase("Fracasso é o condimento que dá sabor ao sucesso.", SOL),
        Frase("Enquanto não estivermos comprometidos, haverá hesitação!", SOL),
        Frase("Se você não sabe onde quer ir, qualquer caminho serve.", SOL),
        Frase("Se você acredita, faz toda a diferença.", SOL),
        Frase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", SOL)
    )

    fun getFrase(categoriaId: Int): String {
        //filtrar usando as collections do kotlin
        val filtrado = mListFrases.filter{ (it.categoria == categoriaId || categoriaId == INFINITO)}

        //fazer uma escolha randômica
        //vai do zero até o tamanho da lista
        //usar a função Random do java
        val rand = Random().nextInt(filtrado.size)

        //retornando uma frase randômica
        return  filtrado[rand].descricao
    }
}