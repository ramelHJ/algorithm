package Algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem14 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> result = new ArrayList<Integer>();
        StringTokenizer str = new StringTokenizer(br.readLine());
        int numCount = Integer.valueOf(str.nextToken());
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < numCount; i++){
            int selectNum = Integer.valueOf(str.nextToken());
            int reverseNum = reverse(selectNum);
            if(isPrime(reverseNum))
                result.add(reverseNum);
        }
        String output = result.toString().replace("[","").replace("]","").replace(",", "");
        bw.write(String.valueOf(output));
        bw.newLine();
        bw.flush();
    }

    private static boolean isPrime(int reverseNum) {

        for(int i = 2; i * i <= reverseNum; i++){
            if(reverseNum % i == 0)
                return false;
        }

        return true;
    }

    private static int reverse(int selectNum) {
        int result = 0;
        while(true){
            if(selectNum == 0) break;

            int num = selectNum % 10;
            result *= 10;
            result += num;
            selectNum /= 10;
        }

        return result;
    }

}
