package pr3.org.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.io.IOException;

public class Graph<V> {
    // Lista de adyacencia.
    private Map<V, Set<V>> adjacenyList = new HashMap();

    /*
     * Añade el vértice ‘v‘ al grafo.
     * 
     * @param v vértice a añadir.
     * 
     * @return ‘true‘ si no estaba anteriormente y ‘false‘ en caso contrario.
     */

     //Complejidad O(n^2): dos bucles se incrementan linealmente uno dentro de otro.
    public boolean addVertex(V v) {
        if (adjacenyList.keySet().contains(v)) {
            System.out.println(v + " Este vértice no se puede introducir, está duplicado ");
            return false;
        } else {
            adjacenyList.put(v, new HashSet());
            // System.out.println(toString());
            return true;
        }
    }
    /*
     * Añade un arco (arista) entre los vértices ‘v1‘ y ‘v2‘ al grafo. En caso de
     * que no exista alguno de los vértices, lo añade también. v1 el origen del
     * arco.
     * 
     * @param v2 el destino del arco.
     * 
     * @return ‘true‘ si no existía el arco y ‘false‘ en caso contrario.
     */

    // añadir aristas (conexión entre puntos), comprobar que no se añaden dos
    // aristas iguales.
    //Complejidad O(n^2): dos bucles se incrementan linealmente uno dentro de otro.
    public boolean addEdge(V v1, V v2) {
        // camino (arista) de v1 a v2
        Set<V> aristas = adjacenyList.get(v1);
        if (aristas.contains(v2)) {
            return false;
        }

        // camino (arista) de v2 a v1
        aristas.add(v2);
        aristas = adjacenyList.get(v2);
        if (aristas.contains(v1)) {
            return false;
        } else {
            aristas.add(v1);
            return true;
        }
    }

    /*
     * Obtiene el conjunto de vértices adyacentes a ‘v‘.
     * 
     * @param v vértice del que se obtienen los adyacentes.
     * 
     * @return conjunto de vértices adyacentes.
     */

     //Complejidad O(n^2): dos bucles se incrementan linealmente uno dentro de otro.
    public Set<V> obtainAdjacents(V v) throws Exception {
        if (adjacenyList.get(v) == null) {
            throw new Exception("k");
        } else {
            return adjacenyList.get(v);
        }
    }

    /*
     * Comprueba si el grafo contiene el vértice dado.
     * 
     * @param v vértice para el que se realiza la comprobación.
     * 
     * @return ‘true‘ si ‘v‘ es un vértice del grafo.
     */

     //Complejidad O(n^2): dos bucles se incrementan linealmente uno dentro de otro.
    public boolean containsVertex(V v) {
        if (adjacenyList.containsKey(v)) {
            System.out.println(v + " Este vértice ya está contenido en el grafo");
            return true;
        } else {
            System.out.println(v + " Este vértice no está contenido en el grafo");
            return false;
        }
    }

    /*
     * Método ‘toString()‘ reescrito para la clase ‘Grafo.java‘.
     * 
     * @return una cadena de caracteres (String) con la lista de adyacencia.
     */

    //Complejidad O(n): bucle se incrementa linealmente.
    @Override
    public String toString() {
        String S = "";
        for (V v : this.adjacenyList.keySet()) {
            S += (v.toString() + " relacionado con " + adjacenyList.get(v).toString() + "\n");
        }
        return S;
    }

    /*
     * Obtiene, en caso de que exista, un camino entre ‘v1‘ y ‘v2. En caso
     * contrario, devuelve ‘null‘.
     *
     * @param v1 el vértice origen.
     * 
     * @param v2 el vértice destino.
     * 
     * @return lista con la secuencia de vértices desde ‘v1‘ hasta ‘v2‘ pasando por
     * arcos del grafo.
     */

     //Complejidad O(ln n): bucle se incrementa no linealmente.
    public List<V> onePath(V v1, V v2) {
        boolean encontrado = false;
        Stack<V> abierta = new Stack<>();
        ArrayList<V> traza = new ArrayList<>();

        abierta.push(v1);
        // Si la pila esta llena y no se ha encontrado solución, se saca vértice de la
        // pila y se añade a la lista.
        while (!abierta.isEmpty() && !encontrado) {
            V vertice = abierta.pop();
            traza.add(vertice);
            if (vertice.equals(v2)) {
                encontrado = true;
            } else {
                for (V verticeAdyacente : adjacenyList.get(vertice)) {
                    if (traza.contains(verticeAdyacente)) {
                    } else {
                        abierta.push(verticeAdyacente);
                    }
                }
            }
        }
        System.out.println(traza + "traza");
        return traza;
    }
}