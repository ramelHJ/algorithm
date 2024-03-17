package Programers;

public class Test1 {
    static final char BALCK = '#';
    static final char WHITE = '.';

    public int solution(int low, int high, String[] img) {
        int answer = 0;

        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[i].length(); j++){
                if(img[i].charAt(j) == BALCK){
                    //findSquare
                    int min = Math.min(img.length - i, img[i].length() - j);
                    for(int x = 2; x < min; x++){
                        if(checkSquare(img, i, j, i + x, j + x)){
                            if(checkEquation(img, i, j, i + x, j + x, low, high))
                            answer++;
                        }
                    }
                }
            }
        }

        return answer;
    }

    private boolean checkEquation(String[] img, int startX, int startY, int endX, int endY, int low, int high) {
        int below = (endX - startX - 1) * (endX - startX - 1);
        int blackNum = 0;
        for(int i = startX + 1; i < endX; i++){
            for(int j = startY + 1; j < endY; j++){
                if(img[i].charAt(j) == BALCK)
                    blackNum++;
            }
        }

        double value = (double)blackNum / below * 100;
        if(value >= low && value < high)
            return true;
        return false;
    }

    private boolean checkSquare(String[] img, int startX, int startY, int endX, int endY) {
        for(int i = startX; i <= endX; i++){
            if(img[i].charAt(endY) == WHITE)
                return false;

            if(img[i].charAt(startY) == WHITE)
                return false;
        }

        for(int i = startY; i <= endY; i++){
            if(img[startX].charAt(i) == WHITE)
                return false;

            if(img[endX].charAt(i) == WHITE)
                return false;
        }

        return true;
    }

}
