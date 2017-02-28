package org.labyrinthes.generator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is representation of a labyrinth cell It is a square with four
 * existing or not walls
 * 
 * @author flabourot
 *
 */
public class Cell {
	/**
	 * Position in the labyrinth
	 */
	private int x;
	private int y;
	private int id;

	/**
	 * wall in each side of the cell
	 */
	private boolean south = false;
	private boolean east = false;
	private boolean west = false;
	private boolean north = false;
	private boolean southFixed = false;
	private boolean eastFixed = false;
	private boolean westFixed = false;
	private boolean northFixed = false;

	private boolean used = false;

	/**
	 * List of the direct neighbour cells
	 */
	private final List<Cell> directNeighbours = new ArrayList<Cell>();

	public Cell(final int x, final int y, final int id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isSouth() {
		return south;
	}

	public void setSouth(boolean south) {
		this.south = south;
	}

	public boolean isEast() {
		return east;
	}

	public void setEast(boolean east) {
		this.east = east;
	}

	public boolean isWest() {
		return west;
	}

	public void setWest(boolean west) {
		this.west = west;
	}

	public boolean isNorth() {
		return north;
	}

	public void setNorth(boolean north) {
		this.north = north;
	}

	public boolean isSouthFixed() {
		return southFixed;
	}

	public void setSouthFixed(boolean southFixed) {
		this.southFixed = southFixed;
	}

	public boolean isEastFixed() {
		return eastFixed;
	}

	public void setEastFixed(boolean eastFixed) {
		this.eastFixed = eastFixed;
	}

	public boolean isWestFixed() {
		return westFixed;
	}

	public void setWestFixed(boolean westFixed) {
		this.westFixed = westFixed;
	}

	public boolean isNorthFixed() {
		return northFixed;
	}

	public void setNorthFixed(boolean northFixed) {
		this.northFixed = northFixed;
	}

	public List<Cell> getDirectNeighbours() {
		return directNeighbours;
	}

	public boolean hasExternal() {
		return (eastFixed || westFixed || southFixed || northFixed);
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public void addDirectNeighbour(Cell neighbour) {
		this.directNeighbours.add(neighbour);
	}

	public void setAsEndCell() {
		if (eastFixed) {
			this.east = true;
		} else if (northFixed) {
			this.north = true;
		} else if (westFixed) {
			this.west = true;
		} else if (southFixed) {
			this.south = true;
		}
	}
	
	public void setAsStartCell() {
		if (northFixed) {
			this.north = true;
		} else if (westFixed) {
			this.west = true;
		} else if (eastFixed) {
			this.east = true;
		} else if (southFixed) {
			this.south = true;
		}
	}
}
