public class SystemExample {
    public static void main(String[] args) {
        System.out.println("JAVA_HOME="+System.getProperty("java.home"));
        System.setProperty("java.home","C:\\Program Files\\Java\\jdk-15.0.2");
        System.out.println("JAVA_HOME ="+System.getProperty("java.home"));
        System.out.println("User="+System.getProperty("user.name"));
    }
}
