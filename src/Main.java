import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public String[] solution(String[] record) {
        String[] answer = {};

        for (int i = 0; i < record.length; i++) {
            String[] users = record[i].split(" ");
            System.out.println(record[i]);
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution.solution(s);
    }
}
