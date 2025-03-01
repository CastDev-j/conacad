// Tecnológico Nacional de México
// Instituto Tecnológico de Celaya
// E S T R U C T U R A S D E D A T O S
// PRIMERA EVALUACIÓN
// NOMBRE: ___ANDRES CASTILLO JIMENEZ_________ 21/FEB/2025
// 1. Escribe una definición del TAD (10%): Un TAD es una estructura de datos
// que define un conjunto de operaciones y estados potenciales
// que se pueden realizar sobre un conjunto de datos.
// 2. Que son los estados potenciales y las operaciones en un TAD (10%): Los
// estados potenciales son los valores que puede tener un objeto
// de un TAD y las operaciones son las acciones que se pueden realizar sobre
// esos objetos.
// 3. Los TADS son dependientes o independientes de la implementación (10%): Los
// TADs son independientes de la implementación.
// 4. Cuales son los tres pasos para el diseño y la implementación de un TAD
// (10%): Definir el TAD, diseñar el TAD y la implementación del TAD.
// 5. Cuál es el sinónimo de Signatura y Axioma en el TAD (10%): Signatura =
// Interfaz, Axioma = Invariante.

// 6. Construye un método recursivo en Java para la siguiente fórmula (20%).
// { 168 si n = 1
// g() = {
// { 1/2 * g(n-1) si n > 1 y es un numero natural

// class Ejercicio6{
// public static void main(String[] args) {
// System.out.println(metodoRecursivo(150));
// }

// public static double metodoRecursivo(int n){
// if(n == 1){
// return 168;
// }else{
// return 0.5 * metodoRecursivo(n-1);
// }
// }

// }

// Dime que imprime tu programa si n = 150.
// 2.3541814200656927E-43

// 7. Un fisiculturista que hace ejercicio en una máquina empieza con el peso
// máximo del aparato (134 kg.) y hace 6 repeticiones, cuando
// termina el set le baja el peso a 127kg. (cada nivel tiene una diferencia de 7
// kg.) y aumenta las repeticiones a 8, así continúa bajando
// peso y aumentado repeticiones hasta hacer 16 repeticiones en el último set.
// Haz un método recursivo que obtenga el total de
// kilogramos que levanto en esa máquina. (30%)

// 134X6 = 804
// 127X8 = 1016
// 120X10 = 1200
// 113X12 = 1356
// 106X14 = 1484
// 99X16 = 1584
// 804+1016+1200+1356+1484+1584 = 8444

// Ejemplo de salida.
// 8444 kg.
// public class Examen {

// static int pesoInicial = 134;
// static int repeticionesInicial = 6;
// static int limiteRepeticiones = 16;
// static int diferenciaPeso = 7;
// static int totalKg = 0;
// static int totalRepeticiones = 0;

// public static void main(String[] args) {

// System.out.println("Total de kilogramos levantados: " + totalKg(pesoInicial,
// repeticionesInicial) + "kg.");

// }

// public static int totalKg(int peso, int repeticiones) {

// System.out.println(peso + "X" + repeticiones + " = " + peso * repeticiones +
// "kg.");
// if (repeticiones == limiteRepeticiones) {
// return totalKg += peso * repeticiones;
// } else {
// totalKg += peso * repeticiones;
// return totalKg(peso - diferenciaPeso, repeticiones + 2);
// }
// }

// }

// Nota: Entrega un PDF con las respuestas del examen y súbelo en ConAcad en la
// actividad Examen Primer Parcial de la competencia 1.
