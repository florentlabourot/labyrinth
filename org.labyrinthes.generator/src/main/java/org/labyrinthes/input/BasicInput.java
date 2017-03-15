package org.labyrinthes.input;

import org.labyrinthes.common.command.InputCommand;
import org.labyrinthes.common.model.InputParam;

public class BasicInput extends InputCommand {

	private InputParam inputParam;
	private int width;
	private int height;

	public BasicInput(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void execute() {
		this.inputParam.setHeight(this.height);
		this.inputParam.setWidth(this.width);
	}

	@Override
	public void setInputParam(InputParam param) {
		this.inputParam = param;
	}

	

}
