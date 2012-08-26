package com.nlogneg.FilterFramework.model.pins;

import java.util.Set;

public interface Pin {
	public long getId();
	public String getName();
	public Set<PinType> getPinTypes();

}
