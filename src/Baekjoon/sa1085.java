package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sa1085 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int coordinateX = Integer.parseInt(str.nextToken());
        int coordinateY = Integer.parseInt(str.nextToken());
        int width = Integer.parseInt(str.nextToken());
        int height = Integer.parseInt(str.nextToken());

        int minDistance = 1000;

        if(coordinateX < minDistance)
            minDistance = coordinateX;
        if(coordinateY < minDistance)
            minDistance = coordinateY;
        if(width - coordinateX < minDistance)
            minDistance = width - coordinateX;
        if(height - coordinateY < minDistance)
            minDistance = height - coordinateY;

        System.out.println(minDistance);
    }
}
