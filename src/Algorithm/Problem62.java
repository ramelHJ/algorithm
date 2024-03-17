package Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem62 {
    static int[] tmp;
    public static void Problem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(str.nextToken());
        int[] array = new int[num];
        tmp = new int[num];
        str = new StringTokenizer(br.readLine());
        for(int i =0 ; i < num; i++){
            array[i] = Integer.valueOf(str.nextToken());
        }
        mergeSort(array, 0, num - 1);
        String result = Arrays.toString(array).replace(",", " ").replace("[","").replace("]","");
        bw.write(result);
        bw.flush();
    }

    static void mergeSort(int[] array, int left, int right){
        if(left == right) return;

        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, right);
    }

    static void merge(int[] array, int left, int right){
        int mid = (left + right) / 2;
        int leftIndex = left;
        int rightIndex = mid + 1;
        int nowIndex = left;

        //둘중에 하나를 다 넣어줄때까지 비교
        while(leftIndex <= mid && rightIndex <= right){
            if(array[leftIndex] < array[rightIndex]){
                tmp[nowIndex] = array[leftIndex];
                leftIndex++;
            }
            else{
                tmp[nowIndex] = array[rightIndex];
                rightIndex++;
            }
            nowIndex++;
        }

        //남은것은 이미 정렬이 되어 있으니 바로 넣어줌
        if(leftIndex > mid){
            for(int i = rightIndex; i <= right; i++)
            {
                tmp[nowIndex] = array[i];
                nowIndex++;
            }
        }
        else{
            for(int i = leftIndex; i <= mid; i++){
                tmp[nowIndex] = array[i];
                nowIndex++;
            }
        }

        //기존것에 정렬된것으로 변경
        for(int i = left; i <= right; i++){
            array[i] = tmp[i];
        }
    }
}
