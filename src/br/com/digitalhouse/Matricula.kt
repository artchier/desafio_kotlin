package br.com.digitalhouse

import java.util.*

data class Matricula (var aluno: Aluno, var curso: Curso){

    var data = Date()
    init{
        println("Curso: ${curso.nome}\nAluno matriculado: ${aluno.nome}" +
                "\nCódigo do aluno: ${aluno.codigoAluno}\nData de matrícula: $data")
    }
}