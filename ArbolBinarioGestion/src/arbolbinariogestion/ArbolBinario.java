/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolbinariogestion;

/**
 *
 * @author Erick Gaona
 */
import java.util.Scanner;

import java.util.Scanner;

class Nodo {

    int dato;
    Nodo izq, der;

    public Nodo(int info) {
        dato = info;
        izq = null;
        der = null;
    }
}

class ArbolBinario {

    Nodo raiz;
    Scanner entrada = new Scanner(System.in);

    void crearArbol() {
        System.out.print("\n\tDigite el número que sera la raíz del árbol: ");
        int numRaiz = entrada.nextInt();
        raiz = new Nodo(numRaiz);
    }

    void cargarIterativo() {
        int tmp[] = {20, 70, 10, 30, 90, 80, 100, 5};
        int valor;
        for (int i = 0; i < tmp.length; i++) {
            valor = tmp[i];
            Nodo nuevoNodo = new Nodo(valor);
            Nodo auxiliar = raiz;
            Nodo nodoPadre;
            while (true) {
                nodoPadre = auxiliar;
                if (valor >= auxiliar.dato) {
                    auxiliar = nodoPadre.der;
                } else {
                    auxiliar = nodoPadre.izq;
                }
                if (auxiliar == null) {
                    if (valor >= nodoPadre.dato) {
                        nodoPadre.der = nuevoNodo;
                    }
                    if (valor < nodoPadre.dato) {
                        nodoPadre.izq = nuevoNodo;
                    }
                    break;
                }
            }
        }
    }

    void cargarRecursivo() {
        int tmp[] = {20, 70, 10, 30, 90, 80, 100, 5};
        for (int i = 0; i < tmp.length; i++) {
            procesoRecursivo(raiz, tmp[i]);
        }
    }

    // 
    Nodo procesoRecursivo(Nodo auxiliar, int valor) {
        if (auxiliar == null) {
            auxiliar = new Nodo(valor);
            return auxiliar;
        }
        if (valor >= auxiliar.dato) {
            auxiliar.der = procesoRecursivo(auxiliar.der, valor);
        }
        if (valor < auxiliar.dato) {
            auxiliar.izq = procesoRecursivo(auxiliar.izq, valor);
        }

        return auxiliar;
    }

    void insertar() {
    // Solicitar al usuario el número a insertar
    System.out.print("\n\tDigite el número que desea insertar: ");
    int valor = entrada.nextInt();

    // Crear un nuevo nodo con el número ingresado
    Nodo nuevoNodo = new Nodo(valor);

    // Verificar si el árbol está vacío
    if (raiz == null) {
        // El árbol está vacío, el nuevo nodo se convierte en la raíz
        raiz = nuevoNodo;
        System.out.println("Número insertado como raíz del árbol.");
    } else {
        // El árbol no está vacío, encontrar el lugar adecuado para insertar el nuevo nodo
        Nodo auxiliar = raiz; // auxiliar se establece como la raíz del árbol  para comenzar el recorrido desde la raíz
        Nodo nodoPadre;

        while (true) {
            nodoPadre = auxiliar;
            
            // Comparar el valor del nuevo nodo con el valor del nodo actual
            if (valor >= auxiliar.dato) {    // 4 > 8
                // Mover hacia la derecha en el árbol
                auxiliar = nodoPadre.der;
            } else {                         // 4 < 8
                // Mover hacia la izquierda en el árbol
                auxiliar = nodoPadre.izq;
            }

            // Verificar si se ha encontrado el lugar adecuado para insertar el nuevo nodo
            if (auxiliar == null) {
                // Insertar el nuevo nodo como hijo derecho o izquierdo del nodo padre
                if (valor >= nodoPadre.dato) {
                    nodoPadre.der = nuevoNodo;
                } else {
                    nodoPadre.izq = nuevoNodo;
                }
                System.out.println("Número insertado correctamente.");
                break;
            }
        }
    }
}

    void eliminar() {
        System.out.print("\n\tDigite el número que desea eliminar: ");
        int valor = entrada.nextInt();

        if (raiz == null) {
            System.out.println("El árbol está vacío. No se puede eliminar ningún número.");
            return;
        }

        Nodo nodoActual = raiz;
        Nodo nodoPadre = raiz;
        boolean esHijoIzquierdo = true;

        // Buscar el nodo a eliminar
        while (nodoActual.dato != valor) {
            nodoPadre = nodoActual;

            if (valor < nodoActual.dato) {
                esHijoIzquierdo = true;
                nodoActual = nodoActual.izq;
            } else {
                esHijoIzquierdo = false;
                nodoActual = nodoActual.der;
            }

            if (nodoActual == null) {
                System.out.println("El número no se encuentra en el árbol.");
                return;
            }
        }

        // Caso 1: El nodo a eliminar es una hoja
        if (nodoActual.izq == null && nodoActual.der == null) {
            if (nodoActual == raiz) {
                raiz = null;
            } else if (esHijoIzquierdo) {
                nodoPadre.izq = null;
            } else {
                nodoPadre.der = null;
            }
        } // Caso 2: El nodo a eliminar tiene un solo hijo (derecho)
        else if (nodoActual.izq == null) {
            if (nodoActual == raiz) {
                raiz = nodoActual.der;
            } else if (esHijoIzquierdo) {
                nodoPadre.izq = nodoActual.der;
            } else {
                nodoPadre.der = nodoActual.der;
            }
        } // Caso 3: El nodo a eliminar tiene un solo hijo (izquierdo)
        else if (nodoActual.der == null) {
            if (nodoActual == raiz) {
                raiz = nodoActual.izq;
            } else if (esHijoIzquierdo) {
                nodoPadre.izq = nodoActual.izq;
            } else {
                nodoPadre.der = nodoActual.izq;
            }
        }

        System.out.println("Número eliminado correctamente.");
    }

    void preorden() {
    }

    void inorden() {
    }

    void posorden() {
    }

    // Metodos utilizados para visualizar el arbol
    void visualizarArbol() {
        System.out.println("Visualizar estructura del árbol binario:");
        imprimirEstructuraRecursivo(raiz, 0);
    }

    //
    void imprimirEstructuraRecursivo(Nodo nodo, int nivel) {
        if (nodo != null) {
            imprimirEstructuraRecursivo(nodo.der, nivel + 1);
            System.out.println(obtenerIndentacion(nivel) + nodo.dato);
            imprimirEstructuraRecursivo(nodo.izq, nivel + 1);
        }
    }

    //
    String obtenerIndentacion(int nivel) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }
}
