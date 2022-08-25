package edu.java.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        HelloClass obj = (HelloClass) context.getBean("HelloJavaClass");
//        obj.printMessage();
//
//        HelloClass obj2 = (HelloClass) context.getBean("HelloJavaClass2");
//        obj2.printMessage();
//        System.out.println(obj2 == obj2);
//        context.registerShutdownHook();

//        HelloWorld obj1 = (HelloWorld) context.getBean("helloWorld");
//        obj1.sayHello();
//        JavaClazz clazz = (JavaClazz) context.getBean("jee01");
//        System.out.println("Map Implement is "+clazz.getStudents().getClass());
//        System.out.println("There are "+clazz.getStudents().size()+" in the class");
//        HelloClass clazz = (HelloClass) context.getBean("HelloJavaClass");
//        System.out.println("Total classes is "+clazz.getClazzes().size());
        context.start();
    }
}
