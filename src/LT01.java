import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class LT01 {

    public int solution(String s) {
        int answer = 0;
        int start = 0;
        int end = 1;
        boolean check;

        while (start < s.length() || end < s.length()) {

            if (start < end) {
                if (end >= s.length()) {
                    start++;
                } else {
                    if (s.charAt(start) == 'a') {
                        if (s.charAt(end) == 'z') {
                            // 조건에 맞음. 사이에 a나 z가 있는지 확인해보자.
                            check = true;
                            for (int i = start + 1; i < end; i++) {
                                if (s.charAt(i) == 'a' || s.charAt(i) == 'z') {
                                    check = false;
                                    break;
                                }
                            }
                            if (check) {
                                answer++;
                                start++;
                                end++;
                            } else {
                                start++;
                            }
                        } else {
                            end++;
                        }
                    } else if (s.charAt(start) == 'z') {
                        if (s.charAt(end) == 'a') {
                            // 조건에 맞음. 사이에 a나 z가 있는지 확인해보자.
                            check = true;
                            for (int i = start + 1; i < end; i++) {
                                if (s.charAt(i) == 'a' || s.charAt(i) == 'z') {
                                    check = false;
                                    break;
                                }
                            }
                            if (check) {
                                answer++;
                                start++;
                                end++;
                            } else {
                                start++;
                            }
                        } else {
                            start++;
                        }
                    } else if (s.charAt(end) == 'a') {
                        if (s.charAt(start) == 'z') {
                            // 조건에 맞음. 사이에 a나 z가 있는지 확인해보자.
                            check = true;
                            for (int i = start + 1; i < end; i++) {
                                if (s.charAt(i) == 'a' || s.charAt(i) == 'z') {
                                    check = false;
                                    break;
                                }
                            }
                            if (check) {
                                answer++;
                                start++;
                                end++;
                            } else {
                                end++;
                            }
                        } else {
                            end++;
                        }
                    } else if (s.charAt(end) == 'z') {
                        if (s.charAt(start) == 'a') {
                            // 조건에 맞음. 사이에 a나 z가 있는지 확인해보자.
                            check = true;
                            for (int i = start + 1; i < end; i++) {
                                if (s.charAt(i) == 'a' || s.charAt(i) == 'z') {
                                    check = false;
                                    break;
                                }
                            }
                            if (check) {
                                answer++;
                                start++;
                                end++;
                            } else {
                                end++;
                            }
                        } else {
                            end++;
                        }
                    } else {
                        start++;
                        end++;
                    }
                }
            } else {
                end++;
            }
        }

        /*System.out.println(start);
        System.out.println(end);
        System.out.println();*/
        return answer;
    }

    public static void main(String[] args) throws IOException {

        LT01 solution = new LT01();
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Integer[][] nn = new Integer[n][2];*/


        System.out.println(solution.solution("aaazzz"));

//        br.close();
    }
}
