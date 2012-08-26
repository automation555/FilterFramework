package com.nlogneg.FilterFramework.model.filters;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.nlogneg.FilterFramework.model.pins.OutputPin;

/**
 * Represents the very first Filter in a FilterGraph. Used as an adapter for
 * raw data (such as a bit stream). 
 * @author Andrew
 *
 * @param <E>
 */
public abstract class SourceFilter<E> extends Filter {

	private Queue<E> buffer = new ConcurrentLinkedQueue<E>();
	
	protected SourceFilter(List<OutputPin> outputPins) {
		super(null, outputPins);
	}
	
	/**
	 * Pushes data into the data-buffer. This can be called from multiple threads.
	 * @param e
	 */
	public void pushData(E e){
		buffer.add(e);
	}
}
