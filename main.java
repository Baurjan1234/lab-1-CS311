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
    }

    public int top() {
        if (!isEmpty())
            return array[count - 1];
        else
            return -1;
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
        System.out.println("Baurjan Gal-Erdene\nLab1");
        System.out.println("\tisFull\n\tEmpty\n\tPush\n\tPop\n\tPrint\n\tExit ");

        while (true) {
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

                case "Push": {
                    System.out.println("stack push number :");
                    int pushNumber = sc.nextInt();
                    stack.push(pushNumber);
                    System.out.println("pushed " + pushNumber);
                    break;
                }
                case "Pop": {
                    System.out.println("pop:" + stack.pop());
                    break;
                }
                case "Print": {
                    System.out.println(stack.toString());
                    break;
                }
                default: {
                    sc.close();
                    System.exit(1);
                    break;
                }

            }
        }
    }
}