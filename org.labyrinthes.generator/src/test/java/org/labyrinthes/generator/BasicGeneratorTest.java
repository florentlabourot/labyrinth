package org.labyrinthes.generator;

import org.labyrinthes.generator.model.Labyrinth;
import org.labyrinthes.output.ImageWriter;

import junit.framework.TestCase;

public class BasicGeneratorTest extends TestCase {

	public void testLittleLabyrinth() {
		BasicGenerator basicGenerator = new BasicGenerator();
		Labyrinth labyrinth = basicGenerator.generate(40, 40);
		//labyrinth.print(System.out);
		ImageWriter iw =new ImageWriter();
		iw.prepare(labyrinth);
		iw.write("test.png");
	}

}
