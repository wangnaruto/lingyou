package com.linyou.students;

import com.linyou.students.Exception.SSException;
import com.linyou.students.model.PublicClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by wangmeng on 16-2-3.
 * 1. 通过Object类的getClass方法来获取
 * 2. Class clazz = String.class;
 * 3. 使用Class.forName方法
 */
public class Main {

    /**
     * default反射
     * default class 即使是反射也无法跨包进行访问
     * 这个程序会报错
     * */
    private void exmp1(){
        // 获取class
        try {
            Class<?> defaultClass = Class.forName("com.linyou.students.model.DefaultClass");
            // 默认修饰符的class不同package调用

            ClassLoader loader = ClassLoader.getSystemClassLoader();
            loader.setDefaultAssertionStatus(true);
            loader.setPackageAssertionStatus("com.linyou.students",true);
            loader.clearAssertionStatus();
            defaultClass = loader.loadClass("com.linyou.students.model.DefaultClass");

            //
            Field[] fields = defaultClass.getFields();

            //获取构造方法
            Constructor<?>[] constructor = defaultClass.getConstructors();

            Method method = defaultClass.getDeclaredMethod("getString", String.class);
            method.setAccessible(true);
            method.invoke(defaultClass.newInstance(),"xxxx");

            defaultClass.getInterfaces();

        } catch (Exception e) {
            throw new SSException(e);
        } finally {
            System.out.println("default反射");
        }
    }

    // public反射
    private void exmp2(){
        // 获取class
        try {
            Class<?> publicClass = Class.forName("com.linyou.students.model.PublicClass");

            Field[] fields = publicClass.getFields();
            Object object = publicClass.newInstance();

            Field field = publicClass.getDeclaredField("str");
            field.setAccessible(true);
            field.set(object, "sdf");

            Method method = publicClass.getDeclaredMethod("getString", String.class);
            method.setAccessible(true);
            String xxx = (String)method.invoke(object, "xxx1x");

            publicClass.getInterfaces();

            System.out.println(field.get(object));
            System.out.println(xxx);

        } catch (Exception e) {
            throw new SSException(e);
        } finally {
            System.out.println("public反射");
        }
    }

    /**
     * final class 反射
     * 不是public 的构造函数获取
     * */
    private void exmp3(){
        // 获取class
        try {
            Class<?> publicClass = Class.forName("com.linyou.students.model.FinalsClass");

            Field[] fields = publicClass.getFields();

            // 不是public 的构造函数获取
            Constructor c0 = publicClass.getDeclaredConstructor();
            c0.setAccessible(true);
            Object object = c0.newInstance();

            // 带参数构造函数
            Constructor c1 = publicClass.getDeclaredConstructor(new Class[]{int.class});
            c1.setAccessible(true);
            Object object1 = c1.newInstance(new Object[]{5});

            Field field = publicClass.getDeclaredField("str");
            field.setAccessible(true);
            field.set(object, "sdf");

            Method method = publicClass.getDeclaredMethod("getString", null);
            method.setAccessible(true);
            String xxx = (String)method.invoke(object, null);

            publicClass.getInterfaces();

            System.out.println(field.get(object));
            System.out.println(xxx);

        } catch (Exception e) {
            throw new SSException(e);
        } finally {
            System.out.println("public反射");
        }
    }

    /**
     * inner class 反射
     * 获取内部类，操作内部类的方法
     * */
    private void exmp4(){
        // 获取class
        try {
            Class<?> publicClass = Class.forName("com.linyou.students.model.InnerClass");

            Field[] fields = publicClass.getFields();
            Field[] dFields = publicClass.getDeclaredFields();

            // 内部类
            Class[] dd = publicClass.getDeclaredClasses();

            Class[] dd1 = publicClass.getClasses();

            for (Class d : dd) {

                if (!d.getSimpleName().equals("DefaultInnerClass")){
                    continue;
                }

                Constructor c0 = d.getDeclaredConstructors()[0];
                c0.setAccessible(true);
                Object object = c0.newInstance(
                        publicClass.newInstance());

                Field field = d.getDeclaredField("str");
                field.setAccessible(true);
                field.set(object, "sdf");

                Method method = d.getDeclaredMethod("getString", null);
                method.setAccessible(true);
                String xxx = (String)method.invoke(object, null);

                d.getInterfaces();

                System.out.println(field.get(object));
                System.out.println(xxx);
            }


        } catch (Exception e) {
            throw new SSException(e);
        } finally {
            System.out.println("public反射");
        }
    }

    // 注解
    private void zhu1(){

    }

    public static void main(String[] str){
        Main main = new Main();
//        try {
//            main.exmp1();
//        } catch (SSException e){
//            e.printStackTrace();
//        }

        try {
            main.exmp4();
        } catch (SSException e){
            e.printStackTrace();
        }

    }


}
