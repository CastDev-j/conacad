// En una matriz de m renglones y n columnas están colocados números en secuencia entre 1 y (mxn)
// en desorden, se desea saber si existe un camino en la matriz formado por los números que vayan
// de la esquina superior izquierda a la esquina inferior derecha, el camino comienza con un 1 en
// la esquina superior izquierda en donde el movimiento puede ser horizontal, vertical o diagonal
// buscando el siguiente número consecutivo, en caso de poder llegar a la esquina inferior derecha
// se deben imprimir las coordenadas del camino empezando desde 0,0. Si no hay camino se imprime hasta
// la última coordenada a la que se pudo llegar. No existen números repetidos dentro de la matriz.

// Entrada.
// En el primer renglón está el número de matrices para buscar el camino máximo y en el siguiente 
//renglón se define el tamaño del renglones y columnas para cada matriz, en los renglones siguientes 
//están los datos de la matriz separados por un espacio y renglones.

// Salida.
// La salida son las coordenadas renglón columna de cada posición valida de la ruta separados por un espacio, 
//cada camino debe imprimirse en renglones separados.

// Ejemplo de entrada.
// 2
// 4 6
// 1 18 3 4 5 19
// 22 2 23 20 24 6
// 21 11 10 9 8 7
// 12 13 14 15 16 17
// 5 8
// 1 21 3 4 5 10 9 24
// 15 2 20 12 11 6 26 8
// 16 14 13 19 28 29 7 25
// 27 17 18 37 23 34 32 31
// 35 40 39 36 38 33 22 30

// Ejemplo de salida.
// 0 0 1 1 0 2 0 3 0 4 1 5 2 5 2 4 2 3 2 2 2 1 3 0 3 1 3 2 3 3 3 4 3 5
// 0 0 1 1 0 2 0 3 0 4 1 5 2 6 1 7 0 6 0 5 1 4 1 3 2 2 2 1 1 0 2 0 3 1 3 2 2 3 1 2 0 1

import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Arrays;

public class p508 {

    Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        p508 p = new p508();

        int numeroCasos = p.capturarNumeroCasos();
        int[] tamanioCasos = new int[2];
        int[][][] valoresCasos = new int[numeroCasos][][];
        int[][] resultadosCasos = new int[numeroCasos][];

        for (int i = 0; i < numeroCasos; i++) {
            tamanioCasos = p.capturarTamanioCasos();
            valoresCasos[i] = p.capturarValoresCasos(tamanioCasos);
        }

        for (int i = 0; i < numeroCasos; i++)
            resultadosCasos[i] = p.resolverCaso(valoresCasos[i]);

        Stream.of(resultadosCasos).forEach(
                x -> System.out.println(Arrays.toString(x).replace("[", "").replace("]", "").replace(",", "")));
    }

    public int capturarNumeroCasos() {
        return Integer.parseInt(s.nextLine());
    }

    public int[] capturarTamanioCasos() {
        return Stream.of(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public int[][] capturarValoresCasos(int[] tamanioCasos) {
        int filas = tamanioCasos[0];
        int columnas = tamanioCasos[1];

        int[][] valores = new int[filas][columnas];

        for (int i = 0; i < filas; i++)
            valores[i] = Stream.of(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        return valores;
    }

    public int[] resolverCaso(int[][] matrices) {

        int filas = matrices.length;
        int columnas = matrices[0].length;

        int[] resultado = new int[filas * columnas * 2];
        int[] resultadoFinal = new int[filas * columnas * 2];
        int[] resultadoTemporal = new int[filas * columnas * 2];

        int contador = 0;
        int contadorFinal = 0;

        int[] coordenadas = new int[] { 0, 0 };

        resultado[contador] = coordenadas[0];
        resultado[contador + 1] = coordenadas[1];
        contador += 2;

        while (true) {

            int[] coordenadasTemporal = new int[] { coordenadas[0], coordenadas[1] };

            if (coordenadas[0] - 1 >= 0 && coordenadas[1] - 1 >= 0
                    && matrices[coordenadas[0] - 1][coordenadas[1] - 1] == matrices[coordenadas[0]][coordenadas[1]]
                            + 1) {
                coordenadasTemporal[0] = coordenadas[0] - 1;
                coordenadasTemporal[1] = coordenadas[1] - 1;
            } else if (coordenadas[0] - 1 >= 0
                    && matrices[coordenadas[0] - 1][coordenadas[1]] == matrices[coordenadas[0]][coordenadas[1]] + 1) {
                coordenadasTemporal[0] = coordenadas[0] - 1;
            } else if (coordenadas[1] - 1 >= 0
                    && matrices[coordenadas[0]][coordenadas[1] - 1] == matrices[coordenadas[0]][coordenadas[1]] + 1) {
                coordenadasTemporal[1] = coordenadas[1] - 1;
            } else if (coordenadas[0] + 1 < filas && coordenadas[1] - 1 >= 0
                    && matrices[coordenadas[0] + 1][coordenadas[1] - 1] == matrices[coordenadas[0]][coordenadas[1]]
                            + 1) {
                coordenadasTemporal[0] = coordenadas[0] + 1;
                coordenadasTemporal[1] = coordenadas[1] - 1;
            } else if (coordenadas[0] + 1 < filas
                    && matrices[coordenadas[0] + 1][coordenadas[1]] == matrices[coordenadas[0]][coordenadas[1]] + 1) {
                coordenadasTemporal[0] = coordenadas[0] + 1;
            } else if (coordenadas[1] + 1 < columnas
                    && matrices[coordenadas[0]][coordenadas[1] + 1] == matrices[coordenadas[0]][coordenadas[1]] + 1) {
                coordenadasTemporal[1] = coordenadas[1] + 1;
            } else if (coordenadas[0] - 1 >= 0 && coordenadas[1] + 1 < columnas
                    && matrices[coordenadas[0] - 1][coordenadas[1] + 1] == matrices[coordenadas[0]][coordenadas[1]]
                            + 1) {
                coordenadasTemporal[0] = coordenadas[0] - 1;
                coordenadasTemporal[1] = coordenadas[1] + 1;
            } else if (coordenadas[0] + 1 < filas && coordenadas[1] + 1 < columnas
                    && matrices[coordenadas[0] + 1][coordenadas[1] + 1] == matrices[coordenadas[0]][coordenadas[1]]
                            + 1) {
                coordenadasTemporal[0] = coordenadas[0] + 1;
                coordenadasTemporal[1] = coordenadas[1] + 1;
            } else {
                break;
            }

            coordenadas = coordenadasTemporal;

            resultado[contador] = coordenadas[0];
            resultado[contador + 1] = coordenadas[1];
            contador += 2;
        }

        for (int i = 0; i < contador; i++) {
            resultadoTemporal[i] = resultado[i];
        }

        for (int i = 0; i < contador; i++) {
            resultadoFinal[contadorFinal] = resultadoTemporal[i];
            contadorFinal++;
        }

        return Arrays.copyOf(resultadoFinal, contadorFinal);

    }
}
