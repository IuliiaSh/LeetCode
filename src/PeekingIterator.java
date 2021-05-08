import java.util.Iterator;

public class PeekingIterator {
    int next;
    Iterator<Integer> iterator;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iterator = iterator;
        if (iterator.hasNext()) {
            next = iterator.next();
        } else {
            next = 0;
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
        int temp = next;
        if (iterator.hasNext()) {
            next = iterator.next();
        } else {
            next = 0;
        }
        return temp;
	}
	
	public boolean hasNext() {
	    return next != 0;
	}
}
