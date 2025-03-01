
// La industria ferrocarrilera, ha cambiado desde la época de la revolución industrial,
// sin embargo aún se requiere de hacer maniobras en patios especializados para acomodar los vagones y poder liberarlos de forma rápida en las siguientes estaciones.
// Se requiere de un programa que obtenga cuantos cambios de vagones se necesita hacer en el patio de maniobras para dejar los vagones en el orden adecuado, debo tomar en cuenta que las estaciones se nombran por una clave, así por ejemplo un tren que tiene 6 vagones como a continuación se marca:

// ENOR ENOR EOTE EOTE ESUR ENOR

// Es necesario realizar 3 cambios para tener el orden requerido que se basa en el nombre de las estaciones.

// ENOR ENOR ENOR EOTE EOTE ESUR

// Entrada
// Un número de casos de prueba N (0<N<10), seguido de cada caso de prueba que consta de un número que indica cuantos vagones tiene el tren y las claves de los vagones.

// Salida
// Por cada caso de prueba se mostrará en la pantalla cuantos cambios se requieren para dejar el tren listo.

// Ejemplo de entrada
// 3
// 6
// ENOR ENOR EOTE EOTE ESUR ENOR
// 4
// E34 E54 E40 E60
// 5
// ENOR ESUR ESUR ENOR EEST

// Ejemplo de salida 
// 3
// 1
// 6

// todo genera error en tiempo de ejecución
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class p315 {
    Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        p315 p = new p315();
        int cantCasos = p.cantCasos();
        int[] res = IntStream.range(0, cantCasos)
                             .map(i -> p.cantCambios(p.leerCantVagones(), p.leerVagones()))
                             .toArray();

        Arrays.stream(res).forEach(System.out::println);
    }

    int cantCasos() {
        return Integer.parseInt(s.nextLine());
    }

    int leerCantVagones() {
        return Integer.parseInt(s.nextLine());
    }

    String[] leerVagones() {
        String[] vagones = s.nextLine().split(" ");
        for (int i = 0; i < vagones.length; i++) {
            if (vagones[i] == null || vagones[i].isEmpty()) {
                throw new IllegalArgumentException("");
            }
        }
        return vagones;
    }

    int cantCambios(int cantVagones, String[] vagones) {
        return mergeSortAndCount(vagones, 0, cantVagones - 1);
    }

    int mergeSortAndCount(String[] arr, int l, int r) {
        if (l >= r) return 0;
        int m = (l + r) / 2;
        return mergeSortAndCount(arr, l, m) +
               mergeSortAndCount(arr, m + 1, r) +
               mergeAndCount(arr, l, m, r);
    }

    int mergeAndCount(String[] arr, int l, int m, int r) {
        String[] left = Arrays.copyOfRange(arr, l, m + 1);
        String[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += (left.length - i);
            }
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];

        return swaps;
    }
}