package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sa1388 {
    static char[][] ground;
    static boolean[][] check;
    static int row;
    static int col;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        row = Integer.parseInt(str.nextToken());
        col = Integer.parseInt(str.nextToken());
        ground = new char[row][col];
        check = new boolean[row][col];
        for(int i = 0; i < row; i++){
            str = new StringTokenizer(br.readLine());
            String rowString = str.nextToken();
            for(int j = 0; j < col; j++){
                ground[i][j] = rowString.charAt(j);
            }
        }

        int count = 0;
        for(int i =0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(check[i][j])
                    continue;

               if(ground[i][j] == '-'){
                   CheckGoRight(i,j);
               }
               else
                   CheckGoBottom(i,j);

               count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }

    private static void CheckGoRight(int i, int j) {
        if(j == col || ground[i][j] != '-')
            return;

        check[i][j] = true;
        CheckGoRight(i, j + 1);
    }


    private static void CheckGoBottom(int i, int j) {
        if(i == row || ground[i][j] != '|')
            return;

        check[i][j] = true;
        CheckGoBottom(i + 1, j);
    }
}
