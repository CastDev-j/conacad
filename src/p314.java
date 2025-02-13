// Suetonio, escritor romano que vivió en el inicio de la era cristiana (69 D.C.),
// escribió la biografía de los emperadores romanos incluido Julio César Domiciano.
// Cuenta que Julio César usaba en su correspondencia particular un código de
// sustitución muy simple en el cuál cada letra del mensaje original era sustituida
// por la letra que la seguía en tres posiciones en el alfabeto, por ejemplo la letra
// A era sustituida por D, la B por E, y así hasta la última letra, que era cifrada
// con la primera. Ver figura 1.

// A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
// D E F G H I J K L M N O P Q R S T U V W X Y Z A B C
// Figura 1. Tabla de cifrado de Julio César Domiciano.

// Hoy día, sin embargo, se denomina “código de César” a cualquier cifra en la cual
// cada letra del mensaje original sea sustituida por otra desplazándola un número
// fijo de posiciones, no necesariamente tres. Un ejemplo es el código que, aún
// según Suetonio, era usado por Augusto, donde la letra A era sustituida por B,
// la B por C y así sucesivamente. Como el alfabeto romano posee 26 letras, son
// posibles 26 códigos de César, de los cuáles el del desplazamiento cero no altera
// el mensaje original.
// Usando el código César actual convierte el contenido de un archivo en palabras
// entendibles haciendo la sustitución de cada letra del alfabeto por otra letra,
// sabiendo que el orden de las letras se ha recorrido hacia la izquierda o la derecha
// un número fijo de posiciones. La regla para saber cuándo se ha encontrado una
// solución factible, es que en la traducción no se permiten consonantes juntas en
// una sola palabra. El alfabeto no contiene “doble ele” o “eñe” (ll o ñ) y sólo usa
// minúsculas.

// Entrada
// El archivo de entrada contiene una línea de palabras para su conversión.
// Salida
// La salida a pantalla debe contener todas las posibles traducciones del párrafo original separada cada traducción por un cambio de línea.

// Ejemplo de entrada
// ibz ubnbmft pbybdb

// Ejemplo de salida
// lec xeqepiw sebege
// hay tamales oaxaca

import java.util.Scanner;

public class p314 {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        p314 app = new p314();
        String[] words = app.readWords();

        String[] translations = app.translateWords(words);

        for (String translation : translations) {
            if (translation != null) {
                System.out.println(translation);
            }
        }

    }

    private String[] readWords() {
        String line = sc.nextLine();
        return line.split(" ");
    }

    private String[] translateWords(String[] words) {
        String[] translations = new String[26];
        for (int i = 0; i < 26; i++) {
            String word = translateWord(words, i);
            if (isInvalidTranslation(word)) {
                continue;
            }
            translations[i] = word;
        }
        return translations;
    }

    private boolean isInvalidTranslation(String word) {
        String consonants = "bcdfghjklmnpqrstvwxyz";

        for (int i = 0; i < word.length() - 1; i++) {
            char current = word.charAt(i);
            char next = word.charAt(i + 1);
            if (consonants.contains(String.valueOf(current)) && consonants.contains(String.valueOf(next))) {
                return true;
            }

        }

        return false;
    }

    private String translateWord(String[] words, int shift) {
        StringBuilder translation = new StringBuilder();
        for (String word : words) {
            translation.append(translateWord(word, shift)).append(" ");
        }
        return translation.toString().trim();
    }

    private String translateWord(String word, int shift) {
        StringBuilder translation = new StringBuilder();
        for (char letter : word.toCharArray()) {
            translation.append(translateLetter(letter, shift));
        }
        return translation.toString();
    }

    private char translateLetter(char letter, int shift) {
        // 'a' = 97, 'z' = 122
        // position es la posición de la letra en el alfabeto, se resta 'a' para obtener
        // un número entre 0 y 25
        int position = letter - 'a';
        // newPosition es la nueva posición de la letra en el alfabeto, se suma 'a' para
        // obtener la letra correspondiente
        int newPosition = (position + shift) % 26;
        return (char) ('a' + newPosition);
    }

}

// List of common data structures in Java

// Arrays
// int[] array = new int[10];

// ArrayList
// ArrayList<Integer> arrayList = new ArrayList<>();

// LinkedList
// LinkedList<Integer> linkedList = new LinkedList<>();

// Stack
// Stack<Integer> stack = new Stack<>();

// Queue
// Queue<Integer> queue = new LinkedList<>();

// PriorityQueue
// PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

// HashSet
// HashSet<Integer> hashSet = new HashSet<>();

// LinkedHashSet
// LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

// TreeSet
// TreeSet<Integer> treeSet = new TreeSet<>();

// HashMap
// HashMap<Integer, String> hashMap = new HashMap<>();

// LinkedHashMap
// LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

// TreeMap
// TreeMap<Integer, String> treeMap = new TreeMap<>();

// Hashtable
// Hashtable<Integer, String> hashtable = new Hashtable<>();

// EnumSet
// EnumSet<Day> enumSet = EnumSet.allOf(Day.class);

// EnumMap
// EnumMap<Day, String> enumMap = new EnumMap<>(Day.class);

// BitSet
// BitSet bitSet = new BitSet();
