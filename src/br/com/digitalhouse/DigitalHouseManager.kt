package br.com.digitalhouse

data class DigitalHouseManager (var alunos: MutableMap<Int, Aluno>,
                                var professores: MutableMap<Int, Professor>,
                                var cursos: MutableMap<Int, Curso>,
                                var matriculas: MutableMap<Curso, List<Aluno>>) {
}