package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AdjacencyGraph<E> implements Graph<E> {
    private class Vertex {
        private E value;
        private Set<Vertex> neighbors;
    
        public Vertex(E value) {
            this.value = value;
            neighbors = new HashSet<>();
        }
    
        public E getValue() {
            return value;
        }
    
        public void connect(Vertex neighbor) {
            neighbors.add(neighbor);
        }
    
        public boolean connected(Vertex neighbor) {
            return neighbors.contains(neighbor);
        }
    }
    private Map<E, Vertex> vertices;
    
    public AdjacencyGraph() {
        vertices = new HashMap<>();
    }
    
    @Override
    public void add(E value) {
        Vertex vertex = new Vertex(value);
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
        Vertex vertexA = vertices.get(a);
        Vertex vertexB = vertices.get(b);
        vertexA.connect(vertexB);
    }

    @Override
    public void connectUndirected(E a, E b) {
        Vertex vertexA = vertices.get(a);
        Vertex vertexB = vertices.get(b);
        vertexA.connect(vertexB);
        vertexB.connect(vertexA);
    }

    @Override
    public boolean connected(E a, E b) {
        Vertex vertexA = vertices.get(a);
        Vertex vertexB = vertices.get(b);
        return vertexA.connected(vertexB);
    }

    @Override
    public boolean bfSearch(E start, E end) {
        Vertex s = vertices.get(start);
        Vertex e = vertices.get(end);

        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            if(v == e) {
                return true;
            } else {
                for(Vertex n : v.neighbors) {
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
        Vertex s = vertices.get(start);
        Vertex e = vertices.get(end);

        Queue<Vertex> queue = new LinkedList<>();
        Map<Vertex, Vertex> predecessors = new HashMap<>();

        queue.add(s);
        predecessors.put(s, null);

        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            if(v == e) {
                break;
            } else {
                for(Vertex n : v.neighbors) {
                    if(!predecessors.containsKey(n)) {
                        predecessors.put(n, v);
                        queue.add(n);
                    }
                }
            }
        }

        return makePath(predecessors, e);
    }

    private List<E> makePath(Map<Vertex, Vertex> predecessors,
        Vertex end) {
            if(predecessors.containsKey(end)) {
                List<E> path = new LinkedList<>();
                Vertex current = end;
                while(current != null) {
                    path.add(0, current.getValue());
                    current = predecessors.get(current);
                }
                return path;
            } else {
                return null;
            }
    }

    @Override
    public boolean dfSearch(E start, E end) {
        Vertex s = vertices.get(start);
        Vertex e = vertices.get(end);

        Set<Vertex> visited = new HashSet<>();
        visited.add(s);

        visitDFS(s, visited);

        return visited.contains(e);
    }

    @Override
    public List<E> dfPath(E start, E end) {
        Vertex s = vertices.get(start);
        Vertex e = vertices.get(end);

        Set<Vertex> visited = new HashSet<>();
        visited.add(s);

        return visitDFPath(s, e, visited);
    }

    private void visitDFS(Vertex vertex, Set<Vertex> visited) {
        for(Vertex neighbor : vertex.neighbors) {
            if(!visited.contains(neighbor)) {
                visited.add(neighbor);
                visitDFS(neighbor, visited);
            }
        }
    }

    private List<E> visitDFPath(Vertex v, Vertex e, 
        Set<Vertex> visited) {
        if(v == e) {
            List<E> path = new LinkedList<>();
            path.add(e.getValue());
            return path;
        } else {
            for(Vertex neighbor : v.neighbors) {
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    List<E> path = visitDFPath(neighbor, e, visited);
                    if(path != null) {
                        path.add(0, v.getValue());
                        return path;
                    }
                }
            }
            return null;
        }
    }
}
