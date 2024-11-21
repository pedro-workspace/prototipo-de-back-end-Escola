import CustomExceptions.DisciplinaNotFoundException
import CustomExceptions.FormaçãoNotFoundException
import CustomExceptions.NãoMatriculadoException
import node.Aluno
import node.Disciplina
import node.Formação

class Escola {
    private var formações:MutableList<Formação> = mutableListOf()
    private lateinit var disciplinasDisponíveis:MutableList<Disciplina>
    private lateinit var alunos:MutableList<Aluno>

    fun adicionarDisciplinaDisponível(disciplina: Disciplina){
        disciplinasDisponíveis.add(disciplina)
    }
    fun removerDisciplinaDisponívelPorCódigo(cod:Int){
        disciplinasDisponíveis.forEach{
            d -> if(d.cod == cod){
                disciplinasDisponíveis.remove(d)
            }
        }
    }
    fun adicionarFormação(formação: Formação){
        var nãoEncontradas:Int = 0
        formação.getDisciplinas().forEach{
            d -> if(d !in disciplinasDisponíveis){
                nãoEncontradas += 1
                throw DisciplinaNotFoundException("${d.nome} não está presente na lista de disciplinas disponíves")
            }
            if(nãoEncontradas == 0){
                formações.add(formação)
            }
        }
    }
    fun removerFormaçãoPorCódgigo(cod:Int){
        formações.forEach{
            f -> if(cod == f.cod){
                formações.remove(f)
            }
        }
    }
    fun matricularAlunoNaEscola(aluno:Aluno){
        alunos.add(aluno);
    }
    fun matricularAlunoNumaFormação(aluno: Aluno, formação: Formação){
        if(aluno in alunos){
            if(formação in formações){
                formação.adicionarAluno(aluno)
            }else{
                throw FormaçãoNotFoundException("${formação.getNome()} não encontrada")
            }
        }else{
            throw NãoMatriculadoException("${aluno.nome} não matriculado, favor realizar cadastro no sistema")
        }
    }
    fun removerAlunoDaEscola(aluno: Aluno){
        alunos.remove(aluno)
        formações.forEach{
            f -> if(aluno in f.getAlunos()){
                f.removerAlunoPorCódigo(aluno.cod)
            }
        }
    }
    fun removerAlunoDaFormação(aluno:Aluno, formação: Formação){
        if(formação in formações){
            if(aluno in formação.getAlunos()){
                formação.removerAlunoPorCódigo(aluno.cod)
            }else{
                throw NãoMatriculadoException("${aluno.nome} não matriculado")
            }
        }else{
            throw FormaçãoNotFoundException("${formação.getNome()} não encontrada")
        }
    }

}