import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class PGM15 {

    public String solution(String call) {
        String answer = "";
        String check = "";

        /*char[] a = call.toCharArray();
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));*/

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < call.length(); i++) {
            if (i == 0 || check.equals("")) {
                check += call.charAt(i);
            } else {
                System.out.println(check);
                System.out.println(call.substring(i, check.length() + i));

                if (check.equals(call.substring(i, check.length() + i))) {
                    hashMap.put(check, hashMap.getOrDefault(check, +2));
                    check = "";
                } else {
                    check += call.charAt(i);
                }
            }

            System.out.println();
        }

        System.out.println(hashMap);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        PGM15 solution = new PGM15();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }*/
        System.out.println(solution.solution("abcabcdefabc"));
    }
}
