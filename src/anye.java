class Solution {
    public int lastRemaining(int n) {
        boolean izquierda = true;
        return calcular(n, izquierda);
    }

    public int calcular(int n, boolean izquierda) {
        if (n == 1) {
            return 1;
        }
        if (izquierda) {
            return 2 * calcular(n / 2, false);
            // Si eliminamos de izquierda a derecha, los elementos del 1 al n se procesarán.
            // Se eliminarán 1, luego 3, luego 5, ...
            // Los que quedan son 2, 4, 6, ...
            // Esto es básicamente 2 * (1,2,3,...) con el nuevo rango n/2.
        } else {
            // Ahora eliminamos de derecha a izquierda, lo que crea dos escenarios posibles.
            // Antes, de izquierda a derecha, no teníamos este caso porque n/2 (redondeado hacia abajo) 
            // ajustaba el rango a números pares, lo que hacía que 2 * rango diera el resultado correcto.
            // En este caso, el primer elemento siempre se elimina sin importar n, 
            // y el último número par siempre se queda fuera debido a la división entera n/2.
            
            if (n % 2 == 0) {
                // Si n es par y eliminamos de derecha a izquierda, el primer número se queda fuera.
                // Pero seguimos haciendo 2 * (rango/2), por lo que hay que restar 1 
                // para obtener el primer número correcto.
                // Relacionémoslo con la eliminación de izquierda a derecha:
                // ahí siempre omitimos el primer número porque se eliminaba de inmediato.
                // Aquí, el primero se queda fuera, así que lo ajustamos restando 1.
                return 2 * calcular(n / 2, true) - 1;
            } else {
                // Si n es impar, no hay problema.
                // Tanto el primer como el último número se eliminarán sí o sí.
                // Esto lo hace similar al caso de izquierda a derecha,
                // así que devolvemos el mismo cálculo.
                return 2 * calcular(n / 2, true);
            }
        }
    }
}
