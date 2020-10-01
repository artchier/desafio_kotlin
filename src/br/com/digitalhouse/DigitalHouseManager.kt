package br.com.digitalhouse

data class DigitalHouseManager(var alunos: MutableMap<Int, Aluno>,
                               var professores: MutableMap<Int, Professor>,
                               var cursos: MutableMap<Int, Curso>,
                               var matriculas: MutableMap<Curso, Matricula>) {

    fun registrarCurso(nome: String, codigoCurso: Int, qtdMaximaDeAlunos: Int) {
        cursos[codigoCurso] = Curso(nome, codigoCurso, qtdMaximaDeAlunos)
    }

    fun excluirCurso(codigoCurso: Int) {
        when{
            cursos.containsKey(codigoCurso) -> cursos.remove(codigoCurso)
            else -> println("Curso não encontrado")
        }
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String){
        professores[codigoProfessor] = ProfessorTitular(nome, sobrenome, 0, codigoProfessor, especialidade)
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, horasMonitoria: Int){
        professores[codigoProfessor] = ProfessorAdjunto(nome, sobrenome, 0, codigoProfessor, horasMonitoria)
    }

    fun excluirProfessor(codigoProfessor: Int){
        when{
            professores.containsKey(codigoProfessor) -> professores.remove(codigoProfessor)
            else -> println("Professor não encontrado")
        }
    }

    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int){
        alunos[codigoAluno] = Aluno(nome, sobrenome, codigoAluno)
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int){
        when{
            cursos.containsKey(codigoCurso) -> {
                when{
                    alunos.containsKey(codigoAluno) -> {
                        when(cursos[codigoCurso]!!.adicionarUmAluno(alunos[codigoAluno]!!)){
                            true -> matriculas[cursos[codigoCurso]!!] = Matricula(alunos[codigoAluno]!!, cursos[codigoCurso]!!)
                            false -> println("Curso sem vagas disponíveis\n\n")
                        }
                    }
                    else -> println("Aluno não encontrado\n\n")
                }
            }
            else -> println("Curso não encontrado\n\n")
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int){
        when{
            cursos.containsKey(codigoCurso) ->{
                when{
                    professores.containsKey(codigoProfessorTitular) -> {
                        cursos[codigoCurso]!!.alocaProfessores(professores[codigoProfessorTitular]!!)
                        println("Professor Titular ${professores[codigoProfessorTitular]!!.nome} " +
                                "${professores[codigoProfessorTitular]!!.sobrenome} alocado ao curso ${cursos[codigoCurso]!!.nome} com sucesso\n\n")
                    }
                    else -> {
                        println("Professor Titular não encontrado\n\n")
                    }
                }
                when{
                    professores.containsKey(codigoProfessorAdjunto) -> {
                        cursos[codigoCurso]!!.alocaProfessores(professores[codigoProfessorAdjunto]!!)
                        println("Professor Adjunto ${professores[codigoProfessorAdjunto]!!.nome} " +
                                "${professores[codigoProfessorAdjunto]!!.sobrenome} alocado ao curso ${cursos[codigoCurso]!!.nome} com sucesso\n\n")
                    }
                    else -> println("Professor Adjunto não encontrado\n\n")
                }
            }
            else -> println("Curso não encontrado\n\n")
        }
    }

    fun consultaMatricula(aluno: Aluno?){
        println("Cursos em que ${aluno?.nome} ${aluno?.sobrenome} está matriculado\n")
        matriculas.forEach {
            when(it.key.alunos.contains(aluno?.codigoAluno)){
                true -> println("${it.value.curso.nome}\n${it.value.curso.codigoCurso}\n")
            }
        }
    }
}