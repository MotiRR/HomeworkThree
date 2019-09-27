package ru.sber.edu;

import ru.sber.edu.exeptions.EmptyMyExeption;
import ru.sber.edu.exeptions.EmptyMyRuntimeException;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException {

        /*
        1. Реализовать клонирование объекта через сериализацию. Сравнить два объекта на equals и '=='
        */
        Mobile samsung = new Mobile("Galaxy", "S10", "black", 112410L);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);
        ous.writeObject(samsung);
        ous.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);

        Mobile cloneSamsung = (Mobile) ois.readObject();
        cloneSamsung.setColor("white");
        System.out.println(samsung);
        System.out.println(cloneSamsung);
        System.out.println("equals: " + samsung.equals(cloneSamsung));
        System.out.println("==: " + (samsung == cloneSamsung));

         /*
        2. Создать 2 исключения (checked и unchecked).
        */
        try {
            throw new EmptyMyExeption("EmptyMyExeption");
        } catch (EmptyMyExeption ex) {
            System.out.println("Checked: " + ex.getMessage());
        }

        try {
            throw new EmptyMyRuntimeException("EmptyMyRuntimeException");
        } catch (EmptyMyRuntimeException rx) {
            System.out.println("Unchecked: " + rx.getMessage());
        }

        /*
        3. Получить класс, объявленный в дженерике любой коллекции через рефлексию.
        */
        Field field = Mobile.class.getDeclaredField("mobiles");
        field.setAccessible(true);

        Type genericFieldType = field.getGenericType();

        if (genericFieldType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) genericFieldType;

            Type[] fieldArgTypes = pType.getActualTypeArguments();

            for (Type fieldArgType : fieldArgTypes) {
                Class fieldClass = (Class) fieldArgType;
                System.out.println("type: " + fieldClass);
            }
        }

    }
}
