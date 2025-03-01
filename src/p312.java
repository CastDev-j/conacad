// Haz un programa que pueda evaluar si una expresión con paréntesis,
// está bien construida, es decir, que por cada paréntesis abierto 
//"(", exista un paréntesis cerrado ")" y que los paréntesis están colocados correctamente,
// la entrada contiene en el primer renglón el número de casos a evaluar y en los siguientes
// renglones cadenas de símbolos que contienen paréntesis. La salida debe imprimir correcto 
//en minúsculas si los paréntesis están completos y bien colocados o incorrecto en minúsculas en caso contrario.

// Ejemplo de entrada
// 3
// (a(bf45(%643)))
// (abdc3f*()0))
// )abcdef()()9(

// Ejemplo de salida
// correcto
// incorrecto
// incorrecto

import java.util.Scanner;
import java.util.Arrays;

public class p312 {

    Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        p312 p = new p312();

        int numeroCasos = p.capturarNumeroCasos();
        CasosValidos[] ResultadoCasos = new CasosValidos[numeroCasos];

        for (int i = 0; i < numeroCasos; i++) {
            ResultadoCasos[i] = p.resolverCaso(p.capturarCaso());
        }

        Arrays.stream(ResultadoCasos).forEach(System.out::println);

    }

    public int capturarNumeroCasos() {
        return Integer.parseInt(s.nextLine());
    }

    public String capturarCaso() {
        return s.nextLine();
    }

    public CasosValidos resolverCaso(String cadena) {
        boolean isValid = true;

        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '(') {
                contador++;
            } else if (cadena.charAt(i) == ')') {
                contador--;
            }

            if (contador < 0) {
                isValid = false;
                break;
            }
        }

        if (contador != 0) {
            isValid = false;
        }

        return isValid ? CasosValidos.correcto : CasosValidos.incorrecto;
    }
}

enum CasosValidos {
    correcto,
    incorrecto
}