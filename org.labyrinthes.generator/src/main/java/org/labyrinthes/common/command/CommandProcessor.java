package org.labyrinthes.common.command;

import java.util.ArrayList;
import java.util.List;

import org.labyrinthes.common.model.GenerateResult;
import org.labyrinthes.common.model.InputParam;
import org.labyrinthes.common.model.OutputResult;

/**
 * Specific command processor used to manage the lifecyle of the three types of
 * command: InputCommand : used to read or prepare input information for the
 * labyrinth to generate GenerateCommand : used to generate the labyrinth with
 * the input OutputCommand : used to transform the labyrinth into an output
 * format :image, xml, json...
 * 
 * @author flabourot
 *
 */
public class CommandProcessor {

	private InputParam inputParam;
	private GenerateResult generateResult;
	private OutputResult outputResult;

	protected List<Command> list = new ArrayList<Command>();

	public void addCommand(Command command) {
		this.list.add(command);
	}

	public void clear() {
		this.list.clear();
	}

	public void process() {
		inputParam = new InputParam();
		generateResult = new GenerateResult();
		outputResult = new OutputResult();
		for (Command command : list) {
			CommandType type = command.getType();
			switch (type) {
			case Input:
				command.setArg(inputParam);
				break;
			case Output:
				command.setArg(inputParam);
				command.setArg(generateResult);
				command.setArg(outputResult);
				break;
			case Generate:
				command.setArg(inputParam);
				command.setArg(generateResult);
				break;
			default:
				// error
				break;
			}
			command.execute();
		}
	}

	public InputParam getInputParam() {
		return inputParam;
	}

	public GenerateResult getGenerateResult() {
		return generateResult;
	}

	public OutputResult getOutputResult() {
		return outputResult;
	}
	
	
}
