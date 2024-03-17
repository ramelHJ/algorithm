package Algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Problem47 {

    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(str.nextToken());

        int[][] height = new int[num+2][num+2];

        for(int i = 1; i <= num; i++){
            str = new StringTokenizer(br.readLine());
            for(int j =1; j <= num; j++){
                height[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        int maxCount = 0;
        for(int i =1; i <= num; i++){
            for(int j = 1; j <= num; j++){
                boolean isMax = true;

                for(int k = 0; k < 4; k++){
                    int xx = i + dx[k];
                    int yy = j + dy[k];
                    if(height[i][j] < height[xx][yy])
                        isMax = false;
                }

                if(isMax)
                    maxCount++;
            }
        }
        bw.write(String.valueOf(maxCount));
        bw.flush();
    }
}
