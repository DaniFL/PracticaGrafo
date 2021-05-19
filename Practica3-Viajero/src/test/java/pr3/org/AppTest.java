package pr3.org;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import pr3.org.dominio.Graph;

/**
 * Unit test for simple App.
 */
public class AppTest {

    // Rigorous Test

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void añadirVertice() {
        System.out.println("\n - TEST 1:");
        Graph<Integer> g0 = new Graph<>();
        assertTrue(g0.addVertex(1));
        assertTrue(g0.addVertex(2));
        assertTrue(g0.addVertex(3));
        assertTrue(g0.addVertex(4));
        assertFalse(g0.addVertex(3));

        // con string
        Graph<String> g01 = new Graph<>();
        assertTrue(g01.addVertex("hola"));
        assertTrue(g01.addVertex("adiós"));

    }

    @Test
    public void añadirarista() {
        // System.out.println("TEST 2:");
        Graph<Integer> g1 = new Graph<>();
        assertTrue(g1.addVertex(3));
        assertTrue(g1.addVertex(4));
        assertTrue(g1.addVertex(5));
        assertFalse(g1.addVertex(3));
        assertTrue(g1.addEdge(3, 4));
        assertFalse(g1.addEdge(4, 3));
        assertTrue(g1.addEdge(3, 5));

        // con string
        Graph<String> g11 = new Graph<>();
        assertTrue(g11.addVertex("hola"));
        assertTrue(g11.addVertex("adiós"));

    }

    @Test(expected = Exception.class)
    // lanza excepción cuando no detecta vertice en la lista de adyacencia
    public void obtainAdjacents() throws Exception {
        System.out.println("\n - TEST 3:");
        Graph<Integer> g2 = new Graph<>();
        g2.addVertex(1);
        g2.addVertex(2);
        g2.addVertex(3);
        g2.addVertex(4);
        g2.addVertex(5);
        g2.addVertex(6);
        assertTrue(g2.addEdge(1, 2));
        assertTrue(g2.addEdge(1, 4));
        assertTrue(g2.addEdge(4, 3));
        assertTrue(g2.addEdge(3, 5));
        assertTrue(g2.addEdge(4, 6));
        g2.obtainAdjacents(5);
        g2.obtainAdjacents(4);
        g2.obtainAdjacents(7);
        g2.obtainAdjacents(0);

    }

    @Test
    public void containsVertex() {
        System.out.println("\n - TEST 4: ");
        Graph<Integer> g3 = new Graph<>();
        g3.addVertex(1);
        g3.addVertex(2);
        g3.addVertex(3);
        g3.addVertex(4);
        g3.addVertex(5);
        g3.addVertex(6);
        assertTrue(g3.containsVertex(1));
        assertTrue(g3.containsVertex(6));
        assertFalse(g3.containsVertex(8));
        assertFalse(g3.containsVertex(10));

    }

    @Test
    public void toStringPrueba() {
        System.out.println("\n - TEST 5: ");
        Graph<Integer> g4 = new Graph<>();
        g4.addVertex(1);
        g4.addVertex(2);
        g4.addVertex(3);
        g4.addVertex(6);
        g4.addEdge(1, 6);
        g4.addEdge(6, 3);
        System.out.println(g4.toString());
        assertEquals("1 relacionado con [6]\n2 relacionado con []\n3 relacionado con [6]\n6 relacionado con [1, 3]\n",
                g4.toString());
    }

}
