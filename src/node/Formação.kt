package node

import enum.Nivel

data class Formação(private var nomeFormação:String,
               private var stackFormação: String,
               private var nivelFormação: Nivel,
               private var disciplinas: MutableList<Disciplina>,
               private var alunos: MutableList<Aluno>) {
    val cod = hashCode()

    fun getNome() = nomeFormação
    fun getStack() = stackFormação
    fun getNivel() = nivelFormação
    fun getDisciplinas() = disciplinas
    fun getAlunos() = alunos
    fun setNome(nome:String){nomeFormação = nome}
    fun setStack(stack:String){stackFormação = stack}
    fun setDisciplines(disciplinas: MutableList<Disciplina>){this.disciplinas = disciplinas}
    fun setAlunos(alunos: MutableList<Aluno>){this.alunos = alunos}

    fun adicionarDisciplina(disciplina: Disciplina){
        disciplinas.add(disciplina)
    }
    fun removerDisciplinaPorCódigo(cod:Int){
        for(disciplina in disciplinas){
            if(cod == disciplina.cod){
                disciplinas.remove(disciplina)
            }
        }
    }
    fun adicionarAluno(aluno: Aluno){
        alunos.add(aluno)
    }
    fun removerAlunoPorCódigo(cod:Int){
        for(a in alunos){
            if(cod == a.cod){
                alunos.remove(a)
            }
        }
    }

}















