package org.labyrinthes.common.model;

import java.util.ArrayList;
import java.util.List;

import org.labyrinthes.common.command.CommandArg;

public class GenerateResult implements CommandArg {
	private int state = 0;
	private List<Labyrinth> labyrinths = new ArrayList<Labyrinth>();

	public List<Labyrinth> getLabyrinths() {
		return labyrinths;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void addLabyrinth(Labyrinth labyrinth) {
		this.labyrinths.add(labyrinth);
	}
	
	
}
