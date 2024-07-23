package java_cote.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LifeBoat {
    //결국 제한무게를 통해 몇명이 탈출할수 있는지 계산해야함,
    //무게를 가벼운 순으로 정렬한다음 뒤부터 루프도는 이중포문으로 구성하는 방향밖에 생각이 안남 제일 처음값을 기준으로 뒤부터 루프돌며 처음값 + 루프값 < 제한무게 인지 확인후 true면 처음값, 루프값 체크 및 구명보트 갯수 ++, false면 처음값 체크 및 구명보트 개수 ++
    //아니면 무게를 무거운 순으로 정렬후 제한무게 - 선택무게 의 값보다 작은 값을 루프중에서 찾아서 처리 -> 근데 이게 최선의 방법인가?
    public int solution(int[] people, int limit) {
        int boatCount = 0;

        List<Integer> sortedPersons = new ArrayList<>();
        for (int person : people) {
            sortedPersons.add(person);
        }

        Collections.sort(sortedPersons);

        Integer smallestWeight = sortedPersons.get(0);
        int limitIndex = 0;
        for (int i = 1; i < sortedPersons.size(); i++) {
            if ((smallestWeight + sortedPersons.get(i)) > limit) {
                limitIndex = i;
                boatCount += sortedPersons.size() - i;
                break;
            }
        }

        int restCount = (sortedPersons.size() - limitIndex) / 2;

        boatCount += restCount;

        return boatCount;
    }

    public static void main(String[] args) {
        LifeBoat lifeBoat = new LifeBoat();
        int[] peoples = {70, 80, 50};
        int limit = 100;

        int solution = lifeBoat.solution(peoples, limit);
        System.out.println(solution);
    }
}
