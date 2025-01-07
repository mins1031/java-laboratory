package java_cote.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SurveillanceCamera {
    private static class CameraPoint implements Comparable<CameraPoint>{
        public int inPoint;
        public int outPoint;

        public CameraPoint(int inPoint, int outPoint) {
            this.inPoint = inPoint;
            this.outPoint = outPoint;
        }

        public int getOutPoint() {
            return outPoint;
        }

        @Override
        public int compareTo(CameraPoint o) {
            return this.outPoint - o.outPoint;
        }
    }

    public int solution(int[][] routes) {
        int result = 0;
        List<CameraPoint> cameraPoints = Arrays.stream(routes)
                .map(route -> new CameraPoint(route[0], route[1]))
                .collect(Collectors.toList());
//        cameraPoints.sort(Comparator.comparing(CameraPoint::getOutPoint));

        Collections.sort(cameraPoints);

        int current = cameraPoints.get(0).getOutPoint();
        for (CameraPoint cameraPoint : cameraPoints) {
            if (cameraPoint.inPoint <= current
                    && cameraPoint.outPoint >= current) {
                continue;
            }

            result++;
            current = cameraPoint.outPoint;
        }
        result++;

        return result;
    }

    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        SurveillanceCamera surveillanceCamera = new SurveillanceCamera();
        int solution = surveillanceCamera.solution(routes);
        System.out.println(solution);
    }
}
