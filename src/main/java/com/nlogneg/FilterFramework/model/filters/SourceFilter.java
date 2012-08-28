package com.nlogneg.FilterFramework.model.filters;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Represents the very first Filter in a FilterGraph. Used as an adapter for
 * raw data (such as a bit stream). 
 * @author Andrew
 *
 * @param <E>
 */
public abstract class SourceFilter<E> extends Filter {

	private Queue<E> buffer = new ConcurrentLinkedQueue<E>();
	
	/**
	 * Pushes data in to the data buffer of this Filter. This can be called 
	 * from multiple threads.
	 * @param e
	 */
	public void pushData(E e){
		buffer.add(e);
	}
}
