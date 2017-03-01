package org.labyrinthes.common.command;

import org.labyrinthes.common.model.InputParam;

public class InputCommandImpl extends InputCommand {

	private InputParam inputParam;

	public void execute() {
		this.inputParam.put("test", "test");
	}

	@Override
	public void setInputParam(InputParam param) {
		this.inputParam = param;
	}

}
