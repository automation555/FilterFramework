package com.nlogneg.FilterFramework.base.filters;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.nlogneg.FilterFramework.exceptions.CannotFlushOutputPinException;
import com.nlogneg.FilterFramework.model.filters.SourceFilter;

/**
 * A basic one-time use Filter that takes a Path (which represents a file) and
 * pushes it to a BasicFileOutputPin. 
 * @author Andrew
 *
 */
public class FileSourceFilter extends SourceFilter<Path>{

	private final Path path;
	private final BasicFileOutputPin outputPin;
	private volatile boolean hasPushed;

	public FileSourceFilter(Path path){
		this.path = path;
		hasPushed = false;
		outputPin = new BasicFileOutputPin();
		outputPins.add(outputPin);
	}

	public FileSourceFilter(URI uri){
		this(Paths.get(uri));
	}

	/**
	 * Flushes the output pin with the Path that this Filter was constructed with.
	 * @throws CannotFlushOutputPinException When this Filter has already flushed
	 * the output pin
	 */
	public void flushOutputPin() throws CannotFlushOutputPinException{
		if(hasPushed){
			throw new CannotFlushOutputPinException("FileSourceFilter has already flushed the Output Pin");
		}
		hasPushed = true;
		outputPin.pushPathData(path);
		outputPin.notifySubscribers();
	}
}
