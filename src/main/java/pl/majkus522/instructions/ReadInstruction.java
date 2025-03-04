package pl.majkus522.instructions;

import pl.majkus522.AddressType;
import pl.majkus522.MachineController;
import pl.majkus522.error.InterpreterError;
import pl.majkus522.error.RuntimeError;

public class ReadInstruction extends BaseInstruction
{
	public ReadInstruction(String address) throws InterpreterError
	{
		super(address);
		if (type == AddressType.NUMBER)
			throw new InterpreterError("Can't use = operand in READ command");
	}

	@Override
	public void execute() throws RuntimeError
	{
		MachineController.setRegistry(address, MachineController.readInput());
	}
}