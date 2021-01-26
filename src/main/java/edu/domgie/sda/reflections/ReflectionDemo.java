package edu.domgie.sda.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

    /**
     * Reflekscja pozwala podgladac definicje klas w trakcie dzialnia programu
     * Pozwala też uzaleznic dzialnie programu od tego jaka klasa go wykonuje
     * Dodatkowo pozwala modyfikować działanie klas, metod  już w trakcie działania
     */

    public static void main(String[] args) {
        try {
            Class<?> studentClass = Class.forName("edu.domgie.sda.reflections.StudentRef");

            System.out.println("-------------------getDeclaredMethod listuje wszystkie metody-----------------------");
            System.out.println("Sprawdzamy metody klasy StudentRef\n");
            Method[] classMethods = studentClass.getDeclaredMethods();
            for (Method classMethod : classMethods) {
                System.out.println(classMethod);
            }
            System.out.println("-----------------getMethods listuje tylko publiczne-------------------------");
            System.out.println("Sprawdzamy metody klady StudentRef i przodkow\n");
            Method[] allMethods = studentClass.getMethods();
            for (Method method : allMethods) {
                System.out.println(method);
            }

            System.out.println("--------------------getDeclaredFields listuje pola z klasy---------------------------");
            System.out.println("Sprawdzamy pola klasy StudentRef\n");
            Field[] classFields = studentClass.getDeclaredFields();
            for (Field field : classFields) {
                System.out.println(field);
            }

            System.out.println("----------getFields listuje pola z klasy i przodkow------------------");
            System.out.println("Sprawdzamy pola z klasy i przodkow\n");
            Field[] allFields = studentClass.getFields();
            for (Field field : allFields) {
                System.out.println(field);
            }

            System.out.println("-------------------------------");
            System.out.println("Robimy obiekt za pomoca wywyolan refleksji");
            StudentRef studentRef = (StudentRef) studentClass.getDeclaredConstructor().newInstance();
            Method setNameMethod = studentClass.getDeclaredMethod("setName", String.class);
            Method getNameMethod = studentClass.getDeclaredMethod("getName");
            setNameMethod.invoke(studentRef, "Mariola");
            System.out.println(getNameMethod.invoke(studentRef));
            System.out.println("StudentRef powolany refleksyjnie, ale jest do niego dostep bo to normalny obiekt");
            studentRef.setSurname("Zimejko");
            System.out.println(studentRef.getName() + ", " + studentRef.getSurname());
            Method getAllUniversityInfoMetod = studentClass.getDeclaredMethod("getAllUniversityInfo");
            // System.out.println(getAllUniversityInfoMetod.invoke(studentRef));


        } catch (ClassNotFoundException e) {
            //nie znaleziono klasy
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            //nie ma takiej metody
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            //nieprawidlowe zadanie dostepu do metody
            e.printStackTrace();
        } catch (InstantiationException e) {
            //nie mozna utworzy obiektu klasy
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            //nie mozna wywolac metody (metoda jest ale blad wywolan
            e.printStackTrace();
        }


    }
}
