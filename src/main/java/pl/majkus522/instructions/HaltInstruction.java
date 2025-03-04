package pl.majkus522.instructions;

import pl.majkus522.error.InterpreterError;

public class HaltInstruction extends BaseInstruction
{
	public HaltInstruction(String address) throws InterpreterError
	{
		super("");
		if (!address.isEmpty())
			throw new InterpreterError("HALT command doesn't accept any operands");
	}

	@Override
	public void execute()
	{
		System.out.println("halt " + this);
	}
}
