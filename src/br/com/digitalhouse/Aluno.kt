package br.com.digitalhouse

data class Aluno(val nome: String, var sobrenome: String, val codigoAluno: Int) {

    override fun equals(other: Any?): Boolean {
        if(this === other) return true

        if(other !is Aluno) return false

        if(codigoAluno == other.codigoAluno) return true

        return true
    }
}