import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class PGM03 {

    /**
     * 신고 결과 받기
     *
     * @param id_list
     * @param report
     * @param k
     * @return
     */
    public int[] solution(String[] id_list, String[] report, int k) {

        // 같은 사람이 신고한건 1회로 치므로 중복을 제거해준다.
        report = Arrays.stream(report).distinct().toArray(String[]::new);

        int[] answer;
        // LinkedHashMap은 순서를 보장해준다.
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            result.put(id_list[i], 0);
        }

        // 신고당한 사람과 신고한 사람의 list를 저장한 변수
        LinkedHashMap<String, ArrayList<String>> all = new LinkedHashMap<>();

        // 파라미터로 넘어온 report를 돌리면서 신고한 사람과 신고당한 사람을 찾는다.
        for (String s : report) {
            String[] strings = s.split(" ");
            ArrayList<String> temp;
            // 기존에 신고한 사람과 신고당한 사람이 있으면 거기에 신고한 사람만 추가해준다.
            if (all.containsKey(strings[1])) {
                all.get(strings[1]).add(strings[0]);
            } else {
                // 없으면 새로 만들어서 넣어준다.
                temp = new ArrayList<>();
                temp.add(strings[0]);
                all.put(strings[1], temp);
            }
        }

        // 신고당한 사람, 신고한 사람 변수를 돌면서 k이상인 것들을 다시 result로 넣어준다.
        for (String key : all.keySet()) {
            if (all.get(key).size() >= k) {
                for (String i : all.get(key)) {
                    result.put(i, result.getOrDefault(i, 0) + 1);
                }
            }
        }

        // HashMap to int[]
        answer = result.values().stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }


    public static void main(String[] args) throws IOException {
        PGM03 solution = new PGM03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//        String[] id_list = {"con", "ryan"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;
        solution.solution(id_list, report, k);
    }
}
