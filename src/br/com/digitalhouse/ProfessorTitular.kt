package br.com.digitalhouse

class ProfessorTitular(nome: String,
                       sobrenome: String,
                       tempoDeCasa: Int,
                       codigoProfessor: Int,
                       var especialidade: String) : Professor(nome, sobrenome, tempoDeCasa, codigoProfessor) {

    init{
        println("Novo Professor Titular Registrado\nNome: $nome $sobrenome" +
                "\nTempo de Casa: $tempoDeCasa\nCódigo: $codigoProfessor\nEspecialidade: $especialidade")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is Professor) return false

        if (codigoProfessor == other.codigoProfessor) return true

        return true
    }
}