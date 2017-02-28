package org.labyrinthes.common;

import java.util.ArrayList;
import java.util.List;

public class CommandProcessor {

	protected List<Command> list = new ArrayList<Command>();
	
	public void addCommand (Command command){
		this.list.add(command);
	}
	
	public void clear (){
		this.list.clear();
	}
	
	public void process(){
		for (Command command : list) {
			command.execute();
		}
	}
}
