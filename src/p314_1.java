import java.util.Scanner;

public class p314_1 {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        p314_1 app = new p314_1();
        String[] words = app.readWords();
        int levelOfEncryption = app.readLevelOfEncryption();

        String translation = app.encryptWords(words, levelOfEncryption);

        System.out.println(translation);
    }

    private String[] readWords() {
        System.out.println("Palabras a encriptar: ");
        String line = sc.nextLine();
        return line.split(" ");
    }

    private int readLevelOfEncryption() {
        System.out.println("Nivel de encriptación: ");
        return sc.nextInt();
    }

    private String encryptWords(String[] words, int levelOfEncryption) {
        String[] encryptedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            encryptedWords[i] = encryptWord(words[i], levelOfEncryption);
        }

        return String.join(" ", encryptedWords);
    }


    private String encryptWord(String word, int levelOfEncryption) {
        StringBuilder translation = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            char newLetter = encryptLetter(letter, levelOfEncryption);
            translation.append(newLetter);
        }
        return translation.toString();
    }

    private char encryptLetter(char letter, int shift) {
        int position = letter - 'a';
        int newPosition = (26 + position - shift) % 26;
        return (char) ('a' + newPosition);
    }

}