package org.labyrinthes.output;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.labyrinthes.common.model.Cell;
import org.labyrinthes.common.model.Constants;
import org.labyrinthes.common.model.Labyrinth;

public class ImageWriter extends AbstractOutputCommand {

	private int cellSize = 25;
	private int margin = 50;
	private BufferedImage bufferedImage;

	public void prepare(Labyrinth labyrinth) {
		final int width = labyrinth.getWidth() * cellSize + margin * 2;
		final int height = labyrinth.getHeight() * cellSize + margin * 2;
		bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		final Graphics2D g2d = bufferedImage.createGraphics();
		g2d.setBackground(Color.white);
		g2d.fillRect(0, 0, width, height);

		g2d.setColor(Color.black);
		final Cell[][] table = labyrinth.getTable();
		for (int i = 0; i < labyrinth.getHeight(); ++i) {
			for (int j = 0; j < labyrinth.getWidth(); ++j) {
				final Cell cell = table[i][j];
				if (cell.isUsed()) {
					continue;
				}

				final int x1 = cell.getX() * cellSize + margin;
				final int x2 = x1 + cellSize - 1;
				final int y1 = cell.getY() * cellSize + margin;
				final int y2 = y1 + cellSize - 1;
				if (!cell.isNorth()) {
					g2d.drawLine(x1, y1, x2, y1);
					if (!cell.isNorthFixed()) {
						g2d.drawLine(x1, y1 - 1, x2, y1 - 1);
					}
				}
				if (!cell.isSouth()) {
					g2d.drawLine(x1, y2, x2, y2);
					if (!cell.isSouthFixed()) {
						g2d.drawLine(x1, y2 + 1, x2, y2 + 1);
					}
				}
				if (!cell.isWest()) {
					g2d.drawLine(x1, y1, x1, y2);
					if (!cell.isWestFixed()) {
						g2d.drawLine(x1 - 1, y1, x1 - 1, y2);
					}
				}
				if (!cell.isEast()) {
					g2d.drawLine(x2, y1, x2, y2);
					if (!cell.isEastFixed()) {
						g2d.drawLine(x2 + 1, y1, x2 + 1, y2);
					}
				}
			}
		}
	}

	public void write(final String filename) {
		try {
			ImageIO.write(bufferedImage, "PNG", new File(filename));
		} catch (final IOException ie) {
			ie.printStackTrace();
		}
	}

	public void execute() {
		String output = getOuputDir();
		List<Labyrinth> list = generateResult.getLabyrinths();
		for (Labyrinth labyrinth : list) {
			this.prepare(labyrinth);
			String filename = "tmp.png";
			if (labyrinth.getName() != null) {
				StringBuffer tmp = new StringBuffer(output);
				tmp.append("/").append(labyrinth.getName()).append(".png");
				filename = tmp.toString();
			}
			this.write(filename);
		}
	}

	
}
