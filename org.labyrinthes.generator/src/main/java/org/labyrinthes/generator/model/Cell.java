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
	private int num;

	/**
	 * wall in each side of the cell
	 */
	private boolean south = false;
	private boolean east = false;
	private boolean west = false;
	private boolean north = false;
	private boolean southIn = true;
	private boolean eastIn = true;
	private boolean westIn = true;
	private boolean northIn = true;

	/**
	 * List of the direct neighboor cells
	 */
	private final List<Cell> directNeighboors = new ArrayList<Cell>();

	public Cell(final int x, final int y, final int num) {
		this.x = x;
		this.y = y;
		this.num = num;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public boolean isSouthIn() {
		return southIn;
	}

	public void setSouthIn(boolean southIn) {
		this.southIn = southIn;
	}

	public boolean isEastIn() {
		return eastIn;
	}

	public void setEastIn(boolean eastIn) {
		this.eastIn = eastIn;
	}

	public boolean isWestIn() {
		return westIn;
	}

	public void setWestIn(boolean westIn) {
		this.westIn = westIn;
	}

	public boolean isNorthIn() {
		return northIn;
	}

	public void setNorthIn(boolean northIn) {
		this.northIn = northIn;
	}

	public List<Cell> getDirectNeighboors() {
		return directNeighboors;
	}
	
	public boolean hasExternal() {
		return !(eastIn && westIn && southIn && northIn);
	}
	
}
