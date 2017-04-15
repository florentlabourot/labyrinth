package org.labyrinthes.output;

import java.io.File;

import org.labyrinthes.common.command.OutputCommand;
import org.labyrinthes.common.model.Constants;
import org.labyrinthes.common.model.GenerateResult;
import org.labyrinthes.common.model.InputParam;
import org.labyrinthes.common.model.OutputResult;

public abstract class AbstractOutputCommand extends OutputCommand {

	protected InputParam inputParam;
	protected GenerateResult generateResult;
	protected OutputResult outputResult;

	protected String getOuputDir() {
		String output = "";
		if (inputParam.containsKey(Constants.OUTPUT)) {
			output = (String) inputParam.get(Constants.OUTPUT);
			String level = (String) inputParam.get(Constants.DIFFICULTY);
			StringBuffer tmp = new StringBuffer(level);
			tmp.append("/").append(output);
			File f = new File(tmp.toString());
			if (!f.exists()) {
				f.mkdirs();
			}
			return tmp.toString();
		}
		return "";
	}

	@Override
	public void setInputParam(InputParam input) {
		this.inputParam = input;
	}

	@Override
	public void setGenerateResult(GenerateResult generateResult) {
		this.generateResult = generateResult;
	}

	@Override
	public void setOutputResult(OutputResult outputResult) {
		this.outputResult = outputResult;

	}
}
