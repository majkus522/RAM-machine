package pl.majkus522.instructions;

import pl.majkus522.error.InterpreterError;
import pl.majkus522.error.RuntimeError;

import static pl.majkus522.MachineController.writeOutput;

public class WriteInstruction extends BaseInstruction
{
	public WriteInstruction(String address) throws InterpreterError
	{
		super(address);
	}

	@Override
	public void execute() throws RuntimeError
	{
		writeOutput(getValueFromRegistry());
	}
}