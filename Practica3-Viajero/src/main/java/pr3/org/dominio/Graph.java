package pr3.org.dominio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<V>{
   
    private Map<V, Set<V>> adjacenyList = new HashMap();
    
    public boolean addVertex(V v){

        if (adjacenyList.keySet().contains(v)) {
            //System.out.println("este vértice no se puede introducir, está duplicado ");
            return false;
        }
        else{
            adjacenyList.put(v, new HashSet()); 
            System.out.println(toString());
            return true;
        }
    }
    /* Añade un arco entre los vértices ‘v1‘ y ‘v2‘ al grafo. En
     caso de que no exista alguno de los vértices, lo añade
     también.
     @param v1 el origen del arco.
     @param v2 el destino del arco.
     @return ‘true‘ si no existía el arco y ‘false‘ en caso contrario.*/

    //añadir aristas conexión entre puntos, comprobar que no se añaden dos aristas igual 
    public boolean addEdge(V v1, V v2){
        //camino de v1 a v2 
        Set<V> aristas = adjacenyList.get(v1);
        aristas.add(v2); 
        //camino de v2 a v1 
        aristas = adjacenyList.get(v2);
        aristas.add(v1); 
        if (adjacenyList.get(v1).contains(v1)){
            return false; 
        }
        else {
            adjacenyList.put(v1, new HashSet());
        }
        return true;
        //verificar que no sean iguales o duplicados las aristas (caminos) con If y Else  
}


    }