package br.com.digitalhouse

fun main(){

    val alunos = mutableListOf<Aluno>()
    val professores = mutableListOf<Professor>()
    val cursos = mutableListOf<Curso>()
    val matriculas = mutableListOf<Matricula>()

    val manager = DigitalHouseManager(alunos, professores, cursos, matriculas)

    manager.registrarProfessorTitular("Professor", "1", 1, "Especialidade 1")
    manager.registrarProfessorTitular("Professor", "2", 2, "Especialidade 2")
    manager.registrarProfessorAdjunto("Professor", "3", 3, 60)
    manager.registrarProfessorAdjunto("Professor", "4", 4, 90)

    manager.registrarCurso("Full Stack", 20001, 3)
    manager.registrarCurso("Android", 20002, 2)

    manager.alocarProfessores(20001, 1, 3)
    manager.alocarProfessores(20002, 2, 4)

    manager.registrarAluno("Aluno", "1", 1)
    manager.registrarAluno("Aluno", "2", 2)
    manager.matricularAluno(1, 20001)
    manager.matricularAluno(2, 20001)

    manager.registrarAluno("Aluno", "3", 3)
    manager.registrarAluno("Aluno", "4", 4)
    manager.registrarAluno("Aluno", "5",  5)
    manager.matricularAluno(3, 20002)
    manager.matricularAluno(4, 20002)
    manager.matricularAluno(5, 20002)
}