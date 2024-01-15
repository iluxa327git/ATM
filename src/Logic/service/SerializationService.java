package Logic.service;

import models.Bank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationService {
    protected static void serialization(Bank bank){
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("SER.txt"));
            objectOutputStream.writeObject(bank);
            objectOutputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Bank deserialization() {
        Bank ser = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("SER.txt"));
            ser = (Bank) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ser;
    }

}
