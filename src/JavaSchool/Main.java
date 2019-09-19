package JavaSchool;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException {

        /*
        1. Реализовать клонирование объекта через сериализацию. Сравнить два объекта на equals и '=='
        */
        Mobile Samsung = new Mobile("Galaxy","S10", "black", 112410L);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);
        ous.writeObject(Samsung);
        ous.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);

        Mobile CloneSamsung = (Mobile)ois.readObject();
        CloneSamsung.setColor("white");
        System.out.println(Samsung);
        System.out.println(CloneSamsung);
        System.out.println("equals: " + Samsung.equals(CloneSamsung));
        System.out.println("==: "+ (Samsung == CloneSamsung));

         /*
        2. Создать 2 исключения (checked и unchecked).
        */
        try {
            Samsung.CheckedException();
        }
        catch (Exception ex)
        {
            System.out.println("Checked: " + ex.getMessage());
        }

        try {
            Samsung.getMobile(2);
        }
        catch (RuntimeException rx)
        {
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

            for (Type fieldArgType : fieldArgTypes){
                Class fieldClass = (Class) fieldArgType;
                System.out.println("type: " + fieldClass);
            }
        }

    }
}
