package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.error.InterpreterError;
import pl.majkus522.rammachine.error.RuntimeError;


public class HaltInstruction extends BaseInstruction
{
	public HaltInstruction(String address) throws InterpreterError
	{
		super("");
		if (!address.isEmpty())
			throw new InterpreterError("HALT command doesn't accept any operands");
	}

	@Override
	public void execute() throws RuntimeError
	{

	}
}
