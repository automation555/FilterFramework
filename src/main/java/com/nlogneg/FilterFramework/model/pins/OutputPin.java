package com.nlogneg.FilterFramework.model.pins;

/**
 * Represents a Pin that pushes data out.
 * @author Andrew
 *
 * @param <E>
 */
public interface OutputPin<E> extends Pin{
	/**
	 * Meant to be called by the InputPin whenever it wants to subscribe
	 * to updates.
	 * @param pin
	 */
	public void subscribe(InputPin<E, ?> pin);
	
	/**
	 * This method pushes new data to all subscribers
	 */
	public void notifySubscribers();
	
	/**
	 * Gets the class for type E
	 * @return
	 */
	public Class<E> getPinDataType();
}
