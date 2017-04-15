package org.labyrinthes.input;



import org.labyrinthes.common.command.InputCommand;
import org.labyrinthes.common.model.Dimension;
import org.labyrinthes.common.model.InputParam;

public class BasicInput extends InputCommand {

	private InputParam inputParam;
	private int width;
	private int height;
	private int nb;

	public BasicInput(int width, int height, int nb) {
		this.width = width;
		this.height = height;
		this.nb = nb;
	}

	public void execute() {
		Dimension dimension = new Dimension(this.width, this.height);
		this.inputParam.add(dimension);
	}

	@Override
	public void setInputParam(InputParam param) {
		this.inputParam = param;
	}

	

}
