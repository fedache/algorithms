import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Davis has a number of staircases in his house and he likes to climb each staircase 1, 2, 3 or  steps at a time. Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.
 * Given the respective heights for each of the  staircases in his house, find and print the number of ways he can climb each staircase, module 10 ^ 10 + 7 on a new line.
 * For example, there is s = 1 staircase in the house that is n = 5 steps high. Davis can step on the following sequences of steps:
 * 1 1 1 1 1
 * 1 1 1 2
 * 1 1 2 1
 * 1 2 1 1
 * 2 1 1 1
 * 1 2 2
 * 2 2 1
 * 2 1 2
 * 1 1 3
 * 1 3 1
 * 3 1 1
 * 2 3
 * 3 2
 * There are  possible ways he can take these 5 steps 13 % 10000000007 = 13.
 * Function Description
 * Complete the stepPerms function in the editor below. It should recursively calculate and return the integer number of ways Davis can climb the staircase, modulo 10000000007.
 * stepPerms has the following parameter(s):
 * n: an integer, the number of stairs in the staircase
 * Input Format
 * The first line contains a single integer, s, the number of staircases in his house.
 * Each of the following  lines contains a single integer, n, the height of staircase i.
 * Constraints
 * 1 <= s <= 5
 * 1 <= n <= 36
 * <p>
 * Subtasks
 * 1 <= n <= 20 for 15% of the maximum score.
 * Output Format
 * For each staircase, return the number of ways Davis can climb it as an integer.
 */
public class DavisStaircase {

    // Complete the stepPerms function below.
    static int stepPerms(int n) {
        return stepPerms(n, new int[n]);
    }

    static int stepPerms(int n, int[] cache) {
        // Recur for all the vertices adjacent to this vertex
        if (n <= 1) return 1;
        int[] prospects = {1, 2, 3};
        int total = 0;
        for (Integer nextNum : prospects) {
            if (nextNum > n) continue;
            int reduction = n - nextNum;
            int numberOfMoves;
            if (cache[reduction] != 0) {
                numberOfMoves = cache[reduction];
            } else {
                numberOfMoves = stepPerms(reduction, cache);
                cache[reduction] = numberOfMoves;
            }
            total += numberOfMoves;
        }
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int res = stepPerms(n);
            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
