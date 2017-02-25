package org.labyrinthes.generator;

import org.labyrinthes.generator.model.Labyrinth;

import junit.framework.TestCase;

public class BasicGeneratorTest extends TestCase {

	public void testLittleLabyrinth() {
		BasicGenerator basicGenerator = new BasicGenerator();
		Labyrinth labyrinth = basicGenerator.generate(4, 4);
		labyrinth.print(System.out);
	}

}
