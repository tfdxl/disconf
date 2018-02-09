package com.monlie;

import javassist.*;

import java.lang.reflect.Field;

public class JavassistTest {

    private static final ClassPool classPool = ClassPool.getDefault();

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        CtClass ctClass = classPool.get("com.monlie.TestClass");
        CtMethod ctMethod = ctClass.getDeclaredMethod("test");
        ctMethod.setBody("System.err.println(\"this method is changed dynamically\");");

        //Class.forName("com.monlie.TestClass");
        /**
         * 需要注意的是，在调用ctClass.toClass()时，会加载此类，如果此类在之前已经被加载过，则会报一个duplicate load的错误，表示不能重复加载一个类。所以，修改方法的实现必须在修改的类加载之前进行。
         */
        Class<TestClass> clazz = ctClass.toClass();
        TestClass testClass = clazz.newInstance();
        testClass.test();
        customClass();
    }

    static void customClass() throws NotFoundException, CannotCompileException {
        final CtClass loverClass = classPool.makeClass("com.monlie.Lover");
        final CtField mameField = new CtField(classPool.get("java.lang.String"), "name", loverClass);
        loverClass.addField(mameField);

        CtMethod getMethod = CtNewMethod.make("public String getName() { return this.name;}", loverClass);
        CtMethod setMethod = CtNewMethod.make("public void setName(String age) { this.name = name;}", loverClass);
        loverClass.addMethod(getMethod);
        loverClass.addMethod(setMethod);
        Class clazz = loverClass.toClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType()+"\t"+field.getName());
        }
        try {
            clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
