/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlsv.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author theanh
 * 
 */
public class IO {
    public static Object readObject(String path) throws FileNotFoundException, IOException{
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            Object object = ois.readObject();
            ois.close();
            return object;
        }
        catch(Exception e){
            System.out.println( e);
        }
        return null;
    }
    
    public static void writeObject(String path,Object object) throws FileNotFoundException, IOException{
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(object);
            oos.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
