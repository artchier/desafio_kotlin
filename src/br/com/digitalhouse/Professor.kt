package br.com.digitalhouse

abstract class Professor(val nome: String, var sobrenome: String, var tempoDeCasa: Int, val codigoProfessor: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is Professor) return false

        if (codigoProfessor == other.codigoProfessor) return true

        return true
    }
}