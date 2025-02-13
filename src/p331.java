
// Haz un programa que acepte números de tipo entero y real. La
// entrada contiene en el primer renglón la cantidad de números que hay que reconocer y a continuación hay un número por renglón en el archivo de entrada.
// El programa debe reconocer cada uno de esos tipos e imprimir la salida (ENT) para los números en formato entero, (REA) para los número reales, en otro caso se imprime (ERR).

// Ejemplo de entrada
// 5
// 3.2
// -54632
// 1234567890
// --2345
// -3.456.45

// Ejemplo de salida

// REA
// ENT
// ENT
// ERR
// ERR

import java.util.Scanner;

 class p331 {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        p331 app = new p331();

        int lines = app.linesToRead();

        String[] numbers = app.readNumbersAndReturnTypes(lines);

        for (String number : numbers) {
            System.out.println(number);
        }

    }

    private int linesToRead() {
        int lines = Integer.parseInt(sc.nextLine());
        return lines;
    }

    private String[] readNumbersAndReturnTypes(int lines) {
        String[] numbers = new String[lines];

        for (int i = 0; i < lines; i++) {
            String line = sc.nextLine();
            numbers[i] = getNumberType(line);
        }

        return numbers;
    }

    private String getNumberType(String number) {
        if (isDouble(number)) {
            return "REA";
        } else if (isInteger(number)) {
            return "ENT";
        } else {
            return "ERR";
        }
    }

    private boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDouble(String number) {
        try {
            Double doubleValue = Double.parseDouble(number);

            if (doubleValue % 1 == 0) {
                return false;
            }


            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
