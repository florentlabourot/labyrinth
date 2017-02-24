package org.labyrinthes.generator;

import org.labyrinthes.generator.model.Cell;
import org.labyrinthes.generator.model.Labyrinth;

public abstract class AbstractGenerator {

	/**
	 * Start point of the labyrinth
	 */
	protected Cell start;

	protected int nbWallToOpen;

	public AbstractGenerator() {

	}

	public Labyrinth initTable(int width, int height) {
		Labyrinth ret = new Labyrinth(width, height);
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				ret.createCell(j, i);
			}
		}
		start = defineStartCell(ret);
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
		return ret;
	}

	public abstract boolean openWall(Labyrinth ret);

	/**
	 * Define protected attribute start Cell
	 */
	public abstract Cell defineStartCell(Labyrinth laby);

	public abstract int defineNbWallToOpen(Labyrinth laby);
}
