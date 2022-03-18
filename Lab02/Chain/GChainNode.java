package Chain;

public class GChainNode<G> {
      // package visible data members
      G element;
      GChainNode<G> next;

      GChainNode() {
      }

      GChainNode(G element) {
            this.element = element;
      }

      GChainNode(G element, GChainNode<G> next) {
            this.element = element;
            this.next = next;
      }
}