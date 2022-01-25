package beray.leetcode.AlgorithmStudiesII.Day4;

import java.util.*;

// https://leetcode.com/problems/interval-list-intersections/
public class IntervalListIntersection {
  public int[] getIntersection(int[] fp, int[] sp) {
    if (sp[1] < fp[0] || fp[1] < sp[0] || sp[0] > fp[1] || fp[0] > sp[1]) return new int[0];
    return new int[]{Math.max(fp[0], sp[0]), Math.min(fp[1], sp[1])};
  }

  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    if (firstList.length == 0 || secondList.length == 0) return new int[0][2];
    List<int[]> sol = new ArrayList<>();
    
    int fp = 0;
    int sp = 0;

    while (fp < firstList.length && sp < secondList.length) {
      int[] intersection = getIntersection(firstList[fp], secondList[fp]);
      if (intersection.length > 0) sol.add(intersection);
      if (firstList[fp][1] < secondList[sp][1]) fp++;
      else sp++;
    }
    return sol.toArray(new int[sol.size()][2]);
  }
}
