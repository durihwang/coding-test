import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Test09 {

    /**
     * Hashmap 문제
     * 문자열중에서 제일 많이 나온 값을 출력해준다.
     * key에 문자를 넣어주고 value에 key값만큼 증가시켜준다.
     *
     * @param n
     * @param s
     * @return
     */
    public char solution(int n, String s) {

        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : s.toCharArray()) {
            // 값을 증가시켜줄 때 값이 없는 경우를 대비해서 getOrDefault로 기본값을 넣어준다.
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        // value를 탐색할 때 keySet을 사용한다.
        for (char key : map.keySet()) {
            // value값이 가장 큰 걸로 바꿔준다.
            if (max < map.get(key)) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Test09 solution = new Test09();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        /*int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }*/

        System.out.println(solution.solution(n, s));
    }
}
