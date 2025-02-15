// Promedios Ponderados
// Adaptado por Neilor Tonin, URI  Brazil

// Límite de Tiempo: 1
// Leer un número entero N, que representa el número de casos de prueba siguientes. Cada caso de prueba consta de tres números de punto flotante, cada uno con un dígito después del punto decimal. Imprima el promedio ponderado para cada uno de estos conjuntos de tres números, considerando que el primer número tiene peso 2, el segundo número tiene peso 3 y el tercer número tiene peso 5.

// Entrada
// El archivo de entrada contiene un número entero N en la primera línea. Cada una de las N líneas siguientes es un caso de prueba con tres números de punto flotante, cada uno con un dígito después del punto decimal.

// Salida
// Para cada caso de prueba, imprimir el promedio ponderado según el siguiente ejemplo.

// Ejemplo de entrada	Ejemplo de salida
// 3
// 6.5 4.3 6.2
// 5.1 4.2 8.1
// 8.0 9.0 10.0

// 5.7
// 6.3
// 9.3

// Traducido por Nicolás Bieler

import java.io.IOException;
import java.util.Scanner;
 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class p1079 {
 
    public Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
 
        p1079 m = new p1079();
        int n = m.numberOfTests();
        double[] result = m.testCases(n);
        for (int i = 0; i < n; i++) {
            System.out.printf("%.1f\n", result[i]);
        }

    }

    public int numberOfTests() {
        int n = Integer.parseInt(sc.nextLine());
        return n;
    }

    public double[] testCases(int n) {
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            double a = Double.parseDouble(line[0]);
            double b = Double.parseDouble(line[1]);
            double c = Double.parseDouble(line[2]);
            result[i] = (a * 2 + b * 3 + c * 5) / 10;
        }
        return result;
    }
 
}
