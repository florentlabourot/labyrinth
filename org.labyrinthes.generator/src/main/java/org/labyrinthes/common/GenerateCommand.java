package org.labyrinthes.common;

import org.labyrinthes.common.model.GenerateResult;
import org.labyrinthes.common.model.InputParam;

public abstract class GenerateCommand implements Command {

	public abstract void setInputParam(InputParam input);

	public abstract void setGenerateResult(GenerateResult result);

	public CommandType getType() {
		return CommandType.Generate;
	}

	public void setArg(CommandArg commandArg) {
		if (commandArg instanceof InputParam) {
			setInputParam((InputParam) commandArg);
		} else if (commandArg instanceof GenerateResult) {
			setGenerateResult((GenerateResult) commandArg);
		}
	}

}
