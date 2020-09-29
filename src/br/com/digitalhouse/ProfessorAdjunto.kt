package br.com.digitalhouse

class ProfessorAdjunto(nome: String,
                       sobrenome: String,
                       tempoDeCasa: Int,
                       codigoProfessor: Int,
                       horasMonitoria: Int) : Professor(nome, sobrenome, tempoDeCasa, codigoProfessor) {

    init{
        println("Novo Professor Adjunto Registrado\nNome: $nome $sobrenome" +
                "\nTempo de Casa: $tempoDeCasa\nCódigo: $codigoProfessor\nQuantidade de Horas de Monitoria: $horasMonitoria\n\n")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is Professor) return false

        if (codigoProfessor == other.codigoProfessor) return true

        return true
    }
}