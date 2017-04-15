package org.labyrinthes.generator;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.labyrinthes.common.command.GenerateCommand;
import org.labyrinthes.common.model.Cell;
import org.labyrinthes.common.model.GenerateResult;
import org.labyrinthes.common.model.InputParam;
import org.labyrinthes.common.model.Labyrinth;

public class BasicMetaGenerator extends GenerateCommand {

	private InputParam inputParam;
	private GenerateResult generateResult;
	private SearchTree searchTree = new SearchTree();

	public void execute() {
		List<Labyrinth> list = generateResult.getLabyrinths();
		int max = 0;
		int min = 10000;
		int sum = 0;
		int maxp = 0;
		int minp = 10000;
		int sump = 0;
		for (Labyrinth labyrinth : list) {
			searchTree.clear();
			int depth = searchTree.calculateDeepest(labyrinth.getStartCell(), 0, null);
			// searchTree.printSolution();
			List<Cell> solutionWay = searchTree.getSolutionWay();
			Collections.reverse(solutionWay);
			labyrinth.setSolutionWay(solutionWay);
			Cell oldEnd = labyrinth.getEndCell();
			oldEnd.setAsNormalBorderCell();
			Cell newEnd = searchTree.getDeeperCell();
			labyrinth.setEndCell(newEnd);
			newEnd.setAsEndCell();
			labyrinth.setDepth(depth);
			System.out.println("prof : " + depth);
			// System.out.println("nbChoice " + searchTree.getNbChoice());
			float diff = (100 * depth) / (labyrinth.getHeight() * labyrinth.getWidth());
			float diff2 = depth * 2 + diff;
			labyrinth.setDifficulty((int) diff2);
			System.out.println(diff + "," + diff2);
			if (diff > max) {
				max = (int) diff;
			}
			if (diff < min) {
				min = (int) diff;
			}
			sum += diff;
			sump += depth;
			if (depth > maxp) {
				maxp = depth;
			}
			if (depth < minp) {
				minp = depth;
			}
			// System.out.println("diff :" +(depth + (100*depth) /
			// (labyrinth.getHeight()*labyrinth.getWidth())));
			System.out.println("------");
		}
		if (list.size() > 0) {
			System.out.println("max : " + max + "min : " + min + "moy :" + (sum / list.size()));
			System.out.println("maxp : " + maxp + "minp : " + minp + "moyp :" + (sump / list.size()));
		}

	}

	@Override
	public void setInputParam(InputParam input) {
		this.inputParam = input;
	}

	@Override
	public void setGenerateResult(GenerateResult result) {
		this.generateResult = result;
	}

}
