// beecrowd | 1094
// Experimentos
// Adaptado por Neilor Tonin, URI  Brazil

// Tiempo Limite: 1
// María recién empieza como una estudiante graduada en una escuela médica y ella necesita tu ayuda para organizar un experimento del laboratorio del que ella es responsable. Ella quiere saber, al final del año, cuantos animales fueron usados en este laboratorio y el porcentaje de cada tipo de animales usados en absoluto.

// Este laboratorio usa en particular tres tipos de animales: ranas, ratas y conejos. Para obtener esta información, se sabe exactamente el número de experimentos que se realizaron, el tipo y la cantidad de cada animal que se utiliza en cada experimento.

// Entradas
// La primera línea contiene un entero N que indica el número de casos de prueba que lo preceden. Cada caso de prueba contiene un entero Cantidad (1 ≤ Cantidad ≤ 15) que representa la cantidad de animales usados y un caracter Tipo ('C', 'R' o 'S'), que indica el tipo de animal:
// - C: Coelho (conejo en portuguese)
// - R: Rato (rata  en portuguese)
// - S: Sapo (rana en portuguese)

// Salidas
// Imprime el total de animales usados, el total de cada tipo de animal y el porcentaje de cada uno en relación al total de animales usados. El porcentaje debe ser impreso con dos dígitos después del punto decimal.

// Ejemplo de Entrada	Ejemplo de Salida
// 10
// 10 C
// 6 R
// 15 S
// 5 C
// 14 R
// 9 C
// 6 R
// 8 S
// 5 C
// 14 R

// Total: 92 cobaias
// Total de coelhos: 29
// Total de ratos: 40
// Total de sapos: 23
// Percentual de coelhos: 31.52 %
// Percentual de ratos: 43.48 %
// Percentual de sapos: 25.00 %

// Traducido por Santiago Cobelli.

import java.io.IOException;
import java.util.Scanner;

public class p1094 {

    public Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    
            p1094 m = new p1094();
            int n = m.numberOfTests();
            int[] result = m.testCases(n);
            m.printResults(result); 

    }

    public int numberOfTests() {
        int n = sc.nextInt();
        return n;
    }

    public int[] testCases(int n) {
        int[] result = new int[n];
        int total = 0;
        int rabbits = 0;
        int rats = 0;
        int frogs = 0;
        for (int i = 0; i < n; i++) {
            int amount = sc.nextInt();
            char type = sc.next().charAt(0);
            total += amount;
            switch (type) {
                case 'C':
                    rabbits += amount;
                    break;
                case 'R':
                    rats += amount;
                    break;
                case 'S':
                    frogs += amount;
                    break;
            }
        }
        result[0] = total;
        result[1] = rabbits;
        result[2] = rats;
        result[3] = frogs;
        return result;
    }

    public void printResults(int[] result) {
        System.out.println("Total: " + result[0] + " cobaias");
        System.out.println("Total de coelhos: " + result[1]);
        System.out.println("Total de ratos: " + result[2]);
        System.out.println("Total de sapos: " + result[3]);
        System.out.printf("Percentual de coelhos: %.2f %%\n", (result[1] * 100.0) / result[0]);
        System.out.printf("Percentual de ratos: %.2f %%\n", (result[2] * 100.0) / result[0]);
        System.out.printf("Percentual de sapos: %.2f %%\n", (result[3] * 100.0) / result[0]);
    }

}
