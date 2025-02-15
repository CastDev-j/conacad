// beecrowd | 1115
// Cuadrante
// Adaptado por Neilor Tonin, URI  Brazil

// Timelimit: 1
// Escribir un programa que lea las coordenadas (X, Y) de un número indeterminado de puntos en el sistema Cartesiano. Para cada punto escribir el cuadrante al cual pertenece. El programa finaliza cuando al menos una de dos coordenadas es NULL (sin escribir ningún mensaje en esta situación).

// Entrada
// La entrada contiene varios casos de pruebas. Cada caso de prueba contiene dos números enteros.

// Salida
// Para cada caso de prueba, imprimir el cuadrante correspondiente al cual pertenecen las coordenadas, en portugues, como en el ejemplo.

import java.io.IOException;
import java.util.Scanner;

public class p1115 {
    public Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        p1115 m = new p1115();
        m.testCases();


    }

    public void testCases() {
        while (true) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 0 || y == 0) {
                break;
            }
            if (x > 0 && y > 0) {
                System.out.println("primeiro");
            } else if (x < 0 && y > 0) {
                System.out.println("segundo");
            } else if (x < 0 && y < 0) {
                System.out.println("terceiro");
            } else {
                System.out.println("quarto");
            }
        }
    }
}
