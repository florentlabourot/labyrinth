package org.labyrinthes.common.model;

import org.labyrinthes.common.command.CommandArg;

public class GenerateResult implements CommandArg {
	private int state = 0;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
