package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.RMerror;

import static pl.majkus522.rammachine.MachineController.writeOutput;

public class WriteInstruction extends BaseInstruction
{
	public WriteInstruction(String address) throws RMerror
	{
		super(address);
	}

	@Override
	public void execute() throws RMerror
	{
		writeOutput(getValueFromRegistry());
	}
}