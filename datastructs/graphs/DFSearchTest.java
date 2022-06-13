package graphs;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class DFSearchTest {
    @Test
    public void dfSearchUndirectedTrue() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        boolean actual = graph.dfSearch("A", "G");

        // analyze
        assertTrue(actual);
    }

    @Test
    public void dfSearchFalse() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        boolean actual = graph.dfSearch("A", "K");

        // analyze
        assertFalse(actual);
    }

    @Test
    public void dfSearchDirectedTrue() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        boolean actual = graph.dfSearch("A", "H");

        // analyze
        assertTrue(actual);
    }

    @Test
    public void dfSearchDirectedFalse() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        boolean actual = graph.dfSearch("H", "A");

        // analyze
        assertFalse(actual);
    }
}
