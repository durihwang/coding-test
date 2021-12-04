import java.util.HashMap;
import java.util.Scanner;

class Test04 {

    /**숫자 문자열과 영단어
     * 네오와 프로도가 숫자놀이를 하고 있습니다.
     * 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
     * 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
     *
     * 1478 → "one4seveneight"
     * 234567 → "23four5six7"
     * 10203 → "1zerotwozero3"
     * 이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
     * s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
     *
     * 풀이
     * 문자열을 순회하면서 숫자이면 결과문자열에 추가해주고,
     * 문자가 나오면 check 문자열에 넣고 word에 있는지 확인하고 있으면 결과에 추가한다.
     * 그리고 check 문자열을 초기화 해준다.
     * 사실 너무 어렵게 풀었는데 그냥 0부터 9까지 for문을 돌리면서
     * 문자열에 해당하는 문자가 있으면 숫자로 replace 해주면 간단하게 끝나는 문제다.
     * 근데 만약 문자열이 애매하게 연결되어서 이상하게 replace가 될 수도 있을 거 같다는 생각이다.
     * 나처럼 앞에서부터 순서대로 체크하면 이상하게 replace가 되는 일은 없다고 생각한다.
     * @param s
     * @return
     */
    public int solution(String s) {

        HashMap<String, Integer> word = new HashMap<>();
        word.put("zero", 0);
        word.put("one", 1);
        word.put("two", 2);
        word.put("three", 3);
        word.put("four", 4);
        word.put("five", 5);
        word.put("six", 6);
        word.put("seven", 7);
        word.put("eight", 8);
        word.put("nine", 9);

        char[] chars = s.toCharArray();
        StringBuffer check = new StringBuffer();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                result.append(chars[i]);
            } else {
                check.append(chars[i]);
                if (word.containsKey(check.toString())) {
                    result.append(word.get(check.toString()));
                    check.delete(0, check.length());
                }
            }
        }
        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        Test04 solution = new Test04();
        Scanner scanner = new Scanner(System.in);

        System.out.println(solution.solution("one4seveneight"));
    }
}
