package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.error.InterpreterError;
import pl.majkus522.rammachine.error.RuntimeError;

import static pl.majkus522.rammachine.MachineController.*;

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