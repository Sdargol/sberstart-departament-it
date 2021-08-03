package org.sdargol.utils;

import org.sdargol.render.Render;
import org.sdargol.utils.exceptions.NotSupportFieldByMappingException;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesUtil {
    private static final String MAIN_DIR = System.getProperty("user.dir");

    public static <T> List<T> read(String fileName, Class<T> cls) throws NotSupportFieldByMappingException {
        Field[] fields = cls.getDeclaredFields();

        //обеспечиваем поддержку DTO только с полями с типом String
        for (Field field : fields) {
            if(field.getType() != String.class){
                throw new NotSupportFieldByMappingException("Error mapping", cls.getName(), field.getName() );
            }
        }

        List<T> objects = new ArrayList<>();
        //System.out.println(System.getProperty("java.class.path"));
        String filePath = MAIN_DIR+"//" + fileName + ".txt";
        List<String> lines = null;

        //Получаем список строк из файла
        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //если не получилось прочитать
        if(lines == null){
            throw new NullPointerException();
        }

        System.out.println("Lines size: " + lines.size());

        //идем по строкам
        //получаем конструктор переданного класса, получаем инстанс класса
        //получаем массив слов через разделитель пробел (из строки из файла)
        //устанавливаем значение поля напрямую
        //добавляем объект в список
        for (String line : lines) {
            Constructor<?> constructor = null;

            try {
               constructor = cls.getConstructor();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            Object objInstance = null;

            try {
                objInstance = constructor.newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            String[] values = line.split("\\s");

            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                try {
                    fields[i].set(objInstance, values[i]);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            objects.add((T)objInstance);
        }
        return objects;
    }

    public static <T> boolean write(List<? extends T> src, Class<T> cls, String fileName) throws NotSupportFieldByMappingException {
        Field[] fields = cls.getDeclaredFields();

        //обеспечиваем поддержку DTO только с полями с типом String
        for (Field field : fields) {
            if(field.getType() != String.class){
                throw new NotSupportFieldByMappingException("Error mapping", cls.getName(), field.getName() );
            }
        }

        String filePath = MAIN_DIR+"\\" + fileName + ".txt";

        try(FileWriter writer = new FileWriter(filePath, false)) {
            //номер объекта (надо чтобы не добавлять лишний перевод строки)
            int objNumber = 0;
            //элементы исходной коллекции
            for (T obj : src) {
                //формируем строку для записи в файл
                StringBuilder out = new StringBuilder();
                //проходим по полям класса
                //получаем значение, добавляем его в строку + пробел как разделитель
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    try {
                        String s = (String) fields[i].get(obj);
                        out.append(s);
                        if(i + 1 != fields.length){
                            out.append(" ");
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

                //проверка на лишний перевод строки
                if(objNumber + 1 != src.size()){
                    out.append('\n');
                }
                objNumber = objNumber + 1;
                writer.write(out.toString());
            }
            writer.flush();
        }catch(IOException ex){
            Render.print("error", ex.getMessage(), true);
            return false;
        }
        return true;
    }
}
