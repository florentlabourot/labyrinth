package org.labyrinthes.common.model;

import org.labyrinthes.common.command.CommandArg;

public class InputParam extends BasicParam implements CommandArg{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -948354318617495688L;
	
	private int width;
	private int height;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}


}
