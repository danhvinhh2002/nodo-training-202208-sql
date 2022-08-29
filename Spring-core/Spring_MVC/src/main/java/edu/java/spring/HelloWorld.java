package edu.java.spring;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class HelloWorld {
    private final static Logger logger = Logger.getLogger(HelloWorld.class);
    @Autowired(required = true)
    @Qualifier("HelloJavaClass2")
    public HelloClass clazz;

    String message;
    
    public HelloWorld() {
    }

    public void sayHello(){
        clazz.printMessage();
        logger.info("From HelloWorld: "+message);
    }
    @Required
    public void setMessage(String message) {
        this.message = message;
    }

//    public void setMessage(String value) {
//        this.message = value;
//    }

    public String getMessage() {
        return message;
    }

    public HelloWorld(String name, HelloClass clazz) {
        this.message = "From HelloWorld constructor: "+name+" : "+clazz.getMessage();
    }

    public void setClazz(HelloClass clazz) {
        this.clazz = clazz;
    }
}
