package com.nlogneg.FilterFramework.base.filters;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.nlogneg.FilterFramework.model.filters.SourceFilter;

public class FileSourceFilter extends SourceFilter<Path>{

	private final Path path;
	
	public FileSourceFilter(Path path) {
		super(null);
		this.path = path;
	}
	
	public FileSourceFilter(URI uri){
		this(Paths.get(uri));
	}
}
