package lab2;

import java.lang.reflect.Array;
import java.util.Scanner;

public class GStack<T> {
    private int size, count;
    // final public T[] array;
    private final T array[];

    public GStack(Class<T[]> clazz, int n) {
        // array = new T[n];
        array = clazz.cast(Array.newInstance(clazz.getComponentType(), n));
        size = n;
        count = 0;
    }

    public Boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public void push(T value) {
        if (!isFull())
            array[count++] = value;
    }

    public T pop() {
        if (!isEmpty())
            return array[--count];
        else
            return null;
    }

    public T peek() {
        if (!isEmpty())
            return array[count - 1];
        else
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
        Scanner sc = new Scanner(System.in);
        System.out.print("Array length: ");
        int length = sc.nextInt();
        GStack<Object> stack = new GStack<Object>(Object[].class, length);
        System.out.println("Stack Functions \n");
        System.out.println(
                "\t1. Peek \n\t2. isEmpty \n\t3. isFull \n\t4. Push \n\t5. Pop \n\t6. Clear \n\t7. Print \n\t8. Exit  ");

        while (true) {

            System.out.print("Enter number: ");
            int key = sc.nextInt();
            switch (key) {
                case 1: {
                    System.out.println();
                    // key == 5 ? System.out.println("");
                    if (stack.peek() != null)
                        System.out.println("Peek: " + stack.peek());
                    else
                        System.out.println("null");

                    break;
                }
                case 2: {
                    // isEmpty
                    System.out.println("empty: " + stack.isEmpty());
                    break;
                }
                case 3: {
                    // isFull
                    System.out.println("Full: " + stack.isFull());
                    break;
                }
                case 4: {
                    // Push
                    System.out.println("Enter your value: ");
                    Object value = sc.next();
                    stack.push(value);
                    System.out.println("Pushed: " + value);
                    break;
                }
                case 5: {
                    // Pop?

                    System.out.println("Pop: " + stack.pop());
                    break;
                }
                case 6: {
                    // ?clear
                    stack.clear();
                    System.out.println("cleaned :)");
                    break;
                }
                case 7: {
                    System.out.println(stack.print());
                    break;
                }

                case 8: {
                    sc.close();
                    System.exit(0);
                    break;

                }
                default:
                    System.out.println("Wrong value!!!");
                    break;
            }
        }
    }
}
