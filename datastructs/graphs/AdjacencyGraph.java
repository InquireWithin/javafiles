package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AdjacencyGraph<E> implements Graph<E> {

    private Map<E, Vertex<E>> vertices;
    
    public AdjacencyGraph() {
        vertices = new HashMap<>();
    }

    @Override
    public void add(E value) {
        Vertex<E> vertex = new Vertex<>(value);
        vertices.put(value, vertex);

    }

    @Override
    public boolean contains(E value) {
        return vertices.containsKey(value);
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public void connectDirected(E a, E b) {
        Vertex<E> vertexA = vertices.get(a);
        Vertex<E> vertexB = vertices.get(b);
        vertexA.connect(vertexB);
    }

    @Override
    public void connectUndirected(E a, E b) {
        Vertex<E> vertexA = vertices.get(a);
        Vertex<E> vertexB = vertices.get(b);
        vertexA.connect(vertexB);
        vertexB.connect(vertexA);
    }

    @Override
    public boolean connected(E a, E b) {
        Vertex<E> vertexA = vertices.get(a);
        Vertex<E> vertexB = vertices.get(b);
        return vertexA.connected(vertexB);
    }

    @Override
    public boolean bfSearch(E start, E end) {
        Vertex<E> s = vertices.get(start);
        Vertex<E> e = vertices.get(end);

        Queue<Vertex<E>> queue = new LinkedList<>();
        Set<Vertex<E>> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        while(!queue.isEmpty()) {
            Vertex<E> v = queue.poll();
            if(v == e) {
                return true;
            } else {
                for(Vertex<E> n : v.getNeighbors()) {
                    if(!visited.contains(n)) {
                        visited.add(n);
                        queue.add(n);
                    }
                }
            }
        }

        return false;
    }

    @Override
    public List<E> bfPath(E start, E end) {
        Vertex<E> s = vertices.get(start);
        Vertex<E> e = vertices.get(end);

        Queue<Vertex<E>> queue = new LinkedList<>();
        Map<Vertex<E>, Vertex<E>> predecessors = new HashMap<>();

        queue.add(s);
        predecessors.put(s, null);

        while(!queue.isEmpty()) {
            Vertex<E> v = queue.poll();
            if(v == e) {
                break;
            } else {
                for(Vertex<E> n : v.getNeighbors()) {
                    if(!predecessors.containsKey(n)) {
                        predecessors.put(n, v);
                        queue.add(n);
                    }
                }
            }
        }

        return makePath(predecessors, e);
    }

    private List<E> makePath(Map<Vertex<E>, Vertex<E>> predecessors,
        Vertex<E> end) {
            if(predecessors.containsKey(end)) {
                List<E> path = new LinkedList<>();
                Vertex<E> current = end;
                while(current != null) {
                    path.add(0, current.getValue());
                    current = predecessors.get(current);
                }
                return path;
            } else {
                return null;
            }
    }
}
