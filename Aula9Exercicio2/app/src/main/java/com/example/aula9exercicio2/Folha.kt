package com.example.aula9exercicio2

class Folha (var nome: String, var horasTrab: Int, var valorHora: Float) {

    var salBruto: Float
    var salLiq: Float
    var ir: Float
    var inss: Float
    var fgts: Float

    init {

        salBruto = horasTrab * valorHora

        ir =  if (salBruto <= 1372.81f) {
            0f
        } else if (salBruto <= 2743.25f) {
            salBruto * 0.15f
        } else {
            salBruto * 0.275f
        }

        inss = if (salBruto <= 868.29f) {
            salBruto * 0.08f
        } else if (salBruto <= 1448.14f) {
            salBruto * 0.09f
        } else if (salBruto <= 2894.28f) {
            salBruto * 0.11f
        } else {
            318.37f
        }

        fgts = salBruto * 0.08f

        salLiq = salBruto - ir - inss

    }

    override fun toString(): String {
        return "NOME: $nome\n" +
                "HORAS TRABALHADAS: $horasTrab h \n" +
                "VALOR DA HORA: R$ $valorHora\n" +
                "SAL. BRUTO: R$ $salBruto\n" +
                "IR: R$ $ir\n" +
                "INSS: R$ $inss\n" +
                "FGTS: R$ $fgts\n" +
                "SAL. LIQUIDO: R$ $salLiq"
    }

}