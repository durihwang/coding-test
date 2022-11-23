public class Codilty {

    static boolean [][] skill;
    static boolean [] visit;
    static int count=0;
    //
//    static int[] T = {0, 0,1,1};
//    static int[] A = {2};
    static int[] T = {0, 0, 0, 0, 2, 3, 3};
    static int[] A = {2, 5, 6};
    public static void main(String[] args) {

        skill = new boolean[T.length + 1][T.length + 1];
        visit = new boolean[T.length + 1];

        for (int i = 0; i < T.length; i++) {
            skill[i][T[i]] = true;
            skill[T[i]][i] = true;

            for (int j = 0; j < A.length; j++) {
                getSkill(A[j]);
            }
        }
        System.out.println(count);
    }

    static void getSkill(int i) {
        if(!visit[i]) {
            visit[i] = true;
            count++;
            getSkill(T[i]);
        }
    }

}
