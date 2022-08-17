package chuong10;

public class Stack<T> {
    private Node<T> current = null;
    public T pop(){
        T result = current.value;
        current = current.next;
        return result;
    }
    public boolean hasNext(){
        return current != null;
    }
    public void push(T v){
       Node newNode = new Node<>(v, current);
        this.current = newNode;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(23);
        stack.push(54);
        stack.push(21);
        stack.push(89);
        stack.push(11);
        stack.push(20);

        while(stack.hasNext()){
            System.out.println("data= "+stack.pop());
        }
    }
}
