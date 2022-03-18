package Chain;

public interface GLinearList<G> {
      public boolean isEmpty();

      public int size();

      public G get(int index);

      public int indexOf(G theElement);

      public G remove(int index);

      public G add(int index, G theElement);

      public String toString();
}
