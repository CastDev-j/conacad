import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class p329 {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        p329 app = new p329();

        int lines = app.linesToRead();
        List<Integer> numbers = app.readNumbers(lines);
        int average = app.calculateAverage(numbers);

        System.out.println(average);
    }

    public int linesToRead() {
        int lines = Integer.parseInt(sc.nextLine());
        return lines;
    }

    public List<Integer> readNumbers(int lines) {
        List<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] parts = sc.nextLine().split(" ");
            for (String part : parts) {
                numbersList.add(Integer.parseInt(part));
            }
        }

        return numbersList;
    }

    public int calculateAverage(List<Integer> numbersList) {
        int sum = numbersList.stream().reduce(0, Integer::sum);
        double average = (double) sum / numbersList.size();
        return (int) Math.round(average);
    }
}