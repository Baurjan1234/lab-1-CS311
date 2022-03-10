
package Chain;

import java.util.Random;
import java.util.Scanner;

public class MyChain extends Chain {
    int count;
    Object[] element;
    Random rand = new Random();

    public void randomNumberAdd(int a) {
        for (int i = 0; i < a; i++)
            this.add(i, rand.nextInt(100));
    }

    public Object[] toArray() {
        element = new Object[size];
        for (int i = 0; i < this.size; i++) {
            element[i] = this.get(i);
        }
        return element;
    }

    public void addRange(Object[] elements) {
        for (int i = 0; i < elements.length; i++) {
            this.add(size, elements[i]);
        }
    }

    public MyChain union(MyChain chain) {
        MyChain union = new MyChain();
        for (int i = 0; i < this.size; i++) {
            if (union.indexOf(this.get(i)) == -1)
                union.add(0, this.get(i));
        }

        for (int i = 0; i < chain.size; i++) {
            if (union.indexOf(chain.get(i)) == -1)
                union.add(0, chain.get(i));
        }
        return union;
    }

    public MyChain intersection(MyChain chain) {
        MyChain intersection = new MyChain();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < chain.size; j++) {
                if (this.get(i).equals(chain.get(j)) && intersection.indexOf(this.get(i)) == -1)
                    intersection.add(0, this.get(i));
            }
        }
        return intersection;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        MyChain my = new MyChain();
        MyChain list;
        System.out.println("ta heden element oruulah ve? Монгол хаха saidn хөбө ");
        System.out.println("ta heden element oruulah ve? Монгол хаха saidn хөбө ");
        int count = sc.nextInt();
        if (count > 0) {
            System.out.println("element: ");
            for (int i = 0; i < count; i++) {
                Object a = sc.next();
                my.add(i, a);
            }
        }
        System.out.println("\n\t1. isEmpty\n\t2. size  \n\t3. get  \n\t4. IndexOf  \n\t5.remove2  \n\t6. add ");
        System.out.println(
                " \n\t7. allElement  \n\t8. toArray  \n\t9. addRange  \n\t10. union  \n\t11. intersection  \n\t12. exit");
        while (true) {
            System.out.println("Enter number: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1: {
                    if (my.isEmpty()) {
                        System.out.println("Empty.");
                    } else
                        System.out.println("Not Empty");
                    break;
                }
                case 2: {
                    System.out.println("Element size :" + my.size());
                    break;
                }
                case 3: {
                    int index;
                    while (true) {
                        System.out.println("element index: ");
                        index = sc.nextInt();
                        if (index < count)
                            break;
                        else
                            System.out.println("index error !!!");
                    }
                    System.out.println(my.get(index));
                    break;
                }
                case 4: {
                    System.out.println("Enter index");
                    int element = sc.nextInt();
                    if (!(my.indexOf(element) == -1))
                        System.out.println(my.indexOf(element));
                    else
                        System.out.println("not element ");
                    break;
                }
                case 5: {
                    int index;
                    while (true) {
                        System.out.println("delete element index: ");
                        index = sc.nextInt();
                        if (index < count)
                            break;
                        else
                            System.out.println("index error!!!");
                    }
                    System.out.println(my.remove(index));
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
                    my.add(index, newElement);
                    System.out.println("success");
                    break;

                }
                case 7: {
                    System.out.println("Your element");
                    System.out.println(my.toString());
                    break;
                }
                case 8: {
                    System.out.println(" convert massive: ");

                    for (int i = 0; i < my.size; i++) {
                        System.out.print(my.toArray()[i] + " ");
                    }
                    System.out.println();
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
                    my.addRange(el);
                    System.out.println(my.toString());
                    break;
                }
                case 10: {
                    int index;
                    list = new MyChain();
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
                        list.add(i, a);
                    }
                    System.out.println("orulsan element :" + list.toString());
                    System.out.println("union: " + my.union(list));
                    break;
                }
                case 11: {
                    int index;
                    list = new MyChain();
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
                        list.add(i, a);
                    }
                    System.out.println("inserted el :" + list.toString());
                    System.out.println("intersection :" + my.intersection(list));
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