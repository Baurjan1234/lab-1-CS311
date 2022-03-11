package lab2;

import java.util.Scanner;

public class GChain<G> {

      
      public GChainNode<G> firstNode;
      private int size = 0;

      public GChain() {}

      public boolean isEmpty() {
            return size == 0;
      }

      public int size() {
            return size;
      }

      void checkIndex(int index) {
            if (index < 0 || index >= size)
                  throw new IndexOutOfBoundsException("index = " + index + "  size = " + size);
      }

      public G get(int index) {
            checkIndex(index);
            GChainNode<G> currentNode = firstNode;
            for (int i = 0; i < index; i++)
                  currentNode = currentNode.next;
            return currentNode.element;
      }

      public int indexOf(G theElement) {
            GChainNode<G> currentNode = firstNode;
            int index = 0;
            while (currentNode != null &&
                        !currentNode.element.equals(theElement)) {
                  currentNode = currentNode.next;
                  index++;
            }
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
            } else {
                  GChainNode<G> q = firstNode;
                  for (int i = 0; i < index - 1; i++)
                        q = q.next;

                  removedElement = q.next.element;
                  q.next = q.next.next;
            }
            size--;
            return removedElement;
      }

      public void addRange(G[] elements) {
            for (int i = 0; i < elements.length; i++) {
                  this.addG(size, elements[i]);
            }
      }

      public void addG(int index, G theElement) {

            if (index < 0 || index > size)
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

      public GChain<G> union(GChain<G> chain) {
            GChain<G> union = new GChain<>();
            for (int i = 0; i < this.size; i++) {
                  if (union.indexOf(this.get(i)) == -1)
                        union.addG(0, this.get(i));
            }

            for (int i = 0; i < chain.size; i++) {
                  if (union.indexOf(chain.get(i)) == -1)
                        union.addG(0, chain.get(i));
            }
            return union;
      }

      public GChain<G> intersection(GChain<G> chain) {
            GChain<G> intersection = new GChain<G>();
            for (int i = 0; i < this.size; i++) {
                  for (int j = 0; j < chain.size; j++) {
                        if (this.get(i).equals(chain.get(j)) && intersection.indexOf(this.get(i)) == -1)
                              intersection.addG(0, this.get(i));
                  }
            }
            return intersection;
      }

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

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            GChain<Object> gchain = new GChain<Object>();

            GChain<Object> list;
            for (int i = 0; i < gchain.size; i++) {
                  System.out.println(gchain.get(i));
            }
            int count = sc.nextInt();
            if (count > 0) {
                  System.out.println("element: ");
                  for (int i = 0; i < count; i++) {
                        Object a = sc.next();
                        gchain.addG(i, a);
                  }
            }
            System.out.println("songoltoo oruul: ");
            System.out.println("\n\t1. isEmpty\n\t2. size  \n\t3. get  \n\t4. IndexOf  \n\t5.remove2  \n\t6. add ");
            System.out.println(
                        " \n\t7. allElement    \n\t9. addRange  \n\t10. union  \n\t11. intersection  \n\t12. exit");
            while (true) {
                  System.out.println("Enter number: ");
                  int choose = sc.nextInt();
                  switch (choose) {
                        case 1: {
                              if (gchain.isEmpty()) {
                                    System.out.println("Empty.");
                              } else
                                    System.out.println("Not Empty");
                              break;
                        }
                        case 2: {
                              System.out.println("Element size :" + gchain.size());
                              break;
                        }
                        case 3: {
                              int index;
                              System.out.println("element index: ");
                              index = sc.nextInt();
                              if (index > gchain.size - 1) {
                                    System.out.println("index error !!!");
                                    break;
                              }
                              System.out.println(gchain.get(index));
                              break;
                        }
                        case 4: {
                              System.out.println("Enter index");
                              Object element = sc.next();
                              if (!(gchain.indexOf(element) == -1))
                                    System.out.println(gchain.indexOf(element));
                              else
                                    System.out.println("not element ");
                              break;
                        }
                        case 5: {
                              int index;
                              System.out.println("delete element index: ");
                              while (true) {
                                    index = sc.nextInt();
                                    if (index < count)
                                          break;
                                    else
                                          System.out.println("index error!!!");
                              }
                              System.out.println(gchain.remove(index));
                        }
                        case 6: {
                              int index;
                              while (true) {
                                    System.out.println("chain add index number: ");
                                    index = sc.nextInt();
                                    if (index <= count)
                                          break;
                                    else
                                          System.out.println("error!!!");
                              }

                              System.out.println("Enter element: ");
                              int newElement = sc.nextInt();
                              gchain.addG(index, newElement);
                              System.out.println("success");
                              break;

                        }
                        case 7: {
                              System.out.println("Your element");
                              System.out.println(gchain.toString());
                              break;
                        }

                        case 9: {
                              System.out.println("element number :");
                              int index;
                              while (true) {
                                    System.out.println("ta heden element oruulah ve?");
                                    index = sc.nextInt();
                                    if (index > 0)
                                          break;
                                    else
                                          System.out.println("index error!!");
                              }
                              Object[] el = new Object[index];
                              System.out.println("elements: ");
                              for (int i = 0; i < index; i++) {
                                    el[i] = sc.next();
                              }
                              gchain.addRange(el);
                              System.out.println(gchain.toString());
                              break;
                        }
                        case 10: {
                              int index;
                              list = new GChain<Object>();
                              while (true) {
                                    System.out.println("enter element number: ");
                                    index = sc.nextInt();
                                    if (index > 0)
                                          break;
                                    else
                                          System.out.println("error");
                              }
                              System.out.println("enter element: ");
                              for (int i = 0; i < index; i++) {
                                    Object a = sc.next();
                                    list.addG(i, a);
                              }
                              System.out.println("orulsan element :" + list.toString());
                              System.out.println("union: " + gchain.union(list));
                              break;
                        }
                        case 11: {
                              int index;
                              list = new GChain<Object>();
                              while (true) {
                                    System.out.println("element number: ");
                                    index = sc.nextInt();
                                    if (index > 0)
                                          break;
                                    else
                                          System.out.println("error");
                              }
                              System.out.println("insert elements");
                              for (int i = 0; i < index; i++) {
                                    Object a = sc.next();
                                    list.addG(i, a);
                              }
                              System.out.println("inserted el :" + list.toString());
                              System.out.println("intersection :" + gchain.intersection(list));
                              break;
                        }
                        case 12: {
                              sc.close();
                              System.exit(1);
                              break;
                        }
                        default: {
                              System.out.println("Wrong number");
                              break;
                        }
                  }
            }
      }
}