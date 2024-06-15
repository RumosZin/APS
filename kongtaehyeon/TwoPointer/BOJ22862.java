package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        boolean[] arr = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num % 2 == 0; // 짝수인가
        }

        int result = 0;
        int start = 0;
        int end = 0;
        int count = 0; // 홀수의 개수

        while (end < n) {
            if (count < k) {
                if (!arr[end]) count++;
                end++;
                result = Math.max(end - start - count, result);
            } else if (arr[end]) {
                end++;
                result = Math.max(end - start - count, result);
            } else {
                if (!arr[start]) {
                    count--;
                }
                start++;
            }
        }
        System.out.println(result);
    }
}
