package org.labyrinthes.common.model;

import java.util.ArrayList;
import java.util.List;

import org.labyrinthes.common.command.CommandArg;

public class InputParam extends BasicParam implements CommandArg{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -948354318617495688L;
	
	private List<Dimension> list=new ArrayList<Dimension>();
	private int count = 0;
	
	
	public void add (Dimension d){
		this.list.add(d);
	}
	
	public int getNbToGenerate() {
		return this.list.size();
	}
	
	public Dimension getNextDimension (){
		return this.list.get(count++);
	}
	
	public void reset() {
		count = 0;
	}


}
