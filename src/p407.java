import java.util.*;

public class p407 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCases = Integer.parseInt(scanner.nextLine());
        List<Cancion> songs = new ArrayList<>();

        for (int i = 0; i < numberOfCases; i++) {
            String[] data = scanner.nextLine().split(" ");
            songs.add(new Cancion(data[0], data[1]));
        }

        String result = solveCase(songs);
        System.out.println(result);

        scanner.close();
    }

    public static String solveCase(List<Cancion> songs) {
        Queue<Cancion> queue = new LinkedList<>(songs);
        StringBuilder result = new StringBuilder();
        int targetTime = 180;

        while (!queue.isEmpty()) {
            Cancion currentSong = queue.poll();

            Cancion bestOption = queue.stream()
                .min(Comparator.comparingInt(song -> Math.abs((currentSong.getSeconds() + song.getSeconds()) - targetTime)))
                .orElse(null);

            if (bestOption != null) {
                result.append(currentSong.getName()).append(bestOption.getName()).append(",");
                queue.remove(bestOption);
            }
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}

class Cancion {
    private String name;
    private String time;

    public Cancion(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getSeconds() {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}