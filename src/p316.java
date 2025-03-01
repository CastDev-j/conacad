
// En el juego de domino hay que colocar las fichas para que empaten
// los puntos de los extremos para seguir jugando, construye un programa
// que permita verificar el armado de tableros de domino según las
// siguientes reglas.

// Entrada
// El archivo de entrada contiene en el primer renglón el número de casos
// a probar y a continuación cada renglón contiene un caso que está formado
// por un conjunto de números separados por espacios que están en el rango
// del 0 al 6, representado fichas de domino que contienen dos números por
// ficha.

// Salida
// La salida debe mostrar el texto OK si se logran colocar exitosamente todas
// las fichas en el tablero de juego, si se repite una ficha que ya ha sido
// colocada se imprime la salida REP y en caso de no poder colocar todas las
// fichas dentro del tablero la salida es NOK.

// Ejemplo de entrada
// 3
// 6 6 6 1 1 0 0 3 3 5
// 0 0 0 1 1 0 0 3
// 6 6 6 5 5 1 1 3 5 4 0 1

// Ejemplo de salida
// OK
// REP
// NOK

import java.util.*;

public class p316 {

    Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        p316 p = new p316();

        int cases = p.readQuantities();
        String[] results = new String[cases];

        for (int i = 0; i < cases; i++) {
            int[] caseToValuate = p.readCase();
            results[i] = p.checkCase(caseToValuate);
        }

        for (String result : results) {
            System.out.println(result);
        }

    }

    int readQuantities() {
        return Integer.parseInt(s.nextLine());
    }

    int[] readCase() {
        return Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    String checkCase(int[] caseToValuate) {
        List<int[]> dominoes = new ArrayList<>();
        Set<String> usedDominoes = new HashSet<>();
        
        for (int i = 0; i < caseToValuate.length; i += 2) {
            int[] domino = {caseToValuate[i], caseToValuate[i + 1]};
            Arrays.sort(domino); 
            String dominoStr = Arrays.toString(domino);
            if (usedDominoes.contains(dominoStr)) {
                return "REP";
            }
            usedDominoes.add(dominoStr);
            dominoes.add(domino);
        }

        if (dominoes.isEmpty()) {
            return "NOK";
        }

        int[] current = dominoes.remove(0);
        while (!dominoes.isEmpty()) {
            boolean found = false;
            for (Iterator<int[]> iterator = dominoes.iterator(); iterator.hasNext();) {
                int[] domino = iterator.next();
                if (current[1] == domino[0]) {
                    current = domino;
                    iterator.remove();
                    found = true;
                    break;
                } else if (current[1] == domino[1]) {
                    current = new int[]{domino[1], domino[0]};
                    iterator.remove();
                    found = true;
                    break;
                }
            }
            if (!found) {
                return "NOK";
            }
        }

        return "OK";
    }
}