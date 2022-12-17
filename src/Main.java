import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;
    static int m;
    static int r;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int[] cal = new int[r];
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            cal[i] = Integer.parseInt(st3.nextToken());
        }

        for (int s : cal) {
            switch (s) {
                case 1:
                    a = first(a);
                    break;
                case 2:
                    a = second(a);
                    break;
                case 3:
                    a = third(a);
                    break;
                case 4:
                    a = fourth(a);
                    break;
                case 5:
                    a = fifth(a);
                    break;
                case 6:
                    a = sixth(a);
                    break;
            }
        }

        for (int[] s : a) {
            for (int w : s) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

    public static int[][] first(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = a[n - i - 1][j];
            }
        }

        return ans;
    }

    public static int[][] second(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = a[i][m - j - 1];
            }
        }

        return ans;
    }

    public static int[][] third(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = a[n - j - 1][i];
            }
        }

        return ans;
    }

    public static int[][] fourth(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = a[j][m - i - 1];
            }
        }

        return ans;
    }

    public static int[][] fifth(int[][] a) {

        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                ans[i][j] = a[i + n / 2][j];
                ans[i][j + m / 2] = a[i][j];
                ans[i + n / 2][j + m / 2] = a[i][j + m / 2];
                ans[i + n / 2][j] = a[i + n / 2][j + m / 2];
            }
        }
        return ans;
    }

    public static int[][] sixth(int[][] a) {

        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                ans[i + n / 2][j] = a[i][j];
                ans[i + n / 2][j + m / 2] = a[i + n / 2][j];
                ans[i][j + m / 2] = a[i + n / 2][j + m / 2];
                ans[i][j] = a[i][j + m / 2];
            }
        }
        return ans;
    }

}