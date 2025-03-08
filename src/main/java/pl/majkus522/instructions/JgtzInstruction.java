package pl.majkus522.instructions;

import pl.majkus522.error.InterpreterError;
import pl.majkus522.error.RuntimeError;

import static pl.majkus522.MachineController.*;

public class JgtzInstruction extends BaseInstruction
{
	final String label;

	public JgtzInstruction(String address) throws InterpreterError
	{
		super("");
		this.label = address;
	}

	@Override
	public void execute() throws RuntimeError
	{
		if (getRegistry(0) > 0)
			lineIndex = labels.get(label) - 1;
	}
}