package Programers;

import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Song> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            if(map.containsKey(genres[i])){
                map.get(genres[i]).add(plays[i], i);
            }
            else{
                map.put(genres[i], new Song(plays[i], i));
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        for(int i = 0; i < keySet.size(); i++){
            Song song = map.get(keySet.get(i));
            answer.add(song.max_Index);
            if(song.max_sub > 0) answer.add(song.max_sub_Index);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public class Song implements Comparable<Song>{
        int play;
        int max;
        int max_Index;
        int max_sub;
        int max_sub_Index;
        public Song(int play, int index){
            this.play = play;
            this.max = play;
            this.max_Index = index;
            this.max_sub = 0;
            this.max_sub_Index = -1;
        }

        public void add(int play, int index){
            this.play += play;
            if(this.max < play){
                this.max_sub = max;
                this.max_sub_Index = this.max_Index;

                this.max = play;
                this.max_Index = index;
            }
            else if(this.max_sub < play){
                this.max_sub = play;
                this.max_sub_Index = index;
            }
        }

        @Override
        public int compareTo(Song o) {
            return play - o.play;
        }
    }
}
