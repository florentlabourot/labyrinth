package org.labyrinthes.input;

import org.labyrinthes.common.command.InputCommand;
import org.labyrinthes.common.model.Constants;
import org.labyrinthes.common.model.Difficulty;
import org.labyrinthes.common.model.Dimension;
import org.labyrinthes.common.model.InputParam;

public class LevelInput extends InputCommand {

	private InputParam inputParam;
	private Difficulty difficulty;
	private int nb;
	private String outputFolder;
	private String color;
	private String colorShadow;

	public LevelInput(Difficulty difficulty, int nb, String outputFolder) {
		this.difficulty = difficulty;
		this.nb = nb;
		this.outputFolder = outputFolder;
	}
	
	public LevelInput(Difficulty difficulty, int nb, String outputFolder, String color, String colorShadow) {
		this.difficulty = difficulty;
		this.nb = nb;
		this.outputFolder = outputFolder;
		this.color = color;
		this.colorShadow = colorShadow;
	}

	public void execute() {
		int maxcell = 0;
		Dimension min = null;
		Dimension max = null;
		inputParam.put(Constants.DIFFICULTY, difficulty.toString());
		if (color != null && colorShadow != null){
			inputParam.put(Constants.COLOR, color);
			inputParam.put(Constants.COLOR_SHADOW, colorShadow);
		}
		switch (this.difficulty) {
		case easy:
			maxcell = 50;
			min = new Dimension (5,5);
			max = new Dimension (7,9);
			break;
		case medium:
			maxcell = 200;
			min = new Dimension (8,8);
			max = new Dimension (14,16);
			break;
		case hard:
			maxcell = 420;
			min = new Dimension (14,14);
			max = new Dimension (20,22);
			break;
		case very_hard:
			maxcell = 2000;
			min = new Dimension (21,21);
			max = new Dimension (40,40);
			break;
		default:
			break;
		}
		for (int i = 0; i < nb; ++i) {
			gen(maxcell, min, max);
		}
		inputParam.put(Constants.OUTPUT, outputFolder);
	}

	private void gen(int max_cell, Dimension min, Dimension max) {
		int widthRange = max.getWidth() - min.getWidth();
		int heightRange = max.getHeight() - min.getHeight();
		Dimension dim = null;
		boolean valid = false;
		while (!valid) {
			int width = min.getWidth() + (int) (Math.random() * widthRange);
			int height = min.getHeight() + (int) (Math.random() * heightRange);
			if ((width * height) < max_cell) {
				valid = true;
				dim = new Dimension(width, height);
			}
		}
		if (dim != null) {
			this.inputParam.add(dim);
		}
	}

	@Override
	public void setInputParam(InputParam param) {
		// TODO Auto-generated method stub
		this.inputParam = param;
	}

}
