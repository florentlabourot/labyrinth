package org.labyrinthes.common.command;

import org.labyrinthes.common.model.GenerateResult;
import org.labyrinthes.common.model.InputParam;

public class GenerateCommandImpl extends GenerateCommand {

	private InputParam inputParam;
	private GenerateResult generateResult;

	public void execute() {
		generateResult.setState(5);
	}

	@Override
	public void setInputParam(InputParam input) {
		this.inputParam = input;

	}

	@Override
	public void setGenerateResult(GenerateResult result) {
		this.generateResult = result;
	}

}
