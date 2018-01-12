package com.company;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main implements Serializable {
    //1: In order to serialize objects using java.IO API,the class they belong to must implement java.io.serialize interface.
    //2: Serializable interface do not have any methods associated with it.
    //3: For properly making an object Serializable may involve Nested Objects.i.e if Dog class contains a refrence to
    //   cat class them cat class must be declared as Serializable.
    //4: Not declaring a class Serializable properly will throw an NOtSerializable Exception.
    //5: Transient modifier is used to ignore the original state of an Object during Serialization and save default value of
    //   an object.
    //6: We can not mark every class Serializable in java because in particular process-heavy classes such as Thread or Stream
    //   class would be impossible to save the persistent storage.
    //7: Using SerialUId is not the requirement as we have already implemented Serializable.but its good practice
    //   because its good when we deserialize an object.
    //8: Donot rely on Java deafult SerialUID, as it comes up with compatability issues.
    //9: Java.IO provides two Stream classes for Serialize and deserializing an object called ObjectInputStream and Ob
    //   ObjectOutputStream having read(Object) and write(object) methods respectively.
    //10: In deserializing an object java.io returns readObject() whose return type is genric-type java.lang.object indi-
    //    cating that object have to be cast explicitly to use at run time.

    public static void main(String[] args)throws ClassNotFoundException,IOException {
        List<Animal> ani=new ArrayList<Animal>();
        ani.add(new Animal("Beenish",27,'f'));
        ani.add(new Animal("Bunnny",24,'g'));

        File file=new File("animal.data");
        ObjectStreamSample.creatAniamlsFile(ani,file);
        System.out.println(ObjectStreamSample.getAnimals(file));
    }
}
