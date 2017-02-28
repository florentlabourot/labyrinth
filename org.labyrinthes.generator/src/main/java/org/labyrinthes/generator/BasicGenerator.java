package org.labyrinthes.generator;

import org.labyrinthes.common.model.Cell;
import org.labyrinthes.common.model.Direction;
import org.labyrinthes.common.model.Labyrinth;

public class BasicGenerator extends AbstractGenerator {

	@Override
	public boolean openWall(Labyrinth ret) {
		final int y = (int) (Math.random() * ret.getHeight());
		final int x = (int) (Math.random() * ret.getWidth());
		int rand = (int) (Math.random() * Direction.values().length);
		final Direction wall = Direction.values()[rand];
		final Cell current = ret.getCell(x, y);
		
		Cell neighbour = null;
		switch (wall) {
		case North: {
			if (current.isNorth() || current.isNorthFixed()) {
				return false;
			}
			neighbour = ret.getCell(x, y - 1);
			if (neighbour.getId() == current.getId()) {
				return false;
			}
			neighbour.setSouth(true);
			current.setNorth(true);
			break;
		}
		case South: {
			if (current.isSouth() || current.isSouthFixed()) {
				return false;
			}
			neighbour = ret.getCell(x, y + 1);
			if (neighbour.getId() == current.getId()) {
				return false;
			}
			neighbour.setNorth(true);
			current.setSouth(true);
			break;
		}
		case West: {
			if (current.isWest() || current.isWestFixed()) {
				return false;
			}
			neighbour = ret.getCell(x - 1, y);
			if (neighbour.getId() == current.getId()) {
				return false;
			}
			neighbour.setEast(true);
			current.setWest(true);
			break;
		}
		case East: {
			if (current.isEast() || current.isEastFixed()) {
				return false;
			}
			neighbour = ret.getCell(x + 1, y);
			if (neighbour.getId() == current.getId()) {
				return false;
			}
			neighbour.setWest(true);
			current.setEast(true);
			break;
		}
		default:
			return false;
		}
		current.addDirectNeighbour(neighbour);
		neighbour.addDirectNeighbour(current);
		updateId(neighbour.getId(), current.getId(), ret);
		return true;
	}

	@Override
	public Cell defineStartCell(Labyrinth laby) {
		return laby.getCell(0, 0);
	}

	@Override
	public Cell defineEndCell(Labyrinth laby) {
		return laby.getCell(laby.getWidth() - 1, laby.getHeight() - 1);
	}

	@Override
	public int defineNbWallToOpen(Labyrinth laby) {
		return (laby.getHeight() * laby.getWidth()) - 1;
	}

}
