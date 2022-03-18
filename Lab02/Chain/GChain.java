package Chain;

public class GChain<G> {

    protected GChainNode<G> firstNode;
    protected int size, count;

    public GChain(int initialCapacity) {

    }

    public GChain(Class<G[]> clazz, int n) {
        size = n;
        count = 0;
    }

    public GChain() {
        this(0);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** @return current number of elements in list */
    public int size() {
        return size;
    }

    void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index = " + index + "  size = " + size);
    }

    public G get(int index) {
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

    public G remove(int index) {
        checkIndex(index);

        G removedElement;
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

    public void add(int index, G theElement) {
        if (index < 0 || index > size)
            // invalid list position
            throw new IndexOutOfBoundsException("index = " + index + "  size = " + size);

        if (index == 0)
            // insert at front
            firstNode = new GChainNode<G>(theElement, firstNode);
        else { // find predecessor of new element
            GChainNode<G> p = firstNode;
            for (int i = 0; i < index - 1; i++)
                p = p.next;

            // insert after p
            p.next = new GChainNode<G>(theElement, p.next);
        }
        size++;
    }

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
            s.delete(s.length() - 2, s.length());
        s.append("]");

        // create equivalent String
        return new String(s);
    }

    public static void main(String[] args) {
        GChain<Object> chain = new GChain<Object>(Object[].class, 10);
        chain.add(0, "kjafls");
        System.out.println(chain.get(0));
        System.out.println();
    }
}