package org.labyrinthes.common.command;

/**
 * Command used for Command/Processor pattern
 * 
 * @author flabourot
 *
 */
public interface Command {

	public void execute();

	public CommandType getType();

	public void setArg(CommandArg commandArg);

}
