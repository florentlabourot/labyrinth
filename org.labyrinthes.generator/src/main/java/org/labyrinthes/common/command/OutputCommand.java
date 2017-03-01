package org.labyrinthes.common.command;

import org.labyrinthes.common.model.GenerateResult;
import org.labyrinthes.common.model.InputParam;
import org.labyrinthes.common.model.OutputResult;

public abstract class OutputCommand implements Command {

	public abstract void setInputParam(InputParam input);

	public abstract void setGenerateResult(GenerateResult generateResult);

	public abstract void setOutputResult(OutputResult outputResult);

	public CommandType getType() {
		return CommandType.Output;
	}

	public void setArg(CommandArg commandArg) {
		if (commandArg instanceof InputParam) {
			setInputParam((InputParam) commandArg);
		} else if (commandArg instanceof GenerateResult) {
			setGenerateResult((GenerateResult) commandArg);
		}
	}
}
