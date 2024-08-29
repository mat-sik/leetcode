import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Node start = buildGraph();

        var out = traverseAndDeepCopyGraph(start);
        System.out.println(out);
    }

    public static Node buildGraph() {
        // Create nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Connect neighbors according to the adjacency list [[2,4],[1,3],[2,4],[1,3]]
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Return any node as the starting node of the graph, here we return node1
        return node1;
    }

    public static Optional<Node> traverseAndDeepCopyGraph(Node startNode) {
        Map<Integer, Node> clonedNodes = new HashMap<>();

        List<Node> stack = new ArrayList<>();
        stack.add(startNode);
        Set<Integer> visited = new HashSet<>();

        Node currentNode = startNode;
        while (currentNode != null && !stack.isEmpty()) {
            currentNode = stack.removeLast();
            if (visited.contains(currentNode.val)) {
                continue;
            }
            visited.add(currentNode.val);

            Node cloneNode = clonedNodes.computeIfAbsent(currentNode.val, Node::new);

            for (Node neighbour : currentNode.neighbors) {
                stack.add(neighbour);
                Node neigbourCloneNode = clonedNodes.computeIfAbsent(neighbour.val, Node::new);
                cloneNode.neighbors.add(neigbourCloneNode);
            }
        }

        return clonedNodes.values().stream().findFirst();
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}