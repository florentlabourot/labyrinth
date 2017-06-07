package org.labyrinthes.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONWriter;
import org.labyrinthes.common.model.Constants;
import org.labyrinthes.common.model.Labyrinth;

public class CollectionJsonWriter extends AbstractOutputCommand {

	
	public void execute() {
		String output = getOuputDir();
		List<Labyrinth> list = generateResult.getLabyrinths();
		String name = (String)inputParam.get(Constants.OUTPUT);
		StringBuffer filename = new StringBuffer(output);
		filename.append("/list.json");
		PrintWriter pw;
		try {
			pw = new PrintWriter(new File(filename.toString()));
			JSONWriter jsonWriter = new JSONWriter(pw);
			jsonWriter.object();
			jsonWriter.key("name");
			jsonWriter.value(name);
			if (inputParam.containsKey(Constants.COLOR) && inputParam.containsKey(Constants.COLOR_SHADOW)){
				jsonWriter.key("wall");
				jsonWriter.value((String)inputParam.get(Constants.COLOR));
				jsonWriter.key("shadow");
				jsonWriter.value((String)inputParam.get(Constants.COLOR_SHADOW));
			}
			jsonWriter.key("labyrinths");
			jsonWriter.array();
			Collections.sort(list, new Comparator<Labyrinth>() {
				public int compare(Labyrinth a, Labyrinth b) {
					return (a.getDifficulty() - b.getDifficulty());
				}
			});
			for (Labyrinth labyrinth : list) {

				if (labyrinth.getName() != null) {
					jsonWriter.object();

					StringBuffer tmp = new StringBuffer(output);
					tmp.append("/").append(labyrinth.getName()).append(".json");
					jsonWriter.key("filename");
					jsonWriter.value(tmp.toString());
					jsonWriter.key("width");
					jsonWriter.value(labyrinth.getWidth());
					jsonWriter.key("height");
					jsonWriter.value(labyrinth.getHeight());
					jsonWriter.key("depth");
					jsonWriter.value(labyrinth.getDepth());
					jsonWriter.key("difficulty");
					jsonWriter.value(labyrinth.getDifficulty());
					jsonWriter.endObject();
				}
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
