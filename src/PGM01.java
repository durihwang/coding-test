public class PGM01 {

    static int ch[];

    /**
     * 네트워크
     *
     * @param n
     * @param computers
     * @return
     */
    public int solution(int n, int[][] computers) {
        int answer = 0;
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                dfs(i, n, computers);
                answer++;
            }
        }

        return answer;
    }

    public int dfs(int i, int n, int[][] computers) {
        ch[i] = 1;
        for (int j = 0; j < computers.length; j++) {
            if (i != j && ch[j] == 0 && computers[i][j] == 1) {
                dfs(j, n, computers);
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        PGM01 pgm01 = new PGM01();
//        int[][] arr = new int[][]{{1,1,0}, {1,1,0}, {0,0,1}};
        int[][] arr = new int[][]{{1,1,0}, {1,1,1}, {0,1,1}};
        System.out.println(pgm01.solution(3, arr));;
    }
}
