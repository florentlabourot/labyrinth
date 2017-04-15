package org.labyrinthes.generator;

import java.util.ArrayList;
import java.util.List;

import org.labyrinthes.common.model.Cell;

public class SearchTree {

	private int nbChoice = 0;
	private int maxLevel = 0;
	private Cell deeperCell = null;
	private List<Cell> solutionWay = new ArrayList<Cell>();

	public List<Cell> getSolutionWay() {
		return solutionWay;
	}

	public int calculateDeepest(final Cell init, final int level, final Cell parent) {
		final List<Cell> list = init.getDirectNeighbours();
		int max = 0;
		for (final Cell cell : list) {
			nbChoice++;
			if (cell != parent) {
				final int tmp = calculateDeepest(cell, level + 1, init);
				if (tmp > max) {
					max = tmp;
					solutionWay.add(cell);
				}
			}
		}
		if (level > maxLevel && init.hasExternal()) {
			maxLevel = level;
			deeperCell = init;
			solutionWay.clear();
		}
		return max + 1;
	}

	public void clear() {
		nbChoice = 0;
		maxLevel = 0;
		deeperCell = null;
		solutionWay.clear();
	}

	public int getNbChoice() {
		return nbChoice;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public Cell getDeeperCell() {
		return deeperCell;
	}

	public void printSolution() {
		for (Cell cell : solutionWay) {
			System.out.println(cell.getX() + "," + cell.getY());
		}
	}

}
