package br.com.digitalhouse

class Curso(var nome: String, var codigoCurso: Int) {

    private var alunos = mutableListOf<Aluno>()
    private var vagasDisponiveis: Int = 0
    private var professoresAlocados = mutableListOf<Professor>()

    constructor(nome: String, codigoCurso: Int, _vagasDisponiveis: Int) : this(nome, codigoCurso) {
        vagasDisponiveis = _vagasDisponiveis
    }

    init{
        println("Novo Curso Registrado\nNome do Curso: $nome" +
                "\nCódigo: $codigoCurso\nQuantidade Máxima de Alunos: $vagasDisponiveis")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is Curso) return false

        if (codigoCurso == other.codigoCurso) return true

        return true
    }

    fun adicionarUmAluno(umAluno: Aluno): Boolean{
        return ((vagasDisponiveis--) > 0)
    }

    fun excluirAluno(umAluno: Aluno){
        alunos.remove(umAluno)
    }

    fun alocaProfessores(professor: Professor){
        professoresAlocados.add(professor)
    }
}