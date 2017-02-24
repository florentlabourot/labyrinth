package org.labyrinthes.generator;

import org.labyrinthes.generator.model.Cell;
import org.labyrinthes.generator.model.Labyrinth;

public class BasicGenerator extends AbstractGenerator {

	@Override
	public boolean openWall(Labyrinth ret) {
		final int y = (int) (Math.random() * ret.getHeight());
		final int x = (int) (Math.random() * ret.getWidth());
		final int wall = (int) (Math.random() * 4);
		final Cell current = ret.getCell(x, y); 
		//if (! current.)
		return false;
	}

	@Override
	public Cell defineStartCell(Labyrinth laby) {
		return laby.getCell(0, 0);
	}

	@Override
	public int defineNbWallToOpen(Labyrinth laby) {
		return (laby.getHeight() * laby.getWidth()) - 1;
	}

}
