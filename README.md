# Assignment 4: Heaps

Your assignment is to implement a Minimum Binary Heap (just a 
heap, not a priority queue).  We are keeping it simple by making 
a heap element simply be an integer (and that integer is the 
priority number used to order the heap).

This means your heap will always have the smallest integer in the 
heap at any time as the root element.

As with other assignments, you will write code that fits is a 
framework we give you, and you will test your code and convince 
yourself you have it working correctly.

You assignment will be submitted through gradescope and will be 
graded by gradescope as well.


## Structure

This assignment is following our emphasis on abstraction, in that we 
give you a Heap interface and have you write a class MinHeap that 
will implement that interface.  The Heap interface does not specify 
that your code will be a Min Binary Heap, but the implementation
class MinHeap will in fact provide that behavior.

## Task: Implement the methods below in MinHeap.java

Your task is to implement the methods below in MinHeap.java for a min-heap using the instructions
in Heap.java.  You should not modify the code in Heap.java.

> **Hint:** Refer to the slides for examples for some of these operations.  Make sure you 
read Heap.java and MinHeap.java carefully to understand how to implement the functions.

> **Hint:** Remember to skip index 0 when working with your heap array.  It will make some
of the calculations for finding parent and child elements easier.

```
  void insert(int p);
  void delFront();
  int getFront();
  boolean empty();
  int size();
  void clear();
  int[] sort();
  void build (int[] elts, int N); 
```

There is no indication in the heap interface that "getFront" will 
produce the smallest priority (or the largest) in the heap... only 
that it produces the element that (according to the heap discipline) 
is "next" to come out.. the element at the front of the queue, so 
to speak.  When you implement the method "getFront" in your class 
MinHeap, you will for this assignment supply code that does minimum 
heap behavior.

The same applies to delFront, and insert.

These methods are given specific behavior in the Java files in 
our framework.
