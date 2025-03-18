package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.RMerror;

import static pl.majkus522.rammachine.MachineController.setRegistry;

public class LoadInstruction extends BaseInstruction
{
	public LoadInstruction(String address) throws RMerror
	{
		super(address);
	}

	@Override
	public void execute() throws RMerror
	{
		setRegistry(0, getValueFromRegistry());
	}
}