// beecrowd | 1237
// Compare Substring
// By TopCoder*  USA

// Timelimit: 1
// Find the longest common substring between the two informed Strings. The substring can be any part of the String, including the entire String. If there is no common substring, return 0. The search is case sensitive ('x' != 'X').

// Input
// The input contains several test cases. Each test case is composed by two lines that contains a string each. Both input Strings will contain between 1 and 50, inclusive, letters (a-z, A-Z), and/or spaces.

// Output
// The length of the longest common substring between the two Strings.

// Sample Input	Sample Output
// abcdef
// cdofhij
// TWO
// FOUR
// abracadabra
// open
// Hey This java is hot
// Java is a new paradigm

// 2
// 1
// 0
// 7

// * This problem is of autorship and property of TopCoder (www.topcoder.com/tc) and adapted by Alessandro B. for authorized use in URI OJ.
// * Unauthorized reproduction of this problem statement without the prior written consent of TopCoder, Inc. is strictly prohibited.

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
            
                Main m = new Main();
                m.testCases();

    }


    public void testCases() {
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int max = 0;
            for (int i = 0; i < s1.length(); i++) {
                for (int j = 0; j < s2.length(); j++) {
                    int k = 0;
                    while (i + k < s1.length() && j + k < s2.length() && s1.charAt(i + k) == s2.charAt(j + k)) {
                        k++;
                    }
                    max = Math.max(max, k);
                }
            }
            System.out.println(max);
        }
    }

}
