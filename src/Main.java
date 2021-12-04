import java.util.Scanner;

class Main {

    public String solution(String new_id) {

        String answer = new_id
                .toLowerCase()
                .replaceAll("[^a-z0-9-_.]", "")
                .replaceAll("[.]{2,}", ".")
                .replaceAll("^[.]|[.]$", "");

        if (answer.equals("")) {
            answer += "a";
        }

        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

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
        // z-+.^.
        // =.=
        // ...!@BaT#*..y.abcdefghijklm
        // abcdefghijklmn.p
    }
}
