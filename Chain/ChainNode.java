
package Chain;

class ChainNode {
      // package visible data members
      Object element;
      ChainNode next;

      // package visible constructors
      ChainNode() {}

      ChainNode(Object element) {
            this.element = element;
      }

      ChainNode(Object element, ChainNode next) {
            this.element = element;
            this.next = next;
      }
}