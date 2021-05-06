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
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue(true );
    }
    @Test
    public void añadirVertice(){
        Graph<Integer> g1 = new Graph<>();
        assertTrue(g1.addVertex(3));
        assertFalse(g1.addVertex(3));

        //con string 
        Graph<String> g2 = new Graph<>();
        assertTrue(g2.addVertex("hola"));
        assertTrue(g2.addVertex("adiós"));
        
    }

    @Test
    public void añadirarista(){
        Graph<Integer> g1 = new Graph<>();
        assertTrue(g1.addVertex(3));
        assertTrue(g1.addVertex(4));
        assertFalse(g1.addVertex(3));
        assertTrue(g1.addEdge(3,4));

        //con string 
        Graph<String> g2 = new Graph<>();
        assertTrue(g2.addVertex("hola"));
        assertTrue(g2.addVertex("adiós"));
        
    }
}
    
