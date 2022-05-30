package graphs;

import java.util.Set;
import java.util.HashSet;

public class Vertex<E> {
    private E value;
    private Set<Vertex<E>> neighbors;

    public Vertex(E value) {
        this.value = value;
        neighbors = new HashSet<>();
    }

    public E getValue() {
        return value;
    }

    public void connect(Vertex<E> neighbor) {
        neighbors.add(neighbor);
    }

    public boolean connected(Vertex<E> neighbor) {
        return neighbors.contains(neighbor);
    }

    public Set<Vertex<E>> getNeighbors() {
        return neighbors;
    }
}
