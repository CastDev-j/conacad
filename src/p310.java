import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class p310 {
    Scanner sc = new Scanner(System.in);
    int maxRow = 0;
    int maxColumn = 0;

    public static void main(String[] args) throws Exception {
        p310 app = new p310();
        Movement[][] board = app.readBoard();
        PersonPosition[] positions = app.readPersonPositions();

        int[] results = app.simulate(board, positions);

        for (int result : results) {
            System.out.println(result);
        }
    }

    private PersonPosition[] readPersonPositions() {
        int people = Integer.parseInt(sc.nextLine());
        PersonPosition[] positions = new PersonPosition[people];

        for (int i = 0; i < people; i++) {
            String[] parts = sc.nextLine().split(" ");
            int row = Integer.parseInt(parts[0]);
            int column = Integer.parseInt(parts[1]);
            positions[i] = new PersonPosition(row, column);
        }

        return positions;
    }

    private Movement[][] readBoard() {
        String[] parts = sc.nextLine().split(" ");
        int rows = Integer.parseInt(parts[0]);
        int columns = Integer.parseInt(parts[1]);
        Movement[][] board = new Movement[rows][columns];

        maxRow = rows;
        maxColumn = columns;

        for (int i = 0; i < rows; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < columns; j++) {
                String direction = line[j].substring(0, 1);
                int steps = Integer.parseInt(line[j].substring(1));
                board[i][j] = new Movement(direction, steps);
            }
        }

        return board;
    }

    private int[] simulate(Movement[][] board, PersonPosition[] positions) {
        int[] results = new int[positions.length];

        for (int i = 0; i < positions.length; i++) {
            PersonPosition position = positions[i];
            int row = position.getRow();
            int column = position.getColumn();
            int steps = 0;
            Set<String> visited = new HashSet<>();

            while (true) {

                String currentPos = row + "," + column;
                if (visited.contains(currentPos)) {
                    steps = -1;
                    break;
                }
                visited.add(currentPos);

                Movement movement = board[row][column];
                String direction = movement.getDirection();
                int movementSteps = movement.getSteps();

                if (direction.equals("A")) {
                    row -= movementSteps;
                } else if (direction.equals("B")) {
                    row += movementSteps;
                } else if (direction.equals("D")) {
                    column += movementSteps;
                } else if (direction.equals("I")) {
                    column -= movementSteps;
                }

                steps += movementSteps;

                steps -= Math.max(0, column - maxColumn + 1);
                steps -= Math.max(0, row - maxRow + 1);

                steps -= Math.max(0, -column);
                steps -= Math.max(0, -row);

                if (row < 0 || row >= maxRow || column < 0 || column >= maxColumn) {
                    break;
                }
            }

            results[i] = steps;
        }

        return results;
    }
}

class Movement {
    private String direction;
    private int steps;

    public Movement(String direction, int steps) {
        this.direction = direction;
        this.steps = steps;
    }

    public String getDirection() {
        return direction;
    }

    public int getSteps() {
        return steps;
    }
}

class PersonPosition {
    private int row;
    private int column;

    public PersonPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}