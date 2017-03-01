package org.labyrinthes.common.command;

import org.labyrinthes.common.model.InputParam;

public abstract class InputCommand implements Command {

	public abstract void setInputParam(InputParam param);

	public CommandType getType() {
		return CommandType.Input;
	}

	public void setArg(CommandArg commandArg) {
		if (commandArg instanceof InputParam) {
			setInputParam((InputParam) commandArg);
		}
	}
	

}
