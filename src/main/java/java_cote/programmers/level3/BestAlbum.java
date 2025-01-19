package java_cote.programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
            songIdsMappedPlay.put(play, orDefault);
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
            List<Integer> plays = new ArrayList<>(songIdsMappedPlay.keySet());
            Collections.reverse(plays);

            List<Integer> playIds = new ArrayList<>();
            int count = 0;
            for (Integer play : plays) {
                if (count == 2) {
                    break;
                }

                List<Integer> ids = songIdsMappedPlay.get(play);
                Collections.sort(ids);
                int count2 = 0;
                for (Integer id : ids) {
                    if (count2 == 2) {
                        break;
                    }

                    playIds.add(id);
                    count2++;
                }
                count++;
            }

            return playIds;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, AlbumGenre> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], new AlbumGenre());
        }

        for (int i = 0; i < genres.length; i++) {
            AlbumGenre albumGenre = genreMap.get(genres[i]);
            albumGenre.updateAlbum(i, plays[i]);
        }

        for (Map.Entry<String, AlbumGenre> stringAlbumGenreEntry : genreMap.entrySet()) {
            AlbumGenre value = stringAlbumGenreEntry.getValue();
            value.sortThisPlayIds();
        }

        List<AlbumGenre> totalPlayList = new ArrayList<>();
        for (Map.Entry<String, AlbumGenre> stringAlbumGenreEntry : genreMap.entrySet()) {
            totalPlayList.add(stringAlbumGenreEntry.getValue());
        }

        totalPlayList.sort(Comparator.comparing(AlbumGenre::getTotalPlay).reversed());

        List<Integer> ans = new ArrayList<>();
        for (AlbumGenre albumGenre : totalPlayList) {
            ans.addAll(albumGenre.getIdsByPlays());
        }

        return ans.stream().mapToInt(d -> d).toArray();
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        String[] genres2 = {"classic", "pop", "pop", "tt", "pop", "classic"};
        int[] plays2 = {700, 500, 500, 200, 500, 700};

        BestAlbum bestAlbum = new BestAlbum();
//        int[] solution = bestAlbum.solution(genres, plays);
        int[] solution = bestAlbum.solution(genres2, plays2);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
