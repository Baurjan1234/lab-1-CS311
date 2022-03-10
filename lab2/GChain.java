package lab2;




public class GChain<G> implements GLineaerList {
      protected GChainNode<G> firstNode;
      protected int size;

      public GChain(int initialCapacity) {
      }

      public GChain() {
            this(0);
      }

      /** @return true iff list is empty */
      public boolean isEmpty() {
            return size == 0;
      }

      public int size() {
            return size;
      }

      /**
       * @throws IndexOutOfBoundsException when
       */
      void checkIndex(int index) {
            if (index < 0 || index >= size)
                  throw new IndexOutOfBoundsException("index = " + index + "  size = " + size);
      }

      /**
       * @return element with specified index
       * @throws IndexOutOfBoundsException when
       *                                   index is not between 0 and size - 1
       */
      public Object get(int index) {
            checkIndex(index);
            // move to desired node
            GChainNode<G> currentNode = firstNode;
            for (int i = 0; i < index; i++)
                  currentNode = currentNode.next;
            return currentNode.element;
      }

 


      public int indexOf(Object theElement) {
            // search the chain for theElement
            GChainNode<G> currentNode = firstNode;
            int index = 0; // index of currentNode
            while (currentNode != null &&
                        !currentNode.element.equals(theElement)) {
                  // move to next node
                  currentNode = currentNode.next;
                  index++;
            }

            // make sure we found matching element
            if (currentNode == null)
                  return -1;
            else
                  return index;
      }

      public Object remove(int index) {
            checkIndex(index);

            Object removedElement;
            if (index == 0) // remove first node
            {
                  removedElement = firstNode.element;
                  firstNode = firstNode.next;
            } else { // use q to get to predecessor of desired node
                  GChainNode<G> q = firstNode;
                  for (int i = 0; i < index - 1; i++)
                        q = q.next;

                  removedElement = q.next.element;
                  q.next = q.next.next; // remove desired node
            }
            size--;
            return removedElement;
      }
      public Boolean addG(int index, G a){
        if(index > 0 || index > size){
            return false;
        }

        if (index == 0){
            firstNode = new GChainNode<G>(a, firstNode);
        }
        else { // find predecessor of new element
            GChainNode<G> p = firstNode;
            for (int i = 0; i < index - 1; i++)
                  p = p.next;

            // insert after p
            p.next =  new GChainNode<G>(a, p.next);
      }
      size++;

          return true;
      }


    //   public G add(int index, G theElement) {
    //         if (index < 0 || index > size)
    //               // invalid list position
    //               throw new IndexOutOfBoundsException("index = " + index + "  size = " + size);

    //         if (index == 0)
    //               // insert at front
    //               firstNode = new GChainNode<G>(theElement, firstNode);
    //         else { // find predecessor of new element
    //               GChainNode<G> p = firstNode;
    //               for (int i = 0; i < index - 1; i++)
    //                     p = p.next;

    //               // insert after p
    //               p.next =  new GChainNode<G>(theElement, p.next);
    //         }
    //         size++;
    //   }

      /** convert to a string */
      public String toString() {
            StringBuffer s = new StringBuffer("[");

            // put elements into the buffer
            GChainNode<G> currentNode = firstNode;
            while (currentNode != null) {
                  if (currentNode.element == null)
                        s.append("null, ");
                  else
                        s.append(currentNode.element.toString() + ", ");
                  currentNode = currentNode.next;
            }
            if (size > 0)
                  s.delete(s.length() - 2, s.length()); // remove last ", "
            s.append("]");

            // create equivalent String
            return new String(s);
      }


    public Boolean add(int index, Object  theElement) {
        return null;
    }



    // private final G array[];
    // Object element[];

    // public GChain(Class<G[]> clazz, int n) {

    //     array = clazz.cast(Array.newInstance(clazz.getComponentType(), n));
    //     size = n;
    //     // count = 0;
    // };

    // public void addRandomNumber(int input) {
    //     for (int i = 0; i < input; i++) {
    //         Random rand = new Random();
    //         this.add(i, rand.nextInt());
    //     }
    // }

    // public Object[] toArray() {
    //     element = new Object[this.size];
    //     for (int i = 0; i < this.size; i++) {
    //         element[i] = this.get(i);
    //     }
    //     return element;
    // }

    // public static void main(String[] args) {
    //     GChain<Object> chain = new GChain<Object>(Object[].class, 5);
        
    //     System.out.println("ta heden element oruulah ve? Монгол хаха saidn хөбө ");
    //     Scanner sc = new Scanner(System.in);
    //     int count = sc.nextInt();
    //     if (count > 0) {
    //         System.out.println("element: ");
    //         for (int i = 0; i < count; i++) {
    //             Object a = sc.next();
    //             chain.add(i, a);
    //         }
    //     }

    //     System.err.println("object printed: " + chain.toArray());
    //     sc.close();
    // }

}
