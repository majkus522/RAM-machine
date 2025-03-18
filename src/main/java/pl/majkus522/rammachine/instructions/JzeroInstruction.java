package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.RMerror;

import static pl.majkus522.rammachine.MachineController.getRegistry;

public class JzeroInstruction extends JumpInstruction
{
	public JzeroInstruction(String address) throws RMerror
	{
		super(address);
	}

	@Override
	public void execute() throws RMerror
	{
		if (getRegistry(0) == 0)
			super.execute();
	}
}