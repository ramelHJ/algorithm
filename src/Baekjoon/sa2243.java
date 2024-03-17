package Baekjoon;

import java.io.*;
import java.util.*;

public class sa2243 {
    static final int MAX = 1_000_000;
    static int N;
    static int firstLeaf;
    static int[] tree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        makeTree();

        N = Integer.valueOf(br.readLine());
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());

            if(str.nextToken().equals("1")){
                int grade = Integer.valueOf(str.nextToken());
                int index = pollCandy(1, firstLeaf, 1, grade);
                addCandy(index, -1);

                System.out.println(index);
            }
            else{
                int taste = Integer.valueOf(str.nextToken());
                int count = Integer.valueOf(str.nextToken());
                addCandy(taste, count);
            }
        }
    }

    public static int pollCandy(int left, int right, int node, int grade){
        if(left == right) return left;

        int mid = (left + right) / 2;

        if(tree[node * 2] >= grade) return pollCandy(left, mid, node * 2, grade);
        else return pollCandy(mid + 1, right, node * 2 + 1, grade - tree[node * 2]);
    }

    private static void addCandy(int grade, int count) {
        int index = grade + firstLeaf - 1;

        while(index > 0) {
            tree[index] += count;
            index /= 2;
        }
    }


    private static void makeTree() {
        firstLeaf = 1;

        while(firstLeaf<1000000) {
            firstLeaf *= 2;
        }

        tree= new int[firstLeaf * 2];
    }
}
