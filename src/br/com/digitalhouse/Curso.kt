package br.com.digitalhouse

class Curso(var nome: String, var codigoCurso: Int, var vagasDisponiveis: Int, var alunos: MutableMap<Int, Aluno>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is Curso) return false

        if (codigoCurso == other.codigoCurso) return true

        return true
    }

    fun adicionarUmAluno(umAluno: Aluno): Boolean{
        return (vagasDisponiveis > 0)
    }

    fun excluirAluno(umAluno: Aluno){
        alunos.remove(umAluno.codigoAluno, umAluno)
    }
}