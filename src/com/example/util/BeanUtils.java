package com.example.util;

import java.lang.reflect.Field;

public class BeanUtils {


    /**
     * A simple bean copying utility, copies the values of fields from src object
     * into a new instance of destClass.
     * @param src
     * @param destClass
     * @param <T>
     * @return
     */
    public static <T> T copy(Object src, Class<T> destClass){
        T result;
        T exceptionResult = null;
        try {
            result = destClass.newInstance();
            exceptionResult = destClass.newInstance();
            Class srcClass = src.getClass();
            Field[] srcFields = srcClass.getDeclaredFields();
            for(Field field : srcFields){
                field.setAccessible(true);
                Field destField = destClass.getDeclaredField(field.getName());
                destField.setAccessible(true);
                destField.set(result, field.get(src));
            }

        } catch (Exception e) {
            System.out.println("Copying has failed");
            e.printStackTrace();
            return exceptionResult;
        }
        return result;
    }
}
