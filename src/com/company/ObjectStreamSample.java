package com.company;
import java.io.*;
import java.util.*;
public class ObjectStreamSample implements  Serializable{

    public static List<Animal> getAnimals(File dataFile) throws  IOException, ClassNotFoundException {

        List<Animal> a=new ArrayList<>();
        try(ObjectInputStream oos=new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))){

            while(true){
                Object object=(Animal)oos.readObject();//cast an object explicitly.
                if(object instanceof Animal){//checks if an object is an instance of Animal or not.and returns false
                    //in the case of null.
                    a.add((Animal)object);
                }
            }
        }
        catch(EOFException e){
            System.out.println("End of File Exception caught..");
            //We have to catch this Exception in any case.Coz in deserialisation we cant come to
            //to know when file reading ends. we cant use -1 in while as its dealing with object.Niether we can use
            //use null. this while(true) is the only condition.
        }
        return a;
    }
    public static void creatAniamlsFile(List<Animal> animals, File dataFile) throws ClassNotFoundException,IOException{
        try(ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))){
            for(Animal animal:animals)
                oos.writeObject(animal);
        }
    }
}
