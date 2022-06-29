import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public int removeDuplicates(int[] nums) {

        HashSet<Integer> hashSet = new LinkedHashSet<>();

        for (int s : nums) {
            hashSet.add(s);
        }

        int i = 0;
        for (int s : hashSet) {
            nums[i] = s;
            i++;
        }

        return hashSet.size();
    }

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = {-3,-1,0,0,0,3,3};
        System.out.println(solution.removeDuplicates(nums));
    }
}
