package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.AddressType;
import pl.majkus522.rammachine.error.InterpreterError;
import pl.majkus522.rammachine.error.RuntimeError;

import static pl.majkus522.rammachine.MachineController.readInput;
import static pl.majkus522.rammachine.MachineController.setRegistry;

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
		setRegistry(getAddress(), readInput());
	}
}