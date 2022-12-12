package com.cesur.examenaddicc22;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

class Ejercicio1 {

    /**
     * Enunciado:
     * 
     * Completar el método estadísticasDeArchivo de manera que lea el archivo
     * de texto que se le pasa como parámetro, lo analice y muestre por consola 
     * el número de caracteres, palabras y líneas total.
     * 
     * Modificar solo el código del método.
     * 
     */
    
    static void solucion() {

        estadísticasDeArchivo("pom.xml");
    }

    private static void estadísticasDeArchivo(String archivo) {
        
        /* añadir código */
        
        BufferedReader lector= null;
        int cuentaCaracteres= 0;
        int cuentaPalabras = 0;
        int cuentaLineas = 0;
        
        try
        {
             
            lector = new BufferedReader(new FileReader("pom.xml"));
             
            String lineaActual = lector.readLine();
             
            while (lineaActual != null)
            {
                 
                cuentaLineas++;
                String[] palabras = lineaActual.split(" ");
                 
                 
                cuentaPalabras = cuentaPalabras + palabras.length;

                for (String word : palabras)
                {                   
                    cuentaCaracteres = cuentaCaracteres + word.length();
                }

                lineaActual = lector.readLine();
            }
            
            System.out.println(archivo);
            System.out.println("Hay " +cuentaLineas+" Lineas");
             
            System.out.println("Hay " +cuentaCaracteres+" Caracteres");
             
            System.out.println("Hay " +cuentaPalabras+" Palabras");
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }   
}

         
      
        
        
  
               
    
    

