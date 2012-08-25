package com.nlogneg.FilterFramework.model;

import java.util.Queue;

public interface InputPin<E, T> extends Pin{
	/**
	 * This method attempts to connect an OutputPin to the InputPin. 
	 * @param outputPin
	 * @return Whether or not the method was able to accept the OutputPin
	 */
	public boolean acceptPin(OutputPin<E> outputPin);
	
	/**
	 * Meant to be called by the OutputPin to push data whenever an update comes
	 * in.
	 * @param e
	 */
	public void pushData(E e);
	
	/**
	 * This function is meant to be used by the Filter class to set where the
	 * input data is meant to be stored. As the InputPin gets data from some other
	 * OutputPin, it will write to the buffer
	 * @param buffer
	 * @return
	 */
	public boolean setBuffer(Queue<T> buffer);
	/**
	 * Gets the class for type E
	 * @return
	 */
	public Class<E> getPinDataType();
}
