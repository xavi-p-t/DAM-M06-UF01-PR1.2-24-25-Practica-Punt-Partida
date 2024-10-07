package com.project;

import java.io.*;

import com.project.excepcions.IOFitxerExcepcio;
import com.project.objectes.PR121hashmap;

public class PR121mainLlegeix {
    private static String filePath = System.getProperty("user.dir") + "/data/PR121HashMapData.ser";

    public static void main(String[] args) {
        try {
            PR121hashmap hashMap = deserialitzarHashMap();
            hashMap.getPersones().forEach((nom, edat) -> System.out.println(nom + ": " + edat + " anys"));
        } catch (IOFitxerExcepcio e) {
            System.err.println("Error al llegir l'arxiu: " + e.getMessage());
        }
    }

    public static PR121hashmap deserialitzarHashMap() throws IOFitxerExcepcio {
        // *************** CODI PRÀCTICA **********************/

        try {
            FileInputStream fich = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fich);

            return (PR121hashmap) ois.readObject(); // Substitueix pel teu
        } catch (FileNotFoundException e) {
            throw new IOFitxerExcepcio("El archivo no existe", e);

        } catch (IOException e) {
            throw new IOFitxerExcepcio("Error al leer", e);

        } catch (ClassNotFoundException e) {
            throw new IOFitxerExcepcio("No se ha encontrado la clase", e);
        }

    }

    // Getter
    public static String getFilePath() {
        return filePath;
    }

    // Setter
    public static void setFilePath(String newFilePath) {
        filePath = newFilePath;
    }    
}