package a4;

public class MinHeap implements Heap {

  private int size = 0; // number of elements currently in the heap
  private int[] elts;   // heap array
  private int max;      // array declared size

  // ================================================
  // constructors
  // ================================================

  public MinHeap(int umax) { // user defined heap size
    this.max = umax;
    this.elts = new int[umax];
  }
  public MinHeap( ) { // default heap size is 100
    this.max = 100;
    this.elts = new int[100];
  }

  //==================================================
  // methods we need to grade
  //==================================================

  public int[] getArray() { // do not change this method
    return this.elts;
  }

  //=========================================================
  // public methods -- Implement these for the assignment.
  // Note that we want a Min Heap... so the operations
  // getFront and delFront and insert have to compare
  // for min being at the root
  //=========================================================


  public void insert(int p){
    // Sets the hole to be the last position in the binary heap
    int hole = ++size;

    // Uses percolate up to find the correct position in the heap
    // Compares the value with its parent through hole / 2
    /* Sets the zero index (which is not part of the heap) to the inserted value
    so if the inserted value is minimum value in the heap the for loop
    will break as the inserted value cannot be less than itself
     */
    for(this.elts[0] = p; p < this.elts[hole / 2]; hole /= 2) {
      // While the value is less than the parent and
      this.elts[hole] = this.elts[hole  / 2];
    }

    this.elts[hole] = p;
  }

  public void delFront(){
    int hole = 1;
    this.elts[hole] = this.elts[size--];

    percolateDown(hole);
  }

  public int getFront() throws IllegalStateException {
    //Return the element at the front (i.e., the smallest) element in the min-heap.
    //If the min-heap has no elements, throw an IllegalStateException.
    /*Your code here */
    if(size == 0) {
      throw new IllegalStateException();
    }

    return elts[1];
  }

  public boolean empty() {
    return size == 0;
  }

  public int size() {
    /*Your code here */
    return size;
  }

  public void clear() {
    size = 0;
  }

  public void build (int[] e, int ne) {
    //Hint: remember to skip slot 0 in the heap array.
    /* Your code here */
    clear();
    for(int i = 0; i < ne; i++) {
      this.elts[i + 1] = e[i];
      size++;
    }

    // Set our hole to size / 2, so we start at the first node that has a child
    for(int hole = size / 2; hole > 0; hole--) {
      percolateDown(hole);
    }
  }

  private void percolateDown(int hole) {
    // Saves the value to a temp value as we may write over this node
    int temp = this.elts[hole];
    // Initializes a child variable that will be used to hold child index
    int child;

    // Hole * 2 ensures that we aren't going to access a child that does not exist
    for( ; hole * 2 <= size; hole = child) {
      // Gives us the left child of the current element
      child = hole * 2;

      // Checks if there is a possibility of a right child and if there is then check if the right is smaller
      // If smaller increment the child by one because that's how an array binary heap calculates its children
      if(child != size && this.elts[child + 1] < this.elts[child]) {
        child++;
      }

      // Check if the smallest children is less than our value we are percolating down
      if(this.elts[child] < temp) {
        // If smaller set the hole position to the child, while still keeping the original value in the temp variable
        this.elts[hole] = this.elts[child];
      } else {
        // If greater than break the loop as there is no possibility of percolating down as we started at the first node with a child
        break;
      }
    }

    // Finally set our final position, where the value belongs according to the heap-order property, to the original value stored in temp
    this.elts[hole] = temp;
  }

  public int[] sort() {
    int prevSize = size;
    int[] temp = elts.clone();
    int[] retArr = new int[prevSize];

    for(int i = 0; i < prevSize; i++) {
      retArr[i] = getFront();
      delFront();
    }
    size = prevSize;
    this.elts = temp;
    return retArr;// Dummy return statement.  Remove (or move elsewhere) when you implement!
  }

}