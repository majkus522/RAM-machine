package pl.majkus522.instructions;

import pl.majkus522.error.InterpreterError;
import pl.majkus522.error.RuntimeError;

import static pl.majkus522.MachineController.labels;
import static pl.majkus522.MachineController.lineIndex;

public class JumpInstruction extends BaseInstruction
{
	final String label;

	public JumpInstruction(String address) throws InterpreterError
	{
		super("");
		this.label = address;
	}

	@Override
	public void execute() throws RuntimeError
	{
		lineIndex = labels.get(label) - 1;
	}
}