package org.labyrinthes.common.model;

import java.io.PrintStream;

public class Labyrinth {
	/**
	 * Definition of a labyrinth
	 */
	protected final int height;
	protected final int width;
	protected final Cell[][] table;

	protected int maxToOpen;

	/**
	 * Unique constructor to have a labyrinth instance
	 * 
	 * @param width
	 *            of the labyrinth
	 * @param height
	 *            of the labyrinth
	 */
	public Labyrinth(final int width, final int height) {
		this.width = width;
		this.height = height;
		table = new Cell[height][width];

	}

	public int getMaxToOpen() {
		return maxToOpen;
	}

	public void setMaxToOpen(int maxToOpen) {
		this.maxToOpen = maxToOpen;
	}

	/**
	 * 
	 * @return height of the labyrinth
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 
	 * @return width of the labyrinth
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @return table containing each cell of the layrinth
	 */
	public Cell[][] getTable() {
		return table;
	}

	public boolean createCell(int x, int y) {
		boolean valid = false;
		if (x >= 0 && x < this.width && y >= 0 && y < this.height) {
			Cell cell = new Cell(x, y, y * width + x);
			table[y][x] = cell;
			if (y == 0) {
				cell.setNorthFixed(true);
			}
			if (x == 0) {
				cell.setWestFixed(true);
			}
			if (y == this.height - 1) {
				cell.setSouthFixed(true);
			}
			if (x == this.width - 1) {
				cell.setEastFixed(true);
			}
			valid = true;
		}
		return valid;
	}
	
	public Cell getCell(int x, int y){
		return table[y][x];
	}

	/**
	 * Display the labyrinth representation on an PrintStream output
	 * 
	 * @param out
	 */
	public void print(PrintStream out) {
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				out.print(table[i][j].getId() + " ");
			}
			out.println("");
		}
	}
}
