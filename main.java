import java.util.Scanner;

class Stack {
    private int count, size;
    private int[] array;

    public Stack(int n) {
        array = new int[n];
        size = n;
        count = 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void push(int value) {
        if (!isFull()) {
            array[count++] = value;
        }
    }

    public int pop() {
        if (!isEmpty())
            return array[--count];
        else
            return -1;
        // throw new InvalidOperationException("Stack empty!");
    }

    public int top() {
        if (!isEmpty())
            return array[count - 1];
        else
            return -1;
        // return default(int);
        // throw new InvalidOperationException("Stack empty!");
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < count; i++)
            s = s + array[i] + "\n";

        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack(10);

        String key = sc.nextLine();
        switch (key) {
            case "isFull": {
                System.out.println("isFull: " + stack.isFull());
                break;
            }
            case "Empty": {
                System.out.println("Empty: " + stack.isEmpty());
                break;
            }

            case "push": {
                System.out.println("stack push number :");
                int pushNumber = sc.nextInt();
                stack.push(pushNumber);
                System.out.println("pushed " + pushNumber);
                break;
            }
            case "pop": {
                System.out.println("pop" + stack.pop());
                break;
            }
            case "print": {
                System.out.println(stack.toString());
                break;
            }
            default:
                break;

        }
    }
}