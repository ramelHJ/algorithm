package Programers;

class 조이스틱 {
    public int solution(String name) {
        int change = 0;
        int move = name.length() - 1;

        for(int i = 0; i < name.length(); i++){
            //영어 순서만큼 더하기
            change += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            //이동수 구하기
            int index = i + 1;
            while(index < name.length() && name.charAt(index) == 'A'){
                index++;
            }

            //오른쪽만큼 갔다가 돌아가는 것
            move = Math.min(move, i * 2 + name.length() - index);
            //왼쪽만큼 갔다가 돌아가는 것
            move = Math.min(move, (name.length() - index) * 2 + i);
        }

        return change + move;
    }
}

