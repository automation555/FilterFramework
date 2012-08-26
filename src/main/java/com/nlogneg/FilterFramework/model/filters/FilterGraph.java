package com.nlogneg.FilterFramework.model.filters;

import java.util.HashSet;
import java.util.Set;


/**
 * Represents several connected Filters. The FilterGraph could potentially 
 * have multiple parallel chains of Filters.
 * @author Andrew
 *
 */
public class FilterGraph {
	private class Node{
		private Set<Node> neighbors = new HashSet<Node>();
		private Filter vertex;
		
		public Node(Filter vertex){
			this.vertex = vertex;
		}
	}
	
	private Set<Node> nodes = new HashSet<Node>();
	private final Node rootNode;
	
	public FilterGraph(Filter filter){
		rootNode = new Node(filter);
	}
	
	public Filter getRootFilter(){
		return rootNode.vertex;
	}
}
