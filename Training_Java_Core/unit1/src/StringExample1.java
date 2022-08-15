public class StringExample1 {
    public static void main(String[] args) {
        String text = "Say hello to everyone";
        System.out.println("length of text is "+text.length());
        System.out.println("Vi tri cua tu hello la :"+text.indexOf("hello"));
        System.out.println("cat tu ="+text.substring(4,8));
        int i = 0;
        while(i < text.length()){
            char c = text.charAt(i);
            if(c == ' '){
                i++;
                continue;
            }
            System.out.println("Character at "+i+" is "+c);
            i++;
        }
    }
}
