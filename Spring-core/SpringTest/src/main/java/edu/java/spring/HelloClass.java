package edu.java.spring;

import org.springframework.beans.factory.DisposableBean;

import java.util.List;

public class HelloClass implements DisposableBean {
    String message;
    private List<JavaClazz> clazzes;



    private void initMessage(){
        System.out.println("Calling init method.....");
        message ="From init method: Say hello bean!";
    }
    public void setMessage(String message) {

        this.message = "Call From Setter: "+message;
    }
    public void printMessage(){
        System.out.println("Your Message: "+message);
    }

    public HelloClass() {
        this.message = "From Constructor: Say hello everyone!";
    }
    private void release(){
        message =null;
        System.out.println("Message is null");
    }

    @Override
    public void destroy() throws Exception {
        message = null;
        System.out.println("Message is null");
    }
    public List<JavaClazz> getClazzes() {
        return clazzes;
    }
    public HelloClass(int person) {
        this.message = "From Constructor: Say hello to "+person+" person(s)!";
    }
    public HelloClass(HelloClass clazz) {
        this.message = clazz.message;
    }

    public String getMessage() {
        return message;
    }

    public void setClazzes(List<JavaClazz> clazzes) {
        this.clazzes = clazzes;
    }
}
