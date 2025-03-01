import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.Stack;

public class p337 {

    Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        p337 p = new p337();

        int numeroSecuencias = p.capturarNumeroSecuencias();
        int[] Resultadosecuencias = new int[numeroSecuencias];

        for (int i = 0; i < numeroSecuencias; i++) {
            Resultadosecuencias[i] = p.resolverSecuencia(p.capturarSecuencia());
        }

        Arrays.stream(Resultadosecuencias).forEach(System.out::println);

    }

    public int capturarNumeroSecuencias() {
        return Integer.parseInt(s.nextLine());
    }

    public int[] capturarSecuencia() {
        return Stream.of(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public int resolverSecuencia(int[] secuencia) {
        Stack<Integer> principal = new Stack<>();
        Stack<Integer> auxiliar = new Stack<>();
        int[] operaciones = {0};

        Arrays.stream(secuencia).forEach(num -> {
            if (principal.isEmpty() || num < principal.peek()) {
                principal.push(num);
                operaciones[0]++;
            } else {
                while (!principal.isEmpty() && num > principal.peek()) {
                    auxiliar.push(principal.pop());
                    operaciones[0]++;
                }
                principal.push(num);
                operaciones[0]++;
                while (!auxiliar.isEmpty()) {
                    principal.push(auxiliar.pop());
                    operaciones[0]++;
                }
            }
        });

        return operaciones[0];
    }
}
