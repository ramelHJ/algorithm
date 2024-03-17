package Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem39 {

    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int firstSize = Integer.valueOf(str.nextToken());
        int[] firstArray = new int[firstSize];

        str = new StringTokenizer(br.readLine());
        for(int i =0 ; i < firstSize; i++){
            firstArray[i] = Integer.valueOf(str.nextToken());
        }

        str = new StringTokenizer(br.readLine());
        int secondSize = Integer.valueOf(str.nextToken());
        int[] secondArray = new int[secondSize];

        str = new StringTokenizer(br.readLine());
        for(int i =0 ; i < secondSize; i++){
            secondArray[i] = Integer.valueOf(str.nextToken());
        }

        int sumArraySize = firstSize + secondSize;
        int[] sumArray = new int[sumArraySize];
        int j = 0;
        for(int i = 0; i < firstSize; i++){
            sumArray[j] = firstArray[i];
            j++;
        }

        //두번째 배열 넣으면서 정렬하기
        for(int i =0; i < secondSize; i++){
            sumArray[j] = secondArray[i];

            for(int k = j; k > 0; k--){
                if(sumArray[k] >= sumArray[k - 1])
                    break;

                int tmp = sumArray[k];
                sumArray[k] = sumArray[k-1];
                sumArray[k-1] = tmp;
            }
            j++;
        }

        String result = Arrays.toString(sumArray).replace("[","").replace("]","").replace(",","");
        bw.write(result);
        bw.flush();

    }
}
