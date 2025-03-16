package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.error.InterpreterError;
import pl.majkus522.rammachine.error.RuntimeError;

import static pl.majkus522.rammachine.MachineController.*;

public class JgtzInstruction extends JumpInstruction
{
	public JgtzInstruction(String address) throws InterpreterError
	{
		super(address);
	}

	@Override
	public void execute() throws RuntimeError
	{
		if (getRegistry(0) > 0)
			super.execute();
	}
}