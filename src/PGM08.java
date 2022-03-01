import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PGM08 {

    /**
     * 문자열 압축
     *
     * @param s
     * @return
     */
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String compress = s.substring(0, i);
            StringBuilder convert = new StringBuilder();
            int count = 1;
            for (int j = i; j <= s.length(); j += i) {
                int end = Math.min(j + i, s.length());
                String next = s.substring(j, end);

                if (compress.equals(next)) {
                    count++;
                } else {
                    convert.append(count != 1 ? count : "").append(compress);
                    compress = next;
                    count = 1;
                }
            }

            convert.append(compress);
            answer = Math.min(answer, convert.length());
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        PGM08 solution = new PGM08();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        String s = "abcabcabcabcdededededede";
        String s = "aabbaccc";
        solution.solution(s);
    }
}
