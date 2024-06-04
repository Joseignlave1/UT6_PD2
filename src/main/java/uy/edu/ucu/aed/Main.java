package uy.edu.ucu.aed;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jechague
 */
public class Main {

    public static void main(String[] args) {

        // Crear una tabla de tipo THash e insertar las claves del archivo "claves_insertar.txt"

        // Buscar en la tabla creada anteriormente las claves indicadas en el archivo "claves_buscar.txt"
        int cantidadElementosHash = 200;
        int incremento70 = 70;
        int incremento90 = 90;
        int incremento99 = 99;
        String[] leerArchivoInsertar = ManejadorArchivosGenerico.leerArchivo("src/claves_insertar.txt");
        String[] leerArchivoBuscar = ManejadorArchivosGenerico.leerArchivo("src/claves_buscar.txt");

        for(int factordeCarga = incremento70; factordeCarga < incremento90; factordeCarga += 5) {
            comparaciones(cantidadElementosHash, factordeCarga , leerArchivoInsertar, leerArchivoBuscar);
        }
        for(int factordeCarga = incremento90; factordeCarga < incremento99; factordeCarga += 1) {
            comparaciones(cantidadElementosHash, factordeCarga , leerArchivoInsertar, leerArchivoBuscar);
        }
    }
    private static void comparaciones(int cantidadElementosHash, int factordeCarga,  String[] leerArchivoInsertar, String[] leerArchivoBuscar)  {
        //Math.ceil, redondea un número a su entero más cercano
        //Redondeamos el cálculo del tamaño de la tabla hash a entero para asegurarnos de tener suficiente espacio sin exceder el factor de carga
        int tamañoTabla = (int) Math.ceil((double) cantidadElementosHash /  ((double) factordeCarga / 100));
        THash tablaHash = new THash(tamañoTabla);

        int comparacionesTotalesInsertar = 0;
        int comparacionesTotalesBuscar = 0;
        int busquedasFallidas = 0;
        int busquedasConExito = 0;

        for(String string : leerArchivoInsertar) {
            comparacionesTotalesInsertar += tablaHash.insertar(Integer.parseInt(string));
        }
        for(String string : leerArchivoBuscar) {
            int comparaciones = tablaHash.buscar(Integer.parseInt(string));
            if(comparaciones != -1) { //Comparaciónes con éxito
                comparacionesTotalesBuscar += comparaciones;
                busquedasConExito++;
            } else {
                busquedasFallidas++;
            }
        }
        int comparacionesInsertarPromedio = comparacionesTotalesInsertar / cantidadElementosHash;
        int promedioBusquedasConExito = busquedasConExito > 0 ? comparacionesTotalesBuscar / busquedasConExito : 0;
        int promedioBusquedasSinExito = busquedasFallidas > 0 ? comparacionesTotalesBuscar / busquedasFallidas : 0;

        System.out.println("Factor de carga: " + factordeCarga + "%");
        System.out.println("Promedio de comparaciones insertar: " + comparacionesInsertarPromedio);
        System.out.println("Promedio de comparaciones con éxito: " + promedioBusquedasConExito);
        System.out.println("Promedio de comparaciones en busquedas sin éxito " +  promedioBusquedasSinExito);
    }

}
