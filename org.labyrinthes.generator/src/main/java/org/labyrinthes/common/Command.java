package org.labyrinthes.common;

/**
 * Command used for Command/Processor pattern
 * 
 * @author flabourot
 *
 */
public interface Command {

	public void execute();
	
	public CommandType getType();
}
