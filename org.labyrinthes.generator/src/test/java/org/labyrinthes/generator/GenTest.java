package org.labyrinthes.generator;

import org.labyrinthes.common.command.CommandProcessor;
import org.labyrinthes.common.model.Difficulty;
import org.labyrinthes.input.LevelInput;
import org.labyrinthes.output.CollectionJsonWriter;
import org.labyrinthes.output.ImageWriter;
import org.labyrinthes.output.JsonWriter;

import junit.framework.TestCase;

public class GenTest extends TestCase {
	
	private final static String color[]= {"0xD98880ff","0xF1948Aff", "0xc39bd3ff","0xbb8fceff","0x7fb3d5ff","0x76d7c4ff","0x7dcea0ff","0xf7dc6fff", "0xf8c471ff", "0xf0b27aff", "0xe59866ff","0xf4f6f7ff", "0xd7dbddff", "0xbfc9caff", "0xb2babbff","0x85929eff", "0x808b96ff"};
	private final static String shadowColor[]= {"0x641E16ff","0x78281fff","0x512e5fff","0x4a235aff", "0x154360ff","0x0e6251ff","0x145a32ff","0x7d6608ff","0x7e5109ff", "0x784212ff", "0x6e2c00ff","0x7b7d7dff", "0x626567ff","0x4d5656ff", "0x424949ff","0x1b2631ff", "0x17202aff"};
	private final static String name [] ={"Ananke", "Chaos", "Chronos", "Erebe", "Eros", "Ether", "Gaia", "Hemera", "Hypnos", "Moros", "Nesoi", "Nyx", "Ouranos", "Ourea", "Phanes", "Pontos", "Tartare", "Thalassa", "Thanatos"};
	
	public void testGenerator() {
		for (Difficulty diff : Difficulty.values()) {
			for (int i =0; i < 17; ++i){
				int nb = 6 +((int) (Math.random() * 5)*2);
				generateAGroup(diff, nb, i, i);
			}
		}
	}
	
	private void generateAGroup(Difficulty difficulty, int number, int colorIndex, int nameIndex){
		CommandProcessor commandProcessor = new CommandProcessor();
		commandProcessor.addCommand(new LevelInput(difficulty, number, name[nameIndex], color[colorIndex],shadowColor[colorIndex]));
		commandProcessor.addCommand(new BasicGenerator());
		commandProcessor.addCommand(new BasicMetaGenerator());
		commandProcessor.addCommand(new BasicNameGenerator());
		//commandProcessor.addCommand(new ImageWriter());
		commandProcessor.addCommand(new JsonWriter());
		commandProcessor.addCommand(new CollectionJsonWriter());
		commandProcessor.process();
	}
}
