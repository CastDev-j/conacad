// En varias cajas de madera de 3x3 se colocan nueve dados siguiendo las reglas siguientes, en renglones contiguos la suma de dos dados debe ser impar y en las columnas la suma de dos dados juntos debe ser par. Solo se puede usar un mismo número dos veces y deben usarse los dígitos del 1 al 6 por lo menos una vez para que la solución sea válida. Se deben colocar de arriba hacia abajo en la caja los valores mas chicos posibles a menos  que un numero alto vaya forzamente en una posicion.

// 6 6 4
// 1 3 5
// 2 2 4
// Figura 1. Ejemplo de una caja de dados completa

// Desgraciadamente en las cajas se han perdido algunos dados y el programa debe determinar dónde colocar los dados faltantes para respetar las reglas. Un dado perdido aparece como un cero.

// Entrada.
// La entrada contiene en el primer renglón el número de cajas (o casos) para determinar los dados perdidos. En los siguientes renglones están los números de todas las cajas de 3x3 separadas por un espacio y por renglones.

// Salida.
// La salida debe mostrar las cajas completas con los valores de los dados faltantes imprimiendo cada caja despues de otra.

// Ejemplo de entrada
// 2
// 6 0 4
// 0 3 5
// 2 0 4
// 5 0 0
// 4 0 2
// 3 5 0

// Ejemplo de salida
// 6 2 4
// 1 3 5
// 2 6 4
// 5 1 1
// 4 6 2
// 3 5 3

// todo genera resultado incorrecto

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p509 {

    Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        p509 p = new p509();
        int cases = p.readQuantities();
        int[][][] boxes = new int[cases][][];
        for (int i = 0; i < cases; i++) {
            boxes[i] = p.readCase();
            boxes[i] = p.completeBox(boxes[i]);
        }
        p.printBoxes(boxes);
    }

    int readQuantities() {
        return Integer.parseInt(s.nextLine());
    }

    int[][] readCase() {
        int[][] box = new int[3][3];
        for (int i = 0; i < 3; i++) {
            box[i] = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return box;
    }

    int[][] completeBox(int[][] box) {
        Set<Integer> usedNumbers = new HashSet<>();
        for (int[] row : box) {
            for (int num : row) {
                if (num != 0) {
                    usedNumbers.add(num);
                }
            }
        }

        int[] allNumbers = {1, 2, 3, 4, 5, 6};
        int[][] positions = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (box[i][j] == 0) {
                    for (int num : allNumbers) {
                        if (!usedNumbers.contains(num)) {
                            box[i][j] = num;
                            if (isValid(box)) {
                                usedNumbers.add(num);
                                break;
                            } else {
                                box[i][j] = 0;
                            }
                        }
                    }
                }
            }
        }
        return box;
    }

    boolean isValid(int[][] box) {
        int evenRows = 0;
        int oddRows = 0;

        for (int i = 0; i < 3; i++) {
            int evenCount = 0;
            int oddCount = 0;
            for (int j = 0; j < 3; j++) {
                if (box[i][j] % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
            if (evenCount == 3) {
                evenRows++;
            } else if (oddCount == 3) {
                oddRows++;
            }
        }

        // Check the rule: two rows of even numbers and one row of odd numbers
        if (evenRows != 2 || oddRows != 1) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if ((box[i][j] + box[i][j + 1]) % 2 == 0) return false;
                if ((box[j][i] + box[j + 1][i]) % 2 != 0) return false;
            }
        }
        return true;
    }

    void printBoxes(int[][][] boxes) {
        for (int[][] box : boxes) {
            for (int[] row : box) {
                for (int i : row) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }
}