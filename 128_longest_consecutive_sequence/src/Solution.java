import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println("hello");

        int[] input = new int[]{100, 4, 200, 1, 3, 2};

        Map<Integer, Integer> graph = buildGraph(input);

        int longestPath = calculateLongestPath(graph);
        System.out.println(longestPath);
    }

    private static int calculateLongestPath(Map<Integer, Integer> graph) {
        int maxLength = 0;
        Map<Integer, Integer> pathLengths = new HashMap<>();

        for (int startNode : graph.keySet()) {
            if (pathLengths.containsKey(startNode)) {
                continue;
            }
            int pathLength = calculatePath(graph, pathLengths, startNode);
            maxLength = Integer.max(maxLength, pathLength);
        }

        return maxLength;
    }

    private static int calculatePath(Map<Integer, Integer> graph, Map<Integer, Integer> pathLengths, int startNode) {
        int length = 0;

        Integer currentNode = startNode;
        while (currentNode != null) {
            if (pathLengths.containsKey(currentNode)) {
                length += pathLengths.get(currentNode);
                break;
            }
            currentNode = graph.get(currentNode);
            if (currentNode != null) {
                length++;
            }
        }

        int node = startNode;
        for (int currentLength = length; currentLength >= 0; currentLength--) {
            pathLengths.put(node, currentLength);
            node++;
        }

        return length;
    }

    private static Map<Integer, Integer> buildGraph(int[] nodes) {
        Map<Integer, Integer> graph = new HashMap<>(nodes.length);

        for (int current : nodes) {
            int parent = current - 1;
            int child = current + 1;

            if (graph.containsKey(parent)) {
                graph.put(parent, current);
            }
            if (graph.containsKey(child)) {
                graph.put(current, child);
            } else {
                graph.put(current, null);
            }
        }

        return graph;
    }

}