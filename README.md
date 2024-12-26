# Algoritmos de Grafos

---

## Descripción General

Este repositorio contiene implementaciones de varios algoritmos clásicos relacionados con grafos. Estos algoritmos resuelven problemas como el árbol de expansión mínima, la ruta del viajante, y el coloreo de grafos. El código está escrito en Java y utiliza estructuras como listas enlazadas y listas de adyacencia para representar los grafos y sus elementos.

---

## Algoritmos Implementados

### 1. **Árbol de Expansión Mínima (Algoritmo de Prim)**

- **Descripción**: Encuentra el árbol de expansión mínima en un grafo conexo, es decir, el subconjunto de arcos que conecta todos los vértices con el menor peso posible sin ciclos.
- **Entrada**: 
  - Un grafo no dirigido con pesos en los arcos.
  - Un vértice inicial desde donde comenzar la construcción del árbol.
- **Salida**: Un subgrafo que representa el árbol de expansión mínima.
- **Métodos principales**:
  - `prim(Grafo<E, Integer> g, Vertice<E> v)`
  - `seleccionarPrim(Iterator<Arco<E, Integer>> arcos, Lista<Vertice<E>> porVisitar)`

### 2. **Ruta del Viajante (Heurística Voraz)**

- **Descripción**: Heurística para aproximar la solución al problema del viajante. Busca construir un recorrido que pase por todos los vértices del grafo exactamente una vez con el menor costo posible.
- **Entrada**: 
  - Un grafo completo con pesos en los arcos.
  - Un vértice inicial como punto de partida.
- **Salida**: Un grafo que representa el recorrido aproximado del viajante.
- **Métodos principales**:
  - `viajante(Grafo<E, Integer> g, Vertice<E> v)`
  - `seleccionarViajante(Iterator<Arco<E, Integer>> arcos, Vertice<E> actual, Lista<Vertice<E>> porVisitar)`

### 3. **Coloreo de Mapas**

- **Descripción**: Resuelve el problema de coloreo de vértices de un grafo, asegurando que dos vértices adyacentes no tengan el mismo color.
- **Entrada**: 
  - Un grafo representando las relaciones entre regiones.
  - Un conjunto de colores disponibles.
- **Salida**: Un mapa que asigna un color a cada vértice.
- **Métodos principales**:
  - `colorearMapa(Grafo<E, Integer> g, String[] colores)`
  - `seleccionarColor(String[] colores, Map<Vertice<E>, String> mapaColoreado, Vertice<E> v, Grafo<E, Integer> g)`

---

