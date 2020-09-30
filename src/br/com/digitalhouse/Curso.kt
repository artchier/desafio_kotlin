package br.com.digitalhouse

class Curso(var nome: String, var codigoCurso: Int) {

    private var alunos = mutableMapOf<Int, Aluno>()
    private var vagasDisponiveis: Int = 0
    private var professoresAlocados = mutableMapOf<Int, Professor>()

    constructor(nome: String, codigoCurso: Int, _vagasDisponiveis: Int) : this(nome, codigoCurso) {
        vagasDisponiveis = _vagasDisponiveis
    }

    init{
        println("Novo Curso Registrado\nNome do Curso: $nome" +
                "\nCódigo: $codigoCurso\n\n")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is Curso) return false

        if (codigoCurso == other.codigoCurso) return true

        return true
    }

    fun adicionarUmAluno(umAluno: Aluno): Boolean{
        when {
            vagasDisponiveis > 0 -> {
                alunos[umAluno.codigoAluno] = umAluno
                return ((vagasDisponiveis--) > 0)
            }
        }
        return false
    }

    fun excluirAluno(umAluno: Aluno){
        alunos.remove(umAluno)
        println("Aluno ${umAluno.nome} ${umAluno.sobrenome} excluído com sucesso\n\n")
        vagasDisponiveis++
    }

    fun alocaProfessores(professor: Professor){
        professoresAlocados[professor.codigoProfessor] = professor
    }
}