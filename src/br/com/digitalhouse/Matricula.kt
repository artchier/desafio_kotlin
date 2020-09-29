package br.com.digitalhouse

import java.util.*

class Matricula (aluno: Aluno, curso: Curso){

    var data = Date()
    init{
        println("Nova Matrícula Registrada\nCurso: ${curso.nome}\nAluno matriculado: ${aluno.nome} ${aluno.sobrenome}" +
                "\nCódigo do aluno: ${aluno.codigoAluno}\nData de matrícula: $data\n\n")
    }
}