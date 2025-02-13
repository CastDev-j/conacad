import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


class p406 {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        p406 app = new p406();
        int cases = app.casesToRead();

        List<int[]> results = new ArrayList<>();

        for (int i = 0; i < cases; i++) {
            Queue<int[]> queue = app.readNumbers();
            results.add(app.simulate(queue));
        }

        for (int[] result : results) {
            System.out.println(result[0] + " " + result[1]);
        }
    }

    private int casesToRead() {
        return Integer.parseInt(sc.nextLine());
    }

    private Queue<int[]> readNumbers() {
        Queue<int[]> queue = new LinkedList<>();
        String[] parts = sc.nextLine().split(" ");
        for (int i = 0; i < parts.length; i += 2) {
            int probability = Integer.parseInt(parts[i]);
            int time = Integer.parseInt(parts[i + 1]);
            queue.add(new int[]{probability, time});
        }
        return queue;
    }

    private int[] simulate(Queue<int[]> queue) {
        int totalCost = 0;
        int totalTime = 0;

        while (!queue.isEmpty()) {
            int[] piece = queue.poll();
            int probability = piece[0];
            int time = piece[1];

            totalTime += time;
            totalCost += 50;

            if (probability < 85) {
                probability += 10;
                queue.add(new int[]{probability, time});
            }
        }

        return new int[]{totalCost, totalTime};
    }
}