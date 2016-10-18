package problem061;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by kiran on 2/1/16.
 * 
 * The ordered set of three 4-digit numbers: 8128, 2882, 8281, has three interesting properties.

 The set is cyclic, in that the last two digits of each number is the first two digits of the next number (including the last number with the first).
 Each polygonal type: triangle (P3,127=8128), square (P4,91=8281), and pentagonal (P5,44=2882), is represented by a different number in the set.
 This is the only set of 4-digit numbers with this property.
 
 Find the sum of the only ordered set of six cyclic 4-digit numbers for which each polygonal type: triangle, square, pentagonal, hexagonal, heptagonal, and octagonal, is represented by a different number in the set.
 */
public class Problem061 {

    public enum FigurateType {
        TRIANGLE, SQAURE, PENTAGON, HEXAGON, HEPTAGON, OCTAGON
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        int candidate;

        ArrayList<Integer> triangles = new ArrayList<Integer>();
        for (int n = 0; (candidate = n * (n + 1) / 2) < 10_000; n++) {
            if (candidate > 999) triangles.add(candidate);
        }

        ArrayList<Integer> squares = new ArrayList<Integer>();
        for (int n = 0; (candidate = n * n) < 10_000; n++) {
            if (candidate > 999) squares.add(candidate);
        }

        ArrayList<Integer> pentagons = new ArrayList<Integer>();
        for (int n = 0; (candidate = n * (3 * n - 1) / 2) < 10_000; n++) {
            if (candidate > 999) pentagons.add(candidate);
        }

        ArrayList<Integer> hexagons = new ArrayList<Integer>();
        for (int n = 0; (candidate = n * (2 * n - 1)) < 10_000; n++) {
            if (candidate > 999) hexagons.add(candidate);
        }

        ArrayList<Integer> heptagons = new ArrayList<Integer>();
        for (int n = 0; (candidate = n * (5 * n - 3) / 2) < 10_000; n++) {
            if (candidate > 999) heptagons.add(candidate);
        }

        ArrayList<Integer> octagons = new ArrayList<Integer>();
        for (int n = 0; (candidate = n * (3 * n - 2)) < 10_000; n++) {
            if (candidate > 999) octagons.add(candidate);
        }

        HashMap<FigurateType, ArrayList<Integer>> figurates = new HashMap<FigurateType, ArrayList<Integer>>();

        figurates.put(FigurateType.OCTAGON, octagons);
        figurates.put(FigurateType.HEPTAGON, heptagons);
        figurates.put(FigurateType.HEXAGON, hexagons);
        figurates.put(FigurateType.PENTAGON, pentagons);
        figurates.put(FigurateType.SQAURE, squares);
        figurates.put(FigurateType.TRIANGLE, triangles);

        ArrayList<ArrayList<FigurateType>> orderings = new ArrayList<ArrayList<FigurateType>>();

        FigurateType typeOne = FigurateType.OCTAGON;
        for (FigurateType typeTwo : figurates.keySet()) {
            if (typeOne == typeTwo) continue;

            for (FigurateType typeThree : figurates.keySet()) {
                if (typeThree == typeOne || typeThree == typeTwo) continue;

                for (FigurateType typeFour : figurates.keySet()) {
                    if (typeFour == typeOne || typeFour == typeTwo || typeFour == typeThree) continue;

                    for (FigurateType typeFive : figurates.keySet()) {
                        if (typeFive == typeOne || typeFive == typeTwo || typeFive == typeThree || typeFive == typeFour) continue;

                        for (FigurateType typeSix : figurates.keySet()) {
                            if (typeSix == typeOne || typeSix == typeTwo || typeSix == typeThree || typeSix == typeFour || typeSix == typeFive) continue;

                            orderings.add(new ArrayList<FigurateType>(Arrays.asList(typeOne, typeTwo, typeThree, typeFour, typeFive, typeSix)));
                        }
                    }
                }
            }
        }

        for (ArrayList<FigurateType> ordering : orderings) {
            for (Integer octagon : figurates.get(ordering.get(0))) {

                for (Integer figTwo : figurates.get(ordering.get(1))) {
                    if (!canCycle(octagon, figTwo)) continue;

                    for (Integer figThree : figurates.get(ordering.get(2))) {
                        if (!canCycle(figTwo, figThree)) continue;

                        for (Integer figFour : figurates.get(ordering.get(3))) {
                            if (!canCycle(figThree, figFour)) continue;

                            for (Integer figFive : figurates.get(ordering.get(4))) {
                                if (!canCycle(figFour, figFive)) continue;

                                for (Integer figSix : figurates.get(ordering.get(5))) {
                                    if (!canCycle(figFive, figSix)) continue;

                                    if (canCycle(figSix, octagon)) {
                                        System.out.println(octagon + figTwo + figThree + figFour + figFive + figSix);
                                        long endTime = System.currentTimeMillis();
                                        long duration = (endTime - startTime);
                                        System.out.println("Completed in: " + duration + "ms");
                                        System.exit(0);
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public static boolean canCycle(int aabb, int bbcc) {
        return aabb % 100 == bbcc / 100;
    }
}
// Answer: 28684