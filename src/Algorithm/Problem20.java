package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem20 {
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //전체 학생 수
        StringTokenizer str = new StringTokenizer(br.readLine());
        int gameCount = Integer.parseInt(str.nextToken());
        int[] peopleA = new int[gameCount];
        int[] peopleB = new int[gameCount];

        str = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < gameCount; i++){
            peopleA[i] = Integer.valueOf(str.nextToken());
        }

        str = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < gameCount; i++){
            peopleB[i] = Integer.valueOf(str.nextToken());
        }


        for(int i = 0; i < gameCount; i++){
            if(peopleA[i] == 1){
                if(peopleB[i] == 1) bw.write("D");
                else if(peopleB[i] == 2) bw.write("B");
                else bw.write(("A"));
            }
            else if(peopleA[i] == 2){
                if(peopleB[i] == 1) bw.write("A");
                else if(peopleB[i] == 2) bw.write("D");
                else bw.write(("B"));
            }
            else{
                if(peopleB[i] == 1) bw.write("B");
                else if(peopleB[i] == 2) bw.write("A");
                else bw.write(("D"));
            }

            bw.newLine();
        }
        bw.flush();
    }
}
