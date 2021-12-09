import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Test10 {

    /**
     * 아나그램 문제
     * 두 문자열의 문자가 순서는 다르지만 똑같은지 확인하는 문제
     *
     * 풀이
     * 첫번째 문자열을 먼저 map에 담아준다.
     * 두번째 문자열을 돌리면서 기존에 담았던 map에 키가 없거나, value가 0이 되는 순간 NO를 리턴한다.
     * 그게 아니라면 value를 감소시켜준다.
     *
     * @param n
     * @param s
     * @return
     */
    public String solution(String n, String s) {

        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : n.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : s.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            } else {
                map.put(x, map.get(x) - 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Test10 solution = new Test10();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int n = Integer.parseInt(br.readLine());
        String n = br.readLine();
        String s = br.readLine();
        /*int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }*/

        System.out.println(solution.solution(n, s));
    }
}
