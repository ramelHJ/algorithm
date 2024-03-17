package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sa1012 {
    static int width;
    static int height;
    static boolean[][] check;
    static boolean[][] vegetable;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int testCount = Integer.valueOf(str.nextToken());
        for(int test_case = 0; test_case < testCount; test_case++){
            str = new StringTokenizer(br.readLine());
            width = Integer.valueOf(str.nextToken());
            height = Integer.parseInt(str.nextToken());
            int count = Integer.parseInt(str.nextToken());

            vegetable = new boolean[width][height];
            check = new boolean[width][height];
            for(int i = 0; i < count; i++){
                str = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(str.nextToken());
                int y = Integer.parseInt(str.nextToken());
                vegetable[x][y] = true;
            }

            int result = 0;
            for(int i =0 ; i < width; i++){
                for(int j = 0; j < height; j++){
                    if(vegetable[i][j] && !check[i][j]){
                        findConnectVegetable(i, j);
                        result++;
                    }
                }
            }

            bw.write(String.valueOf(result));
            bw.newLine();
        }

        bw.flush();
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    private static void findConnectVegetable(int x, int y) {
        if(!check[x][y]){
            check[x][y] = true;
            if(vegetable[x][y]){
                for(int i = 0; i < 4; i++){
                    int xx = x + dx[i];
                    int yy = y + dy[i];

                    if(xx >= 0 && xx < width && yy >=0 && yy < height)
                        findConnectVegetable(xx,yy);
                }
            }
        }
    }
}
