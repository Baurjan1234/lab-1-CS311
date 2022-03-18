package Stack;

/// <summary>
///
/// </summary>
public class Stack {
      private int size, count;
      private int[] array;

      public Stack(int n) {
            array = new int[n];
            size = n;
            count = 0;
      }

      public Boolean isEmpty() {
            return count == 0;
      }

      public Boolean isFull() {
            return count == size;
      }

      public void push(int value) {
            if (!isFull())
                  array[count++] = value;
      }

      public int pop() {
            if (!isEmpty())
                  return array[--count];
            else
                  return 0;// throw new InvalidOperationException("Stack is empty!");
      }

      public int peek() {
            if (!isEmpty())
                  return array[count - 1];
            else
                  return 0;// throw new InvalidOperationException("Stack is empty!");
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

}
