package node

data class Aluno(var nome: String, var formações: MutableList<Formação>) {
    val cod = hashCode()
    init {
        println("Aluno $nome adicionado à ${formações.last().getNome()}")
    }
}