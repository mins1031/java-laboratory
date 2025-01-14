package java_cote.programmers.level3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BestAlbum {
    private static class AlbumGenre {
        private int totalPlay;
        private Map<Integer, List<Integer>> songIdsMappedPlay;

        public AlbumGenre() {
            this.totalPlay = 0;
            this.songIdsMappedPlay = new TreeMap<>();
        }

        public void updateAlbum(Integer songId, Integer play) {
            this.totalPlay += play;
            List<Integer> orDefault = songIdsMappedPlay.getOrDefault(play, new ArrayList<>());
            orDefault.add(songId);
        }

        public void sortThisPlayIds() {
            for (Map.Entry<Integer, List<Integer>> integerListEntry : songIdsMappedPlay.entrySet()) {
                Collections.sort(integerListEntry.getValue());
            }
        }

        public int getTotalPlay() {
            return totalPlay;
        }

        public List<Integer> getIdsByPlays() {
            List<Integer> objects = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> integerListEntry : songIdsMappedPlay.entrySet()) {
                objects.addAll(integerListEntry.getValue());
            }

            return objects;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, AlbumGenre> genreMap = new TreeMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], new AlbumGenre());
        }

        for (int i = 0; i < genres.length; i++) {
            AlbumGenre albumGenre = genreMap.get(genres[i]);
            albumGenre.updateAlbum(i, plays[i]);
        }

        List<Integer> results = new ArrayList<>();
        for (Map.Entry<String, AlbumGenre> stringAlbumGenreEntry : genreMap.entrySet()) {
            AlbumGenre value = stringAlbumGenreEntry.getValue();
            value.sortThisPlayIds();
            value.getSongIdsMappedPlay().values()
                    .forEach(id -> results.add(id));
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        String[] genres2 = {"classic", "pop", "pop", "tt"};
        int[] plays2 = {700, 500, 500, 200};

        BestAlbum bestAlbum = new BestAlbum();
//        int[] solution = bestAlbum.solution(genres, plays);
        int[] solution = bestAlbum.solution(genres2, plays2);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
