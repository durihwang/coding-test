import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> answer = new ArrayList<>();

        int length = matrix[0].length * matrix.length;
        int xStart = 0;
        int xEnd = matrix[0].length - 1;
        int yStart = 0;
        int yENd = matrix.length - 1;

        while (answer.size() != length) {

            // 동
            for (int i = xStart; i <= xEnd && answer.size() < length; i++) {
                answer.add(matrix[xStart][i]);
            }
            yStart++;

            // 남
            for (int i = yStart; i <= yENd && answer.size() < length; i++) {
                answer.add(matrix[i][xEnd]);
            }
            xEnd--;

            // 서
            for (int i = xEnd; i >= xStart && answer.size() < length; i--) {
                answer.add(matrix[yENd][i]);
            }
            yENd--;

            // 북
            for (int i = yENd; i >= yStart && answer.size() < length; i--) {
                answer.add(matrix[i][xStart]);
            }
            xStart++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(solution.spiralOrder(matrix));
    }
}
