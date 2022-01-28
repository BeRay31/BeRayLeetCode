package beray.leetcode.AlgorithmStudiesII.Day8;
// https://leetcode.com/problems/all-paths-from-source-to-target/
import java.util.*;
public class SourceFromTargetAllPath {
  
  class Pair<T, S> {
    public T first;
    public S second;

    public Pair(T first, S second) {
      this.first = first;
      this.second = second;
    }
  }

  public List<List<Integer>> allPathsSourceTargetBFS(int[][] graph) {
    Queue<Pair<Integer, List<Integer>>> q = new LinkedList<>();
    List<List<Integer>> sol = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    temp.add(0);
    q.add(new Pair<Integer, List<Integer>>(0, temp));
    while (!q.isEmpty()) {
      Pair<Integer, List<Integer>> curr = q.poll();
      for (int i = 0; i < graph[curr.first].length; i++) {
        if (graph[curr.first][i] == graph.length - 1) {
          List<Integer> newTemp = new ArrayList<>();
          newTemp.addAll(curr.second);
          newTemp.add(graph.length - 1);
          sol.add(newTemp);
        } else if (curr.second.indexOf(graph[curr.first][i]) == -1) {
          List<Integer> newTemp = new ArrayList<>();
          newTemp.addAll(curr.second);
          newTemp.add(graph[curr.first][i]);
          q.add(new Pair<Integer, List<Integer>>(graph[curr.first][i], newTemp));
        }
      }
    }
    return sol;
  }

  public void dfsHelper(int[][] graph, List<Integer> temp, int node, List<List<Integer>> sol) {
    if (node == graph.length - 1) {
      List<Integer> newTemp = new ArrayList<>();
      newTemp.addAll(temp);
      sol.add(newTemp);
      return;
    }
    for (int i = 0; i < graph[node].length; i++) {
      if (temp.indexOf(graph[node][i]) == -1) {
        temp.add(graph[node][i]);
        dfsHelper(graph, temp, graph[node][i], sol);
        temp.remove(temp.size() - 1);
      }
    }
  }
  // DEFINITELY FASTER
  public List<List<Integer>> allPathsSourceTargetDFS(int[][] graph) {
    List<List<Integer>> sol = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    temp.add(0);
    dfsHelper(graph, temp, 0, sol);
    return sol;
  }
}
