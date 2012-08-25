package com.nlogneg.FilterFramework.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Specifies the Pin type
 * @author Andrew
 *
 */
public enum PinType {
	INPUT_PIN(1<<0),
	OUTPUT_PIN(1<<1),
	MULTIPLEX_PIN(1<<2);
	
	private final long flag;
	private PinType(long flag){
		this.flag = flag;
	}
	
	/**
	 * Gets the bitfield flag for the enum
	 * @return
	 */
	public final long getFlag(){
		return flag;
	}
	
	/**
	 * Calculates the resulting bitflag of multiple PinTypes
	 * @param enums
	 * @return
	 */
	public static final long getStatusFlags(Iterable<PinType> enums){
		long value = 0;
		for(PinType t : enums){
			value |= t.getFlag();
		}
		return value;
	}
	
	/**
	 * Calculates the PinTypes for a given flag value
	 * @param statusValue
	 * @return
	 */
	public Set<PinType> getEnums(long statusValue){
		HashSet<PinType> enums = new HashSet<>();
		
		for(PinType t : PinType.values()){
			long flagValue = t.getFlag();
			if((flagValue & statusValue) != 0){
				enums.add(t);
			}
		}
		
		return enums;
	}
}
