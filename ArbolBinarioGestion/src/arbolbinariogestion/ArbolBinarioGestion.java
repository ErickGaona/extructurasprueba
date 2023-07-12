/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolbinariogestion;

/**
 *
 * @author Erick Gaona
 */



import java.util.Scanner;

public class ArbolBinarioGestion {
    public static void main(String[] args) { 
        // 
        Scanner entrada = new Scanner(System.in); 
        ArbolBinario arbol = new ArbolBinario(); 
        //       
        int op;
        do { 
            opciones(); 
            System.out.print("\tOpcion: ");
            op = entrada.nextInt();
            switch (op) {  
                case 1  : arbol.crearArbol(); break; 
                case 2  : arbol.cargarIterativo(); break; 
                case 3  : arbol.cargarRecursivo(); break; 
                case 4  : arbol.insertar(); break; 
                case 5  : arbol.eliminar(); break; 
                case 6  : arbol.preorden(); break; 
                case 7  : arbol.inorden(); break; 
                case 8  : arbol.posorden(); break; 
                case 9  : arbol.visualizarArbol(); break; 
            }
        } while(op != 0);
    }
    
    static void opciones() { 
        System.out.println("\t|===========================================|");
        System.out.println("\t| Arboles binarios: Menú Principal.         |");
        System.out.println("\t|===========================================|");
        System.out.println("\t| 1.  Crear Arbol binario.                  |");
        System.out.println("\t| 2.  Cargar datos iterativo.               |"); 
        System.out.println("\t| 3.  Cargar datos recursivo.               |"); 
        System.out.println("\t| 4.  Insertar elemento.                    |"); 
        System.out.println("\t| 5.  Eliminar elemento.                    |"); 
        System.out.println("\t| 6.  Recorrido preorden.                   |"); 
        System.out.println("\t| 7.  Recorrido inorden.                    |"); 
        System.out.println("\t| 8.  Recorrido posorden.                   |"); 
        System.out.println("\t| 9.  visualizar Arbol.                     |"); 
        System.out.println("\t| 0.  Salir.                                |");
        System.out.println("\t|===========================================|");
    }
}


