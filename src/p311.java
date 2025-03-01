import java.util.Scanner;

// todo arreglar problemas

public class p311 {

    Scanner s = new Scanner(System.in);
    char[][] corral;
    int M, N;
    int[][] chivas;

    public static void main(String[] args) {
        p311 solver = new p311();
        solver.iniciar();
    }

    public void iniciar() {
        int[] dimensiones = capturarDimensiones();
        M = dimensiones[0];
        N = dimensiones[1];
        corral = new char[M][N];

        // Inicializar el corral vacío
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                corral[i][j] = '.';
            }
        }

        int numeroChivas = capturarNumeroChivas();
        chivas = capturarCoordenadasChivas(numeroChivas);

        // Colocar las chivas en el corral
        for (int i = 0; i < numeroChivas; i++) {
            int x = chivas[i][0];
            int y = chivas[i][1];
            corral[x][y] = 'C';
        }

        int numeroCasos = capturarNumeroCasos();
        for (int i = 0; i < numeroCasos; i++) {
            int[][] rejas = capturarRejas();
            boolean resultado = comprobarRejas(rejas);
            imprimirResultado(resultado);
        }
    }

    int[] capturarDimensiones() {
        String[] dimensiones = s.nextLine().trim().split(" ");
        return new int[]{Integer.parseInt(dimensiones[0]), Integer.parseInt(dimensiones[1])};
    }

    int capturarNumeroChivas() {
        String[] datosChivas = s.nextLine().trim().split(" ");
        return Integer.parseInt(datosChivas[0]);
    }

    int[][] capturarCoordenadasChivas(int numeroChivas) {
        int[][] coordenadas = new int[numeroChivas][2];
        String[] datosChivas = s.nextLine().trim().split(" ");

        for (int i = 0; i < numeroChivas; i++) {
            coordenadas[i][0] = Integer.parseInt(datosChivas[1 + i * 2]);
            coordenadas[i][1] = Integer.parseInt(datosChivas[2 + i * 2]);
        }

        return coordenadas;
    }

    int capturarNumeroCasos() {
        return Integer.parseInt(s.nextLine().trim());
    }

    int[][] capturarRejas() {
        String[] datosRejas = s.nextLine().trim().split(" ");
        int numeroRejas = Integer.parseInt(datosRejas[0]);
        int[][] rejas = new int[numeroRejas][4];

        for (int i = 0; i < numeroRejas; i++) {
            for (int j = 0; j < 4; j++) {
                rejas[i][j] = Integer.parseInt(datosRejas[1 + i * 4 + j]);
            }
        }

        return rejas;
    }

    boolean comprobarRejas(int[][] rejas) {
        char[][] corralTemporal = copiarCorral();

        // Colocar las rejas en el corral temporal
        for (int[] reja : rejas) {
            int x1 = reja[0];
            int y1 = reja[1];
            int x2 = reja[2];
            int y2 = reja[3];

            if (Math.abs(x2 - x1) != Math.abs(y2 - y1)) {
                return false; // La reja no es diagonal
            }

            // Colocar la reja en diagonal
            int dx = (x2 > x1) ? 1 : -1;
            int dy = (y2 > y1) ? 1 : -1;
            int x = x1, y = y1;

            while (x != x2 + dx && y != y2 + dy) {
                if (corralTemporal[x][y] == 'C') {
                    return false; // No puede pasar por una chiva
                }
                corralTemporal[x][y] = 'R';
                x += dx;
                y += dy;
            }
        }

        // Verificar que cada chiva esté aislada en una región
        boolean[][] visitado = new boolean[M][N];
        int regiones = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (corralTemporal[i][j] == 'C' && !visitado[i][j]) {
                    regiones++;
                    marcarRegion(i, j, visitado, corralTemporal);
                }
            }
        }

        return regiones == chivas.length;
    }

    void marcarRegion(int x, int y, boolean[][] visitado, char[][] corralTemporal) {
        if (x < 0 || x >= M || y < 0 || y >= N || visitado[x][y] || corralTemporal[x][y] == 'R') {
            return;
        }

        visitado[x][y] = true;

        marcarRegion(x + 1, y + 1, visitado, corralTemporal);
        marcarRegion(x - 1, y - 1, visitado, corralTemporal);
        marcarRegion(x + 1, y - 1, visitado, corralTemporal);
        marcarRegion(x - 1, y + 1, visitado, corralTemporal);
    }

    char[][] copiarCorral() {
        char[][] copia = new char[M][N];
        for (int i = 0; i < M; i++) {
            System.arraycopy(corral[i], 0, copia[i], 0, N);
        }
        return copia;
    }

    void imprimirResultado(boolean resultado) {
        System.out.println(resultado ? "SI" : "NO");
    }
}
