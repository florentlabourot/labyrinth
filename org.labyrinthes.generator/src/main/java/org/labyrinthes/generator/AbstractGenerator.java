package org.labyrinthes.generator;

import org.labyrinthes.common.command.GenerateCommand;
import org.labyrinthes.common.model.Cell;
import org.labyrinthes.common.model.GenerateResult;
import org.labyrinthes.common.model.InputParam;
import org.labyrinthes.common.model.Labyrinth;

public abstract class AbstractGenerator extends GenerateCommand {

	/**
	 * Start point of the labyrinth
	 */
	protected Cell start;
	protected Cell end;

	protected int nbWallToOpen;

	protected InputParam inputParam;
	protected GenerateResult generateResult;
	
	public void setInputParam(InputParam input){
		this.inputParam = input;
	}

	public void setGenerateResult(GenerateResult result){
		this.generateResult = result;
	}
	
	public AbstractGenerator() {

	}

	public void execute(){
		Labyrinth labyrinth = generate(inputParam.getWidth(), inputParam.getHeight());
		generateResult.addLabyrinth(labyrinth);
	}
	
	private Labyrinth initTable(int width, int height) {
		Labyrinth ret = new Labyrinth(width, height);
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				ret.createCell(j, i);
			}
		}

		nbWallToOpen = defineNbWallToOpen(ret);
		return ret;
	}

	public Labyrinth generate(int width, int height) {
		Labyrinth ret = initTable(width, height);
		int count = 0;
		int iter = 0;
		while (count < nbWallToOpen) {
			if (openWall(ret)) {
				count++;
			}
			iter++;
		}
		end = defineEndCell(ret);
		start = defineStartCell(ret);
		end.setAsEndCell();
		start.setAsStartCell();
		return ret;
	}

	protected void updateId(final int orig, final int dest, Labyrinth ret) {
		for (int i = 0; i < ret.getHeight(); ++i) {
			for (int j = 0; j < ret.getWidth(); ++j) {
				if (ret.getCell(j, i).getId() == orig) {
					ret.getCell(j, i).setId(dest);
				}
			}
		}
	}

	public abstract boolean openWall(Labyrinth ret);

	/**
	 * Define protected attribute start Cell
	 */
	public abstract Cell defineStartCell(Labyrinth laby);

	public abstract Cell defineEndCell(Labyrinth laby);

	public abstract int defineNbWallToOpen(Labyrinth laby);
}
