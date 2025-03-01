
// Se quieren obtener las distancias entre varias ciudades del mundo según la fórmula de Haversine, en donde:  

//  R = radio de la tierra aproximado (6371 km)

// Dif. de latidudes = latitud2 - latitud1

// Dif. de longitudes = longitud2 - longitud1

// a = sin2(dif. Lattitudes/2) + cos(latitud1)*cos(latitud2)*sin2(dif. Longitudes/2)

// c = 2*atan2(sqrt(a),sqrt(1-a))  

//  distancia = R * c

// La entrada contiene en un sólo renglón tripletas de datos que representan el nombre de la ciudad como cadena seguido de su latitud y longitud en formato real separadas por espacios. La salida debe mostrar la distancia entre cada par de ciudades de la lista en formato real con diez dígitos después del punto.

// Ejemplo de entrada:                                                                                                    
// Paris 53.32067 53.3186 Dinamarca 56.263 9.501785 Haiti 18.971187 -72.285115

// Ejemplo de salida:                                                                                                        
// Paris Dinamarca  2779.8631354196
// Dinamarca Haiti 7760.8828350466
import java.util.Scanner;
import java.util.stream.IntStream;

public class p513 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String inputLine = s.nextLine().trim();
        String[] datosCiudad = inputLine.split(" ");

        Ciudad[] ciudades = IntStream.range(0, datosCiudad.length / 3)
                .mapToObj(i -> new Ciudad(datosCiudad[i * 3], Double.parseDouble(datosCiudad[i * 3 + 1]), Double.parseDouble(datosCiudad[i * 3 + 2])))
                .toArray(Ciudad[]::new);

        IntStream.range(0, ciudades.length - 1)
                .mapToObj(i -> String.format("%s %s %.10f", ciudades[i].nombre, ciudades[i + 1].nombre, calcularDistancia(ciudades[i], ciudades[i + 1])))
                .forEach(System.out::println);

        s.close();
    }

    public static double calcularDistancia(Ciudad ciudad1, Ciudad ciudad2) {
        double R = 6371; // radio de la tierra en km
        double latitud1 = Math.toRadians(ciudad1.latitud);
        double longitud1 = Math.toRadians(ciudad1.longitud);
        double latitud2 = Math.toRadians(ciudad2.latitud);
        double longitud2 = Math.toRadians(ciudad2.longitud);

        double difLatitud = latitud2 - latitud1;
        double difLongitud = longitud2 - longitud1;

        double a = Math.pow(Math.sin(difLatitud / 2), 2) + Math.cos(latitud1) * Math.cos(latitud2) * Math.pow(Math.sin(difLongitud / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
}

class Ciudad {
    String nombre;
    double latitud;
    double longitud;

    public Ciudad(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
