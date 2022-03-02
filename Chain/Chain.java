
package Chain;

import java.util.*;
import java.util.Iterator;

public class Chain implements LinearList {
      // data members
      protected ChainNode firstNode;
      protected int size;

      public Chain(int initialCapacity) {
      }

      public Chain() {
            this(0);
      }

      /** @return true iff list is empty */
      public boolean isEmpty() {
            return size == 0;
      }

      /** @return current number of elements in list */
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
            ChainNode currentNode = firstNode;
            for (int i = 0; i < index; i++)
                  currentNode = currentNode.next;
            return currentNode.element;
      }

      /**
       * @return index of first occurrence of theElement,
       *         return -1 if theElement not in list
       */
      public int indexOf(Object theElement) {
            // search the chain for theElement
            ChainNode currentNode = firstNode;
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

      /**
       * Remove the element with specified index.
       * All elements with higher index have their
       * index reduced by 1.
       * 
       * @throws IndexOutOfBoundsException when
       *                                   index is not between 0 and size - 1
       * @return removed element
       */
      public Object remove(int index) {
            checkIndex(index);

            Object removedElement;
            if (index == 0) // remove first node
            {
                  removedElement = firstNode.element;
                  firstNode = firstNode.next;
            } else { // use q to get to predecessor of desired node
                  ChainNode q = firstNode;
                  for (int i = 0; i < index - 1; i++)
                        q = q.next;

                  removedElement = q.next.element;
                  q.next = q.next.next; // remove desired node
            }
            size--;
            return removedElement;
      }

      /**
       * Insert an element with specified index.
       * All elements with equal or higher index
       * have their index increased by 1.
       * 
       * @throws IndexOutOfBoundsException when
       *                                   index is not between 0 and size
       */
      public void add(int index, Object theElement) {
            if (index < 0 || index > size)
                  // invalid list position
                  throw new IndexOutOfBoundsException("index = " + index + "  size = " + size);

            if (index == 0)
                  // insert at front
                  firstNode = new ChainNode(theElement, firstNode);
            else { // find predecessor of new element
                  ChainNode p = firstNode;
                  for (int i = 0; i < index - 1; i++)
                        p = p.next;

                  // insert after p
                  p.next = new ChainNode(theElement, p.next);
            }
            size++;
      }

      /** convert to a string */
      public String toString() {
            StringBuffer s = new StringBuffer("[");

            // put elements into the buffer
            ChainNode currentNode = firstNode;
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

      /** create and return an iterator */
      public Iterator iterator() {
            return new ChainIterator();
      }

      /** chain iterator */
      private class ChainIterator implements Iterator {
            // data member
            private ChainNode nextNode;

            // constructor
            public ChainIterator() {
                  nextNode = firstNode;
            }

            // methods
            /** @return true iff list has a next element */
            public boolean hasNext() {
                  return nextNode != null;
            }

            /**
             * @return next element in list
             * @throws NoSuchElementException
             *                                when there is no next element
             */
            public Object next() {
                  if (nextNode != null) {
                        Object elementToReturn = nextNode.element;
                        nextNode = nextNode.next;
                        return elementToReturn;
                  } else
                        throw new NoSuchElementException("No next element");
            }

            /** unsupported method */
            public void remove() {
                  throw new UnsupportedOperationException("remove not supported");
            }
      }

}