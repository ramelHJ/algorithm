package Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem43 {

    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int musicCount = Integer.valueOf(str.nextToken());
        int dvdCount = Integer.valueOf(str.nextToken());

        int[] musicArray = new int[musicCount];
        str = new StringTokenizer(br.readLine());

        for(int i =0; i < musicCount; i++){
            musicArray[i] = Integer.valueOf(str.nextToken());
        }

        int max = Arrays.stream(musicArray).sum();
        int min = max / dvdCount;
        int result;


        while(true){
            int middle = (max + min) / 2;
            //middle 값으로 되는지 체크
            if(CheckDVD(middle, musicArray, dvdCount)){
                int preMax = max;
                max = middle;

                if(preMax == max)
                {
                    result = max;
                    break;
                }
            }
            else
            {
                int premin = min;
                min = middle;

                if(premin == min)
                {
                    result = max;
                    break;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static boolean CheckDVD(int middle, int[] musicArray, int dvdCount) {
        int sum = 0;
        int fullDvd = 0;
        for(int i =0 ; i < Arrays.stream(musicArray).count(); i++){

            if(sum + musicArray[i] > middle){
                fullDvd++;
                sum = musicArray[i];
            }
            else{
                sum += musicArray[i];
            }

            if(fullDvd >= dvdCount)
                return false;
        }
        return true;
    }

}
