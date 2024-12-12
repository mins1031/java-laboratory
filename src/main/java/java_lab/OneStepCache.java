package java_lab;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OneStepCache {
    public static final int HIT = 1;
    public static final int MISS = 5;

    public static class Cache {
        private List<String> citiesCache;
        private int capacity;

        public Cache(int capacity) {
            this.citiesCache = new LinkedList<>();
            this.capacity = capacity;
        }

        public int put(String city) {
            String findCity = this.get(city);

            if (this.citiesCache.size() < this.capacity) {
                if (Objects.nonNull(findCity)) {
                    return cacheHit(findCity);
                }

                citiesCache.add(city);
                return MISS;
            }

            if (Objects.isNull(findCity)) {
                return cacheMiss(city);
            }

            return cacheHit(findCity);
        }

        private int cacheMiss(String city) {
            citiesCache.add(city);
            citiesCache.remove(0);

            return MISS;
        }

        private int cacheHit(String findCity) {
            citiesCache.remove(findCity);
            citiesCache.add(findCity);

            return HIT;
        }

        public String get(String city) {
            int index = 0;
            boolean isNotMatch = true;
            for (String s : citiesCache) {
                if (city.equals(s)) {
                    isNotMatch = false;
                    break;
                }

                index++;
            }

            if (isNotMatch) {
                return null;
            }

            return citiesCache.get(index);
        }
    }


    public int solution(int cacheSize, String[] cities) {
        int ans = 0;
        List<String> realCities = Arrays.stream(cities)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        Cache cache = new Cache(cacheSize);

        for (String city : realCities) {
            int put = cache.put(city);
            ans += put;
        }

        return ans;
    }

    public static void main(String[] args) {
        OneStepCache oneStepCache = new OneStepCache();
//        int cacheSize = 5;
//        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
//        int cacheSize = 2;
//        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
//        int cacheSize = 3;
//        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        int cacheSize = 3;
        String[] cities = {"a", "b", "a", "c", "d", "a"};


        int solution = oneStepCache.solution(cacheSize, cities);
        System.out.println(solution);
    }
}
