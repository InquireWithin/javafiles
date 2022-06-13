package graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class DFPathTest {
    @Test
    public void dfPathUndirectedPath() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        List<String> path = graph.dfPath("A", "G");

        // analyze
        int size = path.size();
        assertTrue(size >= 5);
        assertEquals("A", path.get(0));
        assertEquals("G", path.get(size-1));
    }

    @Test
    public void dfPathNoPath() {
        // setup
        Graph<String> graph = Graphs.makeGraph();
        List<String> expected = null;

        // invoke
        List<String> actual = graph.dfPath("A", "K");

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void dfPathDirectedPath() {
        // setup
        Graph<String> graph = Graphs.makeGraph();

        // invoke
        List<String> path = graph.dfPath("A", "H");

        // analyze
        int size = path.size();
        assertTrue(size >= 3);
        assertEquals("A", path.get(0));
        assertEquals("H", path.get(size-1));
    }

    @Test
    public void dfPathDirectedNoPath() {
        // setup
        Graph<String> graph = Graphs.makeGraph();
        List<String> expected = null;

        // invoke
        List<String> actual = graph.dfPath("H", "A");

        // analyze
        assertEquals(expected, actual);
    }

}
