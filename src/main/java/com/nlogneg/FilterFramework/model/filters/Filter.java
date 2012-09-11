package com.nlogneg.FilterFramework.model.filters;

import java.util.ArrayList;
import java.util.List;

import com.nlogneg.FilterFramework.model.pins.InputPin;
import com.nlogneg.FilterFramework.model.pins.OutputPin;

/**
 * Represents a Filter, a collection of InputPins and OutputPins
 * @author Andrew
 *
 */
public abstract class Filter {
	protected List<InputPin> inputPins = new ArrayList<InputPin>();
	protected List<OutputPin> outputPins = new ArrayList<OutputPin>();
	
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
	
	public abstract Iterable<FilterType> getFilterTypes();
}
