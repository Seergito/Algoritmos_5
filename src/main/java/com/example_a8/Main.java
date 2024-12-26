package com.example_a8;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // Se busca construir un recorrido que pase por todos los vértices de un grafo
    // exactamente una vez, minimizando la distancia

    public static <E> Grafo<E, Integer> viajante(Grafo<E, Integer> g, Vertice<E> v) {
        // Lista de vértices que aún no han sido visitados.
        Lista<Vertice<E>> porVisitar = new ListaEnlazada<>();

        // Grafo solución, que contendrá el camino final del viajante.
        Grafo<E, Integer> grafoSolucion = new ListaAdyacente<>();

        // Iterador sobre los vértices del grafo original.
        Iterator<Vertice<E>> it = g.vertices();

        // Inicializa la lista de vértices por visitar y añade los vértices al grafo
        // solución.
        while (it.hashNext()) {
            Vertice<E> i = it.next();
            porVisitar.insertarFinal(i); // Agrega cada vértice a la lista de no visitados.
            grafoSolucion.insertaVertice(i); // Crea el vértice en el grafo solución.
        }

        // Marca el vértice inicial como visitado.
        porVisitar.suprimir(v);
        Vertice<E> actual = v; // El vértice inicial para comenzar el recorrido.

        // Itera mientras queden vértices por visitar.
        while (!porVisitar.esVacio()) {
            // Selecciona el arco con menor coste desde el vértice actual hacia un vértice
            // no visitado.
            Arco<E, Integer> arco = seleccionarViajante(g.arcos(), actual, porVisitar);

            // Si no se encuentra un arco válido, retorna un grafo vacío (no hay solución
            // posible).
            if (arco == null) {
                return new ListaAdyacencia<>();
            }

            // Marca el destino del arco como visitado.
            porVisitar.suprimir(arco.getDestino());

            // Inserta el arco seleccionado en el grafo solución.
            grafoSolucion.insertarArco(arco);

            // Actualiza el vértice actual al destino del arco seleccionado.
            actual = arco.getDestino();
        }

        // Retorna el grafo solución que representa el recorrido.
        return grafoSolucion;
    }

    // Este método selecciona el arco con menor coste que conecta el vértice actual
    // con un vértice no visitado.

    private static <E> Arco<E, Integer> seleccionarViajante(
            Iterator<Arco<E, Integer>> arcos,
            Vertice<E> actual,
            Lista<Vertice<E>> porVisitar) {

        // Inicializa el arco seleccionado como nulo.
        Arco<E, Integer> arco = null;

        // Itera sobre todos los arcos del grafo.
        while (arcos.hashNext()) {
            Arco<E, Integer> a = arcos.next();

            // Verifica si el arco es válido:
            // - El origen del arco debe ser el vértice actual.
            // - El destino del arco debe estar en la lista de vértices no visitados.
            // - El arco debe tener el menor coste entre los candidatos.
            if (a.getOrigen().equals(actual) && porVisitar.contiene(a.getDestino())
                    && (arco == null || a.getEtiqueta() < arco.getEtiqueta)) {
                arco = a; // Actualiza el arco seleccionado.
            }
        }

        // Retorna el arco con menor coste encontrado, o null si no se encontró ninguno.
        return arco;
    }


    public static <E> Grafo<E, Integer> prim(Grafo<E, Integer> g, Vertice<E> v) {
        // Crear un nuevo grafo para almacenar el árbol de expansión mínima
        Grafo<E, Integer> grafoSolucion = new ListaAdyacencia<>();
        
        // Lista de vértices aún no conectados al árbol
        Lista<Vertice<E>> porVisitar = new ListaEnlazada<>();
        Iterator<Vertice<E>> it = g.vertices();
        
        // Copiar todos los vértices del grafo original al grafo solución y la lista porVisitar
        while (it.hashNext()) {
            Vertice<E> w = it.next();
            porVisitar.insertarFinal(w);
            grafoSolucion.insertarVertice(w);
        }
        
        // Eliminar el vértice inicial de la lista porVisitar
        porVisitar.suprimir(v);
    
        // Mientras queden vértices por visitar
        while (!porVisitar.esVacio()) {
            // Seleccionar el arco de menor peso que conecta un vértice del árbol con uno fuera de él
            Arco<E, Integer> arco = seleccionarPrim(g.arcos(), porVisitar);
            
            // Si no se encuentra un arco válido, devolver un grafo vacío (grafo no conexo)
            if (arco == null) {
                return new ListaAdyacencia<>();
            }
            
            // Eliminar el vértice destino del arco seleccionado de la lista porVisitar
            porVisitar.suprimir(arco.getDestino());
            
            // Agregar el arco al grafo solución
            grafoSolucion.insertarArco(arco);
        }
        
        // Devolver el árbol de expansión mínima
        return grafoSolucion;
    }
    
    /**
     * Método auxiliar para seleccionar el arco de menor peso que conecta un vértice del árbol
     * con uno fuera de él.
     */
    private static <E> Arco<E, Integer> seleccionarPrim(Iterator<Arco<E, Integer>> arcos, Lista<Vertice<E>> porVisitar) {
        Arco<E, Integer> arco = null;
    
        // Recorrer todos los arcos del grafo
        while (arcos.hashNext()) {
            Arco<E, Integer> a = arcos.next();
    
            // Verificar si el arco conecta un vértice dentro del árbol con uno fuera de él
            if (porVisitar.contiene(a.getDestino()) && 
                !porVisitar.contiene(a.getOrigen()) && 
                (arco == null || arco.getEtiqueta() > a.getEtiqueta())) {
                
                // Actualizar el arco seleccionado si es el de menor peso encontrado hasta ahora
                arco = a;
            }
        }
    
        // Devolver el arco de menor peso encontrado, o null si no se encontró ninguno válido
        return arco;
    }
    

}