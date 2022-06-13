package graphs;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class BFSearchTest {
    @Test
    public void bfSearchUndirectedTrue() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        boolean actual = graph.bfSearch("A", "G");

        // analyze
        assertTrue(actual);
    }

    @Test
    public void bfSearchFalse() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        boolean actual = graph.bfSearch("A", "K");

        // analyze
        assertFalse(actual);
    }

    @Test
    public void bfSearchDirectedTrue() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        boolean actual = graph.bfSearch("A", "H");

        // analyze
        assertTrue(actual);
    }

    @Test
    public void bfSearchDirectedFalse() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        boolean actual = graph.bfSearch("H", "A");

        // analyze
        assertFalse(actual);
    }
}
