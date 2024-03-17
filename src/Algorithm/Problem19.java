package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem19 {
    public static void Problem() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //전체 학생 수
        StringTokenizer str = new StringTokenizer(br.readLine());
        int studentCount = Integer.parseInt(str.nextToken());

        //매 학생의 키
        str = new StringTokenizer(br.readLine());
        int[] height = new int[studentCount];
        for(int i =  0 ; i < studentCount; i++){
            height[i] = Integer.valueOf(str.nextToken());
        }

        int result = 0;
        int max = height[studentCount - 1];
        for(int i = studentCount - 2; i >=0; i--){
            if(max < height[i]){
                max = height[i];
                result++;
            }
        }

        bw.write(String.valueOf(result));
        bw.newLine();
        bw.flush();
    }
}
