import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class PGM06 {

    /**
     * [1차] 비밀지도
     *
     * @param n
     * @param arr1
     * @param arr2
     * @return
     */
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String arr1_s[] = new String[arr1.length];
        String arr2_s[] = new String[arr2.length];

        // arr1, arr2 이진수로 변환
        // n만큼의 길이로 이진수의 길이를 맞춰준다.
        for (int i = 0; i < arr1.length; i++) {
            arr1_s[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i])));
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2_s[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr2[i])));
        }

        // n만큼 돌면서 비밀지도를 완성한다.
        for (int i = 0; i < n; i++) {
            char[] chars1 = arr1_s[i].toCharArray();
            char[] chars2 = arr2_s[i].toCharArray();
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < n; j++) {

                // 둘중에 하나라도 벽이면 벽
                if (chars1[j] == '1' || chars2[j] == '1') {
                    temp.append("#");
                // 둘 다 공백이면 공백
                } else if (chars1[j] == '0' && chars2[j] == '0') {
                    temp.append(" ");
                }
            }
            answer[i] = temp.toString();
        }

        /*for (String s : answer) {
            System.out.println("s = " + s);
        }*/

        return answer;
    }


    public static void main(String[] args) throws IOException {
        PGM06 solution = new PGM06();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int n = 5;
//        int arr1[] = {9, 20, 28, 18, 11};
//        int arr2[] = {30, 1, 21, 17, 28};
        int n = 6;
        int arr1[] = {46, 33, 33 ,22, 31, 50};
        int arr2[] = {27 ,56, 19, 14, 14, 10};
        solution.solution(n, arr1, arr2);
    }
}
