import java.util.Scanner;

class Test05 {

    /**
     * 신규아이디 추천
     * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
     * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
     * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
     * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
     * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
     * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     *      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
     * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     *
     * 풀이
     * 일일히 코드를 짰는데 정규식으로 하면 훨씬 간편하다.
     * 정규식을 꼭 기억하자.
     * @param new_id
     * @return
     */
    public String solution(String new_id) {

        String answer = new_id
                .toLowerCase() // 소문자로 바꿔준다.
                .replaceAll("[^a-z0-9-_.]", "") // 소문자, 숫자, -, _, . 을 제외하고 제거한다.
                .replaceAll("[.]{2,}", ".") // .이 연속으로 2번 이상 나오면 .으로 치환한다.
                .replaceAll("^[.]|[.]$", ""); // .으로 시작되거나 .으로 끝나면 제거한다.

        // 다 제거하고 문자가 비었다면 a로 치환한다.
        if (answer.equals("")) {
            answer += "a";
        }

        // 문자가 16자리 이상이면 15자리까지만 남기고 제거한다.
        // 제거하고 남은 문자열 마지막이 .이면 .을 제거한다.
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        // 문자가 2자리 이하면 마지막 문자로 3자리까지 채운다.
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Test05 solution = new Test05();
        Scanner scanner = new Scanner(System.in);

        System.out.println(solution.solution("z-+.^."));
    }
}
