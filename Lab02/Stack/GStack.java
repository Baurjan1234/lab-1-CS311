package Stack;

import java.lang.reflect.Array;

public class GStack<G> {
    private int size, count;
    private G[] array;

    public GStack(Class<G> clazz, int n) {
        array = (G[]) Array.newInstance(clazz, n);
        size = n;
        count = 0;
    }

    public Boolean isEmpty() {
        return count == 0;
    }

    public Boolean isFull() {
        return count == size;
    }

    public void push(G value) {
        if (!isFull())
            array[count++] = value;
    }

    public G pop() {
        if (!isEmpty())
            return array[--count];
        else
            return null;
        // throw new InvalidOperationException("Stack is empty!");
    }

    public G peek() {
        if (!isEmpty())
            return array[count - 1];
        return null;
    }

    public String print() {
        String values = "";

        for (int i = 0; i < count; i++)
            values = values + array[i] + " ";
        return values;
    }

    public void clear() {
        count = 0;
    }

    public static void main(String[] args) {
        GStack<Object> mystack = new GStack<Object>(Object.class, 10);
        System.out.println(mystack.size);
        System.out.println(mystack.peek());
    }
}
