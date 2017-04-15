package org.labyrinthes.generator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.labyrinthes.common.command.GenerateCommand;
import org.labyrinthes.common.model.GenerateResult;
import org.labyrinthes.common.model.InputParam;
import org.labyrinthes.common.model.Labyrinth;

public class BasicNameGenerator extends GenerateCommand {

	private InputParam inputParam;
	private GenerateResult generateResult;
	private Map<String, Integer> lastCount = new HashMap<String, Integer>();

	public void execute() {
		List<Labyrinth> list = generateResult.getLabyrinths();
		for (Labyrinth labyrinth : list) {
			String key = labyrinth.getWidth() + "x" + labyrinth.getHeight();
			Integer lc = lastCount.get(key);
			if (lc == null) {
				lc = new Integer(1);
			} else {
				lc++;
			}
			lastCount.put(key, lc);
			labyrinth.setName(key + "-" + lc.toString());
		}
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
