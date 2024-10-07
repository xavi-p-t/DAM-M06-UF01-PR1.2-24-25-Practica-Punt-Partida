package com.project;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import com.project.excepcions.IOFitxerExcepcio;
import com.project.objectes.PR121hashmap;

public class PR121mainEscriu {
    private static String filePath = System.getProperty("user.dir") + "/data/PR121HashMapData.ser";

    public static void main(String[] args) {
        PR121hashmap hashMap = new PR121hashmap();
        hashMap.getPersones().put("Anna", 25);
        hashMap.getPersones().put("Bernat", 30);
        hashMap.getPersones().put("Carla", 22);

        try {
            serialitzarHashMap(hashMap);
        } catch (IOFitxerExcepcio e) {
            System.err.println("Error al desar l'arxiu: " + e.getMessage());
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

    public static void serialitzarHashMap(PR121hashmap hashMap) throws IOFitxerExcepcio {
        // *************** CODI PRÀCTICA **********************/

        try {
            FileOutputStream fo = new FileOutputStream(filePath);
            ObjectOutputStream oos  = new ObjectOutputStream(fo);
            oos.writeObject(hashMap);
            oos.flush();

        } catch (IOException e) {
            throw new IOFitxerExcepcio("Error al escribir el archivo");
        }
    }
}