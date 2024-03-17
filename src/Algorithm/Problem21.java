package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem21 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //전체 학생 수
        int[] peopleA = new int[10];
        int[] peopleB = new int[10];

        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 10; i++){
            peopleA[i] = Integer.valueOf(str.nextToken());
        }

        str = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 10; i++){
            peopleB[i] = Integer.valueOf(str.nextToken());
        }

        int valueA = 0;
        int valueB = 0;
        String lastWin = "D";
        for(int i = 0; i < 10; i++){
            if(peopleA[i] > peopleB[i]) {
                valueA += 3;
                lastWin = "A";
            }
            else if(peopleA[i] < peopleB[i]) {
                valueB += 3;
                lastWin = "B";
            }
            else {
                valueA++;
                valueB++;
            }
        }

        if(valueA > valueB)
            bw.write("A");
        else if (valueA < valueB)
            bw.write("B");
        else
            bw.write(lastWin);

        bw.flush();
    }
}
