import java.util.*;

// todo arreglar problemas

public class p410 {

    Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        p410 solver = new p410();

        Coordenada coordenadaFichaNegra = solver.capturarCoordenada();
        int numeroCasos = solver.capturarNumeroCasos();
        List<String> resultados = new ArrayList<>();

        for (int i = 0; i < numeroCasos; i++) {
            List<Coordenada> fichasBlancas = solver.capturarTodasCoordenadasFichasBlancas();
            List<Coordenada> fichasFaltantes = solver.encontrarFichasFaltantes(coordenadaFichaNegra, fichasBlancas);

            StringBuilder resultado = new StringBuilder();
            for (Coordenada ficha : fichasFaltantes) {
                resultado.append(ficha.x).append(" ").append(ficha.y).append(" ");
            }
            resultados.add(resultado.toString().trim());
        }

        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }

    public Coordenada capturarCoordenada() {
        String[] coordenadas = s.nextLine().trim().split(" ");
        return new Coordenada(Integer.parseInt(coordenadas[0]), Integer.parseInt(coordenadas[1]));
    }

    public int capturarNumeroCasos() {
        return Integer.parseInt(s.nextLine().trim());
    }

    public List<Coordenada> capturarTodasCoordenadasFichasBlancas() {
        String[] coordenadas = s.nextLine().trim().split(" ");
        List<Coordenada> fichasBlancas = new ArrayList<>();
        for (int i = 0; i < coordenadas.length; i += 2) {
            fichasBlancas.add(new Coordenada(Integer.parseInt(coordenadas[i]), Integer.parseInt(coordenadas[i + 1])));
        }
        return fichasBlancas;
    }

    public List<Coordenada> encontrarFichasFaltantes(Coordenada fichaNegra, List<Coordenada> fichasBlancas) {
        Set<Coordenada> posiblesCoordenadas = generarPosiblesCoordenadas(fichaNegra, fichasBlancas);
        List<Coordenada> faltantes = new ArrayList<>();

        for (Coordenada c : posiblesCoordenadas) {
            if (!fichasBlancas.contains(c)) {
                faltantes.add(c);
            }
        }

        // Ordenar las coordenadas para asegurar consistencia en la salida
        faltantes.sort(Comparator.comparingInt((Coordenada c) -> c.x).thenComparingInt(c -> c.y));

        // Verificar si faltan exactamente dos coordenadas
        if (faltantes.size() == 2) {
            return faltantes;
        } else if (faltantes.size() > 2) {
            // Si hay más de dos, devolver las primeras dos en orden
            return faltantes.subList(0, 2);
        } else {
            return faltantes;
        }
    }

    public Set<Coordenada> generarPosiblesCoordenadas(Coordenada fichaNegra, List<Coordenada> fichasBlancas) {
        Set<Coordenada> posiblesCoordenadas = new LinkedHashSet<>();

        // Movimiento en contrasentido del reloj
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

        for (int i = 0; i < 8; i++) {
            int xIntermedia = fichaNegra.x + dx[i];
            int yIntermedia = fichaNegra.y + dy[i];
            int xFinal = fichaNegra.x + dx[i] * 2;
            int yFinal = fichaNegra.y + dy[i] * 2;

            Coordenada intermedia = new Coordenada(xIntermedia, yIntermedia);
            Coordenada destino = new Coordenada(xFinal, yFinal);

            // Verifica que la ficha intermedia sea blanca y que el destino esté vacío
            if (fichasBlancas.contains(intermedia) && !fichasBlancas.contains(destino)) {
                posiblesCoordenadas.add(destino);
            }
        }

        return posiblesCoordenadas;
    }
}

class Coordenada {
    int x;
    int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenada that = (Coordenada) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
