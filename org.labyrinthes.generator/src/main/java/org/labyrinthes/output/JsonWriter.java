package org.labyrinthes.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import org.json.JSONWriter;
import org.labyrinthes.common.command.OutputCommand;
import org.labyrinthes.common.model.Cell;
import org.labyrinthes.common.model.Constants;
import org.labyrinthes.common.model.GenerateResult;
import org.labyrinthes.common.model.InputParam;
import org.labyrinthes.common.model.Labyrinth;
import org.labyrinthes.common.model.OutputResult;

public class JsonWriter extends AbstractOutputCommand {


	public void execute() {
		String output = getOuputDir();
		List<Labyrinth> list = generateResult.getLabyrinths();
		for (Labyrinth labyrinth : list) {
			String filename = "tmp.json";
			if (labyrinth.getName() != null) {
				StringBuffer tmp = new StringBuffer(output);
				tmp.append("/").append(labyrinth.getName()).append(".json");
				filename = tmp.toString();
			}
			this.writeJson(labyrinth, filename);
		}
	}

	private void writeJson(Labyrinth labyrinth, String filename) {
		try {
			PrintWriter pw = new PrintWriter(new File(filename));
			JSONWriter jsonWriter = new JSONWriter(pw);
			jsonWriter.object();
			jsonWriter.key("height");
			jsonWriter.value(labyrinth.getHeight());
			jsonWriter.key("width");
			jsonWriter.value(labyrinth.getWidth());
			jsonWriter.key("start");
			jsonWriter.object();
			jsonWriter.key("x");
			jsonWriter.value(labyrinth.getStartCell().getX());
			jsonWriter.key("y");
			jsonWriter.value(labyrinth.getStartCell().getY());
			jsonWriter.endObject();
			jsonWriter.key("end");
			jsonWriter.object();
			jsonWriter.key("x");
			jsonWriter.value(labyrinth.getEndCell().getX());
			jsonWriter.key("y");
			jsonWriter.value(labyrinth.getEndCell().getY());
			jsonWriter.endObject();
			jsonWriter.key("depth");
			jsonWriter.value(labyrinth.getDepth());
			jsonWriter.key("difficulty");
			jsonWriter.value(labyrinth.getDifficulty());
			jsonWriter.key("cells");
			jsonWriter.array();
			for (int i = 0; i < labyrinth.getHeight(); ++i) {
				for (int j = 0; j < labyrinth.getWidth(); ++j) {
					Cell cell = labyrinth.getCell(j, i);
					jsonWriter.object();
					jsonWriter.key("x");
					jsonWriter.value(cell.getX());
					jsonWriter.key("y");
					jsonWriter.value(cell.getY());
					jsonWriter.key("north");
					jsonWriter.value(cell.isNorth());
					jsonWriter.key("south");
					jsonWriter.value(cell.isSouth());
					jsonWriter.key("east");
					jsonWriter.value(cell.isEast());
					jsonWriter.key("west");
					jsonWriter.value(cell.isWest());
					jsonWriter.endObject();
				}
			}
			jsonWriter.endArray();
			jsonWriter.key("solution");
			List<Cell> solutionWay = labyrinth.getSolutionWay();
			jsonWriter.array();
			for (Cell cell : solutionWay) {
				jsonWriter.object();
				jsonWriter.key("x");
				jsonWriter.value(cell.getX());
				jsonWriter.key("y");
				jsonWriter.value(cell.getY());
				jsonWriter.endObject();
			}
			jsonWriter.endArray();
			jsonWriter.endObject();
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
