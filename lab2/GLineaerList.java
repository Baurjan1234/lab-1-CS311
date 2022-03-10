package lab2;

public interface GLineaerList<G> {
    public boolean isEmpty();

    public int size();

    public Object get(int index);

    public int indexOf(Object theElement);

    public Object remove(int index);

    public Boolean add(int index, G theElement);

    public String toString();
}
