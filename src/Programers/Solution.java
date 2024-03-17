package Programers;

class Solution {
    public static String solution(String[] participant, String[] completion) {

        boolean[] check = new boolean[participant.length];
        for(int i = 0; i < completion.length; i++){
            for(int j = 0; j < participant.length; j++){
                if(participant[j] == completion[i] && !check[j]){
                    check[j] = true;
                }
            }
        }

        String answer = "";

        for(int i = 0 ; i < participant.length; i++){
            if(!check[i])
                answer = participant[i];
        }
        System.out.println(answer);
        return answer;
    }
}

