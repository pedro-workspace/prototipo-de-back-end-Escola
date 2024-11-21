package node

import enum.Nivel

//Conteúdos educacionais
data class Disciplina(var nome:String, var stackDisciplina:String, var nivel:Nivel) {
    val cod = hashCode()
    init {
        println("junta.Disciplina $nome adicionada")
    }
}