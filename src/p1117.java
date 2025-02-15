// beecrowd | 1117
// Score Validation
// Adapted by Neilor Tonin, URI  Brazil

// Timelimit: 1
// Write a program that reads two scores of a student. Calculate and print the average of these scores. Your program must accept just valid scores [0..10]. Each score must be validated separately.

// Input
// The input file contains many floating-point numbers​​, positive or negative. The program execution will be finished after the input of two valid scores.

// Output
// When an invalid score is read, you should print the message "nota invalida".
// After the input of two valid scores, the message "media = " must be printed followed by the average of the student. The average must be printed with 2 numbers after the decimal point.

import java.io.IOException;
import java.util.Scanner;

public class p1117 {
    public Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
            
            p1117 m = new p1117();
            m.testCases();


    }

    public void testCases() {
        double score1 = 0;
        double score2 = 0;
        int count = 0;
        while (count < 2) {
            double score = sc.nextDouble();
            if (score < 0 || score > 10) {
                System.out.println("nota invalida");
            } else {
                if (count == 0) {
                    score1 = score;
                } else {
                    score2 = score;
                }
                count++;
            }
        }
        System.out.printf("media = %.2f\n", (score1 + score2) / 2);
    }
}
