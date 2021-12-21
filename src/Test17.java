import java.util.Scanner;

public class Test17 {

    /**
     * 중복문자제거
     * 문자열 중에 중복되는 문자가 있으면 제거하고 출력한다.
     *
     * 풀이
     * string의 indexof(왼쪽부터 해당하는 문자가 나오는 자릿수)를 이용하여
     * for문을 돌리면서 i의 위치와 i의 위치하는 문자의 indexof가 같은 경우만 answer 배열에 넣어준다.
     * @param strings
     * @return
     */
    public String solution(String strings) {
        String answer = "";

        for (int i = 0; i < strings.length(); i++) {
            if (strings.indexOf(strings.charAt(i)) == i) {
                answer += strings.charAt(i);
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        System.out.println(main.solution(str));
    }
}