public class ConcatenateStringTest {
    public static void main(String[] args) {
        int max = 10000;
        StringBuilder builder = new StringBuilder();
        long start = System.currentTimeMillis();
        for(int i = 0 ; i< max; i++){
            builder.append(String.valueOf(i));
        }
        System.out.println("time 1 = "+(System.currentTimeMillis() -start));
    StringBuffer buffer = new StringBuffer();
    start = System.currentTimeMillis();
for(int i = 0; i<max;i++){
    buffer.append(String.valueOf(i));
}
    }
}
