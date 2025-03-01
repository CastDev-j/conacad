// Construye un metodo recursivo (sin ciclos) para un aparato del gimnasio calcule cuantos kilos esta levantando el usuario.
// Si el aparato en su carga maxima son 120 kg. y cada nivel superior baja en 5 kg
// hasta 60 kg. en su carga minima. Cuantos kilos levanto el usuario si cada nivel lo ejecuta dos veces con n 
// repeticiones en su carga maxima y por cada dos niveles que baja de peso sube m repeticiones hasta
// llegar a la carga minima.

// Ejemplo con tres niveles con n=6 y m=2
// 120X2X6   =  1440
// 115X2X6   =  1380
// 110X2X8   =  1760
// 105X2X8   =  1680
// 100X2X10  =  2000
// 95X2X10   =  1900
// 90X2X12   =  2160
// 85x2x12   =  2040
// 80x2x14   =  2240
// 75X2X14   =  2100
// 70x2X16   =  2240
// 65x2x16   =  2080
// 60X2X18   =  2160
//  total    = 25180

// Entrada. La entrada contiene un renglon con los valores de n y m separados por un espacio.

// Salida. La salida son los kilos totales hechos por el usuario, vea ejemplo de salida.

// Ejemplo de entrada.
// 6 2

// Ejemplo de salida.
// 25180 kg    import java.util.Scanner;

import java.util.Scanner;

public class p515 {

    public static void main(String[] args) {
        p515 instance = new p515();
        instance.execute();
    }

    public void execute() {
        Scanner sc = new Scanner(System.in);
        String input = readInput(sc);
        int[] parsedInput = parseInput(input);
        int n = parsedInput[0];
        int m = parsedInput[1];
        sc.close();

        int totalWeight = calculateWeight(120, n, m, 0);
        displayResult(totalWeight);
    }

    private String readInput(Scanner sc) {
        return sc.nextLine();
    }

    private int[] parseInput(String input) {
        String[] parts = input.split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return new int[]{n, m};
    }

    private int calculateWeight(int weight, int repetitions, int increment, int level) {
        if (isWeightBelowThreshold(weight)) {
            return 0;
        }

        int totalRepetitions = computeTotalRepetitions(repetitions);
        int weightTotal = computeWeightTotal(weight, totalRepetitions);
        int newRepetitions = computeNewRepetitions(repetitions, increment, level);

        return weightTotal + calculateWeight(decrementWeight(weight), newRepetitions, increment, incrementLevel(level));
    }

    private boolean isWeightBelowThreshold(int weight) {
        return weight < 60;
    }

    private int computeTotalRepetitions(int repetitions) {
        return repetitions * 2;
    }

    private int computeWeightTotal(int weight, int totalRepetitions) {
        return weight * totalRepetitions;
    }

    private int computeNewRepetitions(int repetitions, int increment, int level) {
        if (isOddLevel(level)) {
            return repetitions + increment;
        }
        return repetitions;
    }

    private boolean isOddLevel(int level) {
        return level % 2 == 1;
    }

    private int decrementWeight(int weight) {
        return weight - 5;
    }

    private int incrementLevel(int level) {
        return level + 1;
    }

    private void displayResult(int totalWeight) {
        System.out.println(formatResult(totalWeight));
    }

    private String formatResult(int totalWeight) {
        return totalWeight + " kg";
    }
}