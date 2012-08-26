package com.nlogneg.FilterFramework.base.filters;

import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

import com.nlogneg.FilterFramework.model.pins.InputPin;
import com.nlogneg.FilterFramework.model.pins.OutputPin;
import com.nlogneg.FilterFramework.model.pins.PinType;

/**
 * Represents a basic file output pin. This pin expects to be guarded by the 
 * Filter that owns it. It is not thread safe.
 * @author Andrew
 *
 */
public class BasicFileOutputPin implements OutputPin<Path>{
	
	private static final String Name = "Basic File Output Pin";
	private static final Set<PinType> PinTypes = new HashSet<PinType>(Arrays.asList(PinType.INPUT_PIN));
	
	private final long id;
	private final List<InputPin<Path, ?>> subscribers = new ArrayList<>();
	private final Queue<Path> buffer = new ArrayDeque<Path>();
	
	public BasicFileOutputPin(){
		Random random = new Random();
		id = random.nextLong();
	}
	
	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getName() {
		return Name;
	}

	@Override
	public Set<PinType> getPinTypes() {
		return PinTypes;
	}

	@Override
	public void subscribe(InputPin<Path, ?> pin) {
		subscribers.add(pin);
	}

	@Override
	public void notifySubscribers() {
		int size = buffer.size();
		for(int i = 0; i < size; i++){
			Path p = buffer.poll();
			for(InputPin<Path, ?> pin : subscribers){
				pin.pushData(p);
			}
		}
	}

	protected void pushPathData(Path path){
		buffer.add(path);
	}
}
