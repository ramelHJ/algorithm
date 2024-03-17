package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;

public class sa1002 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int count = Integer.valueOf(str.nextToken());

        for(int i = 0; i < count; i++){
            str = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(str.nextToken());
            int y1 = Integer.parseInt(str.nextToken());
            int r1 = Integer.parseInt(str.nextToken());
            int x2 = Integer.parseInt(str.nextToken());
            int y2 = Integer.parseInt(str.nextToken());
            int r2 = Integer.parseInt(str.nextToken());

            double distance = sqrt((x2 - x1) * (x2- x1) + (y2- y1) * (y2 - y1));
            double subtract = r1 > r2 ? r1 - r2 : r2 - r1;

            if(distance == 0 && r1 == r2) bw.write("-1");
            else if(distance < r1 + r2 && subtract < distance) bw.write("2");
            else if(distance == r1 + r2 || distance == subtract) bw.write("1");
            else bw.write("0");

            bw.newLine();
        }
        bw.flush();
    }
}
