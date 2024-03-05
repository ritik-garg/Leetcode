/*
 * @lc app=leetcode id=284 lang=java
 *
 * [284] Peeking Iterator
 */

/*
14/14 cases passed (4 ms)
Your runtime beats 64.66 % of java submissions
Your memory usage beats 80.17 % of java submissions (41.9 MB)
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
	Integer peekInteger;

	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
	    if (iterator.hasNext()) {
			peekInteger = iterator.next();
		}
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peekInteger;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer temp = peekInteger;
		if (iterator.hasNext()) {
			peekInteger = iterator.next();
		} else {
			peekInteger = null;
		}
		return temp;
	}
	
	@Override
	public boolean hasNext() {
	    return peekInteger != null || iterator.hasNext();
	}
}
// @lc code=end

