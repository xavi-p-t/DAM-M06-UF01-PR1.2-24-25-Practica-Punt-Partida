package com.project;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.project.excepcions.IOFitxerExcepcio;

public class PR120mainPersonesHashmap {
    private static String filePath = System.getProperty("user.dir") + "/data/PR120persones.dat";
    static FileOutputStream fo = null;
    static DataOutputStream dt = null;
    static DataInputStream dit = null;
    static FileInputStream fit = null;

    public static void main(String[] args) {
        HashMap<String, Integer> persones = new HashMap<>();
        persones.put("Anna", 25);
        persones.put("Bernat", 30);
        persones.put("Carla", 22);
        persones.put("David", 35);
        persones.put("Elena", 28);

        try {
            escriurePersones(persones);
            llegirPersones();
        } catch (IOFitxerExcepcio e) {
            System.err.println("Error en treballar amb el fitxer: " + e.getMessage());
        }
    }

    // Getter per a filePath
    public static String getFilePath() {
        return filePath;
    }

    // Setter per a filePath
    public static void setFilePath(String newFilePath) {
        filePath = newFilePath;
    }

    // Mètode per escriure les persones al fitxer
    public static void escriurePersones(HashMap<String, Integer> persones) throws IOFitxerExcepcio {
       // *************** CODI PRÀCTICA **********************/
        try{
            FileOutputStream fo = new FileOutputStream(filePath);
            DataOutputStream dt = new DataOutputStream(fo);
            String[] keys = persones.keySet().toArray(new String[0]);
            Integer[] values = persones.values().toArray(new Integer[0]);
            String fin = "";
            for (int i = 0; i<keys.length;i++){
                fin += keys[i]+": "+values[i]+" anys\n";
            }
            dt.writeUTF(fin);
            dt.flush();
        } catch (FileNotFoundException e) {
            throw new IOFitxerExcepcio("No se encontro el fichero",e);
        } catch (IOException e) {
            throw new IOFitxerExcepcio("Fallo al leer",e);
        }finally {
            try {
                if (fo != null) {
                    fo.close();
                }
                if (dt != null) {
                    dt.close();
                }
            } catch (Exception e) {
                throw new IOFitxerExcepcio("Fallo al cerrar",e);
            }
        }

        }

    // Mètode per llegir les persones des del fitxer
    public static void llegirPersones() throws IOFitxerExcepcio {
        // *************** CODI PRÀCTICA **********************/
        try{
            FileInputStream fit = new FileInputStream(filePath);
            DataInputStream dit = new DataInputStream(fit);

            System.out.println(dit.readUTF());
        }

        catch (FileNotFoundException e) {
            throw new IOFitxerExcepcio("No se encontro el fichero",e);
        } catch (IOException e) {
            throw new IOFitxerExcepcio("Fallo al leer",e);
        } finally {
            try {
                if (fit != null) {
                    fit.close();
                }
                if (dit != null) {
                    dit.close();
                }
            } catch (Exception e) {
                throw new IOFitxerExcepcio("Fallo al cerrar",e);
            }
        }
    }
}
