package org.labyrinthes.common.command;

import org.labyrinthes.common.model.GenerateResult;
import org.labyrinthes.common.model.InputParam;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestCommand extends TestCase{

	public void testSimpleProcess(){
		CommandProcessor commandProcessor = new CommandProcessor();
		commandProcessor.addCommand(new InputCommandImpl());
		commandProcessor.addCommand(new GenerateCommandImpl());
		commandProcessor.process();
		InputParam param = commandProcessor.getInputParam();
		GenerateResult result = commandProcessor.getGenerateResult();
		Assert.assertEquals("test", param.get("test"));
		Assert.assertEquals(5, result.getState());
	}
}
