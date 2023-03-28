package a4;

import java.util.Arrays;
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
    //Hint: remember to update size.  Also, remember that we skip index 0 in the array.
    /*Your code here */

    if (size == max) {
      return;
    }
    int index = size + 1;
    for(this.elts[0] = p; p < this.elts[index/2]; index/=2) {
      this.elts[index] = this.elts[index/2];
    }

    this.elts[index] = p;
  }
  
  public void delFront(){
    /*Your code here */
    int index = 1;
    this.elts[index] = this.elts[size - 1];
    percolateDown(index);
  }
  
  public int getFront() throws IllegalStateException {
    //Return the element at the front (i.e., the smallest) element in the min-heap.
    //If the min-heap has no elements, throw an IllegalStateException.
    /*Your code here */

    if (empty()) {
      throw new IllegalStateException(); //Dummy return statement.  Remove (or move elsewhere) when you implement!
    } else {
      return elts[1];
    }
  }
  
  public boolean empty( ) {
    /*Your code here */
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  public int size() {
    /*Your code here */
    return size;
  }
  
  public void clear() { 
    /*Your code here */
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

    for(int index = size / 2; index > 0; index--) {
      percolateDown(index);
    }
  }

  private void percolateDown(int index) {
    int temp = this.elts[index];
    int child;

    for( ; index * 2 <= size; index = child) {
      child = index * 2;

      if(child != size && this.elts[child + 1] < this.elts[child]) {
        child++;
      }

      if(this.elts[child] < temp) {
        this.elts[index] = this.elts[child];
      } else {
        break;
      }
    }

    this.elts[index] = temp;
  }
  public int[] sort() {
    // Hint: the smallest element will go in slot 0
    /*Your code here */
    int originalSize = size;
    int[] sorted = new int[originalSize];
    int[] temp = elts.clone();

    for(int i = 0; i < originalSize; i++) {
      sorted[i] = getFront();
      delFront();
    }
    size = originalSize;
    this.elts = temp;
    return sorted;
  }

}
