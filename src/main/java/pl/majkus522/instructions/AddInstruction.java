package pl.majkus522.instructions;

import pl.majkus522.error.InterpreterError;
import pl.majkus522.error.RuntimeError;

import static pl.majkus522.MachineController.getRegistry;
import static pl.majkus522.MachineController.setRegistry;

public class AddInstruction extends BaseInstruction
{
	public AddInstruction(String address) throws InterpreterError
	{
		super(address);
	}

	@Override
	public void execute() throws RuntimeError
	{
		setRegistry(0, getRegistry(0) + getValueFromRegistry());
	}
}