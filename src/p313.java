import java.util.Scanner;
import java.util.Stack;

// todo arreglar problemas

public class p313 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        p313 solver = new p313();
        int numeroCasos = solver.capturarNumeroCasos();

        for (int i = 0; i < numeroCasos; i++) {
            String[] expresion = s.nextLine().trim().split(" ");
            int resultado = solver.evaluarExpresion(expresion);
            solver.imprimirResultado(resultado);
        }
    }

    public int capturarNumeroCasos() {
        int numeroCasos;
        try {
            numeroCasos = Integer.parseInt(s.nextLine().trim());
        } catch (NumberFormatException e) {
            return 0; // En caso de que no sea un número válido
        }
        return numeroCasos;
    }

    public int evaluarExpresion(String[] expresion) {
        Stack<Integer> pila = new Stack<>();
        
        for (String e : expresion) {
            try {
                switch (e) {
                    case "+":
                        if (pila.size() < 2) return Integer.MIN_VALUE;
                        pila.push(pila.pop() + pila.pop());
                        break;
                    case "-":
                        if (pila.size() < 2) return Integer.MIN_VALUE;
                        int bResta = pila.pop();
                        int aResta = pila.pop();
                        pila.push(aResta - bResta);
                        break;
                    case "*":
                        if (pila.size() < 2) return Integer.MIN_VALUE;
                        pila.push(pila.pop() * pila.pop());
                        break;
                    case "/":
                        if (pila.size() < 2) return Integer.MIN_VALUE;
                        int bDiv = pila.pop();
                        int aDiv = pila.pop();
                        if (bDiv == 0) return Integer.MIN_VALUE; // Evitar división entre 0
                        pila.push(aDiv / bDiv);
                        break;
                    case ">":
                        if (pila.size() < 2) return Integer.MIN_VALUE;
                        int exp = pila.pop();
                        int base = pila.pop();
                        if (base == 0 && exp <= 0) return Integer.MIN_VALUE; // Evitar resultados indefinidos
                        pila.push((int) Math.pow(base, exp));
                        break;
                    default:
                        pila.push(Integer.parseInt(e));
                        break;
                }
            } catch (Exception ex) {
                return Integer.MIN_VALUE; // Cualquier excepción se maneja como error
            }
        }
        
        return pila.size() == 1 ? pila.pop() : Integer.MIN_VALUE;
    }

    public void imprimirResultado(int resultado) {
        System.out.println(resultado == Integer.MIN_VALUE ? "error" : resultado);
    }
}
