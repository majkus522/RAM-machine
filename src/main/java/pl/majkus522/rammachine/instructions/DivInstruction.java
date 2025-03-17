package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.error.InterpreterError;
import pl.majkus522.rammachine.error.RuntimeError;

import static pl.majkus522.rammachine.MachineController.getRegistry;
import static pl.majkus522.rammachine.MachineController.setRegistry;

public class DivInstruction extends BaseInstruction
{
	public DivInstruction(String address) throws InterpreterError
	{
		super(address);
	}

	@Override
	public void execute() throws RuntimeError
	{
		setRegistry(0, (int) (getRegistry(0) / getValueFromRegistry()));
	}
}