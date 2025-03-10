package pl.majkus522.instructions;

import pl.majkus522.error.InterpreterError;
import pl.majkus522.error.RuntimeError;

import static pl.majkus522.MachineController.*;

public class JzeroInstruction extends JumpInstruction
{
	public JzeroInstruction(String address) throws InterpreterError
	{
		super(address);
	}

	@Override
	public void execute() throws RuntimeError
	{
		if (getRegistry(0) == 0)
			super.execute();
	}
}