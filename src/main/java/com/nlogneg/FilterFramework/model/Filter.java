package com.nlogneg.FilterFramework.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Filter, a collection of InputPins and OutputPins
 * @author Andrew
 *
 */
public abstract class Filter {
	private final List<InputPin> inputPins;
	private final List<OutputPin> outputPins;
	
	public Filter(List<InputPin> inputPins, List<OutputPin> outputPins){
		this.inputPins = new ArrayList<>(inputPins);
		this.outputPins = new ArrayList<>(outputPins);
	}
	
	public List<InputPin> getInputPins(){
		return inputPins;
	}
	
	public List<OutputPin> getOutputPins(){
		return outputPins;
	}
}
