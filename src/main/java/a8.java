import grafo.*;
import java.util.Iterator;
import lista.*;

public class a8 {

public static <E> Grafo<E,Integer> viajante(Grafo<E,Integer> g, Vertice<E> v){
    Lista<Vertice<E>> porVisitar = new ListaEnlazada<>();
    Grafo<E, Integer> grafoSolucion = new ListaAdyacente<>():
    Iterator<Vertice<E>> it = g.vertices();
    while(it.hashNext()){
        Vertice<E> i = it.next();
        porVisitar.insertarFinal(i);
        grafoSolucion.insertaVertice(i);
    }

    porVisitar.suprimiar(v);
    Vertice<E> actual = v;
    while(!porVisitar.esVacio()){
        Arco<E, Integer> arco = seleccionarViajante(g.arcos(), actual, porVisitar);
        if(arco==null){
            return new ListaAdyacencia<>();
        }
        porVisitar.suprimir(arco.getDestino());
        grafoSolucion.insertarArco(arco);
        actual = arco.getDestino();
    }
    return grafoSolucion;
}

    private static <E> Arco<E, Integer> seleccionarViajante(Iterator<Arco<E, Integer>> arcos, Vertice<E> actual,
            Lista<Vetice<E>> porVisitar) {
        Arco<E, Integer> arco = null;
        while (arcos.hashNext()) {
            Arco<E, Integer> a = arcos.next();
            if (a.getOrigen().equals(actual) && porVisitar.contiene(a.getDestino())
                    && (arco == null || a.getEtiqueta() < arco.getEtiqueta)) {
                arco = a;
            }
        }
        return arco;
    }

    public static <E> Grafo<E, Integer> prim(Grafo<E, Integer> g, Vertice<E> v) {
        Grafo<E, Integer> grafoSolucion = new ListaAdyacencia<>();
        Lista<Vertice<E>> porVisitar = new ListaEnlazada<>();
        Iterator<Vertice<E>> it = g.vertices();
        while (it.hashNext()) {
            Vertice<E> w = it.next();
            porVisitar.insertarFinal(w);
            grafoSolucion.insertarVertice(w);
        }
        porVisitar.suprimir(v);

        while (!porVisitar.esVacio()) {
            Arco<E, Integer> arco = seleccionarPrim(g.arcos(), porVisitar);
            if (arco == null) {
                return new ListaAdyacencia<>();
            }
            porVisitar.suprimir(arco.getDestino());
            grafoSolucion.insertarArco(arco);

        }
        return grafoSolucion;
    }


    private static <E> Arco<E, Integer> seleccionarPrim(Iterator<Arco<EmInteger>> arcos, Lista<Vertice<E>> porVisitar){
        Arco<E,Integer> arco = null;
        while(arcos.hashNext()){
            Arco<E,Integer> a = arcos.next();
            if(porVisitar.contiene(a.getDestino()) && !porVisitar.contiene(a.getOrigen) && (arco == null || arco.getEtiqueta() > a.getEtiqueta())){
                arco = a;
            }
        }
        return arco;
    }

}
