package pl.majkus522.instructions;

import pl.majkus522.error.InterpreterError;
import pl.majkus522.error.RuntimeError;

import static pl.majkus522.MachineController.setRegistry;

public class LoadInstruction extends BaseInstruction
{
	public LoadInstruction(String address) throws InterpreterError
	{
		super(address);
	}

	@Override
	public void execute() throws RuntimeError
	{
		setRegistry(0, getValueFromRegistry());
	}
}