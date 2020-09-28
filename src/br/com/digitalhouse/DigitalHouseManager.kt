package br.com.digitalhouse

data class DigitalHouseManager(var alunos: MutableList<Aluno>,
                               var professores: MutableList<Professor>,
                               var cursos: MutableList<Curso>,
                               var matriculas: MutableList<Matricula>) {

    fun registrarCurso(nome: String, codigoCurso: Int, qtdMaximaDeAlunos: Int) {
        cursos.add(Curso(nome, codigoCurso, qtdMaximaDeAlunos))
    }

    fun excluirCurso(codigoCurso: Int) {
        var achou: Boolean = false
        cursos.forEach {
            if(it.codigoCurso == codigoCurso){
                cursos.remove(it)
                achou = true
                println("Curso excluído")
            }
        }
        if(!achou)
            println("Curso não encontrado")
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String){
        professores.add(ProfessorTitular(nome, sobrenome, 0, codigoProfessor, especialidade))
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, horasMonitoria: Int){
        professores.add(ProfessorAdjunto(nome, sobrenome, 0, codigoProfessor, horasMonitoria))
    }

    fun excluirProfessor(codigoProfessor: Int){
        var achou: Boolean = false
        professores.forEach {
            if (it.codigoProfessor == codigoProfessor){
                professores.remove(it)
                achou = true
            }
        }
        if(!achou)
            println("Professor não encontrado")
    }

    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int){
        alunos.add(Aluno(nome, sobrenome, codigoAluno))
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int){
        val achou = arrayOf(false, false)
        for(num in 0 until cursos.size){
            if(cursos[num].codigoCurso == codigoCurso){
                alunos.forEach {
                    if(it.codigoAluno == codigoAluno){
                        if(cursos[num].adicionarUmAluno(it))
                            matriculas.add(Matricula(it, cursos[num]))
                        else
                            println("Curso sem vagas disponíveis")
                        achou[1] = true
                    }
                }
                achou[0] = true
            }
        }
        if(!achou[0])
            println("Curso não encontrado")
        else if(!achou[1])
            println("Aluno não encontrado")
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int){
        val achou = arrayOf(false, false, false)
        for(num in 1 until cursos.size){
            when(professores[num].codigoProfessor){
                (codigoProfessorTitular) -> {
                    cursos.forEach {
                        if (it.codigoCurso == codigoCurso) {
                            it.alocaProfessores(professores[num])
                            println("Novo professor titular alocado")
                            achou[2] = true
                        }
                    }
                    achou[0] = true
                }
                (codigoProfessorAdjunto) -> {
                    cursos.forEach {
                        if(it.codigoCurso == codigoCurso){
                            it.alocaProfessores(professores[num])
                            println("Novo professor adjunto alocado")
                            achou[2] = true
                        }
                    }
                    achou[1] = true
                }
            }
        }
        if(!achou[2])
            println("Professor não encontrado")
        else if(!achou[0])
            println("Curso não encontrado")
    }
}