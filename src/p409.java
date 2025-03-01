
// Realice un método llamado insert(lista,elemento,posicion) que reciba una lista, un elemento y una posición. El método inserta en la lista el elemento en la posición. Nota que ningún elemento se borra, tan solo se recorren a la derecha cuando se inserta un elemento. El método regresa una nueva lista con el elemento insertado en la posición correcta. No se puede usar un arrayList para hacer el programa.

// La entrada contiene en el primer renglón los datos a usar en la lista es decir el elemento y la posición a insertar separados por un espacio.

// La salida debe mostrar los elementos tal y como quedaron en la lista final separados por un espacio.

// Ejemplo de entrada:

// 10 0 20 1 30 2 4 1 2 0 0 3 3 4 3 4 5 7 3 1 2 5

// Ejemplo de salida: 

// 2 3 10 4 0 2 3 3 20 5 30

import java.util.Scanner;
import java.util.stream.IntStream;

public class p409 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split(" ");
        int[] list = new int[100];
        int currentSize = IntStream.range(0, input.length / 2)
                                   .reduce(0, (size, i) -> insert(list, size, Integer.parseInt(input[2 * i]), Integer.parseInt(input[2 * i + 1])));
        IntStream.range(0, currentSize).forEach(i -> System.out.print(list[i] + " "));
        s.close();
    }

    static int insert(int[] list, int size, int element, int position) {
        if (position > size) position = size;
        System.arraycopy(list, position, list, position + 1, size - position);
        list[position] = element;
        return size + 1;
    }
}
