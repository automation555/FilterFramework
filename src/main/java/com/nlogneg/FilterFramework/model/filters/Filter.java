package com.nlogneg.FilterFramework.model.filters;

import java.util.List;

import com.nlogneg.FilterFramework.model.pins.InputPin;
import com.nlogneg.FilterFramework.model.pins.OutputPin;

/**
 * Represents a Filter, a collection of InputPins and OutputPins
 * @author Andrew
 *
 */
public abstract class Filter {
	protected final List<InputPin> inputPins;
	protected final List<OutputPin> outputPins;
	
	protected Filter(List<InputPin> inputPins, List<OutputPin> outputPins){
		this.inputPins = inputPins;
		this.outputPins = outputPins;
	}
	
	public Iterable<InputPin> getInputPins(){
		return inputPins;
	}
	
	public Iterable<OutputPin> getOutputPins(){
		return outputPins;
	}
	
	public void flushOutputPins(){
		for(OutputPin o : outputPins){
			o.notifySubscribers();
		}
	}
}
