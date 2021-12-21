import java.util.Scanner;

public class Test18 {

    /**
     * 특정문자 뒤집기
     * 문자열 중에서 특수문자면 그 자리 그대로 두고 문자인 경우만 앞뒤 위치를 바꿔준다.
     *
     * 풀이
     * while 문으로 돌려야 한다. lt와 rt변수를 이용하여서 바꿔주자.
     * lt와 rt가 모두 특수문자가 아니면 lt와 rt의 자리를 바꿔준다.
     * lt가 특수문자이면 lt를 ++ 하주고 rt가 특수문자이면 rt를 ++ 해준다.
     *
     * @param string
     * @return
     */
    public String solution(String string) {
        char[] chars = string.toCharArray();
        String answer = "";

        int lt = 0, rt = string.length() - 1;
        while (lt < rt) {

            if (!Character.isAlphabetic(chars[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(chars[rt])) {
                rt--;
            } else {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            }
        }

        String tmp = String.valueOf(chars);
        answer = tmp;

        return answer;
    }

    public static void main(String[] args) {
        Test18 main = new Test18();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        System.out.println(main.solution(input));
    }
}