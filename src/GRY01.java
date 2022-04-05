import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class GRY01 {

    public static class Person implements Comparable<Person>{

        private final int height;
        private final int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Person o) {
            if (this.getHeight() < o.getHeight()) {
                return 1;
            } else if (this.getHeight() > o.getHeight()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    public int solution(int s, int[][] arr) {
        int answer = 0;
        int max_weight = Integer.MIN_VALUE;

        ArrayList<Person> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(new Person(arr[i][0], arr[i][1]));
        }

        Collections.sort(list);

        for (Person person : list) {
            if (person.getWeight() > max_weight) {
                answer++;
                max_weight = person.getWeight();
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        GRY01 solution = new GRY01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        pm = new int[m];
        ch = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }*/

//        int[][] sizes1 = {{0,5,2,4,1},{5,0,3,9,6},{2,3,0,6,3},{4,9,6,0,3},{1,6,3,3,0}};
//        String[] sizes1 = {"??b", "abc", "cc?"};
//        int[] sizes1 = {6,10,2};
//        int[] sizes1 = {3,30,34,5,9};
//        System.out.println(solution.solution("JEROEN"));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        System.out.println(solution.solution(n, arr));
    }
}
