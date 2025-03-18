package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.RMerror;

import static pl.majkus522.rammachine.MachineController.goTo;

public class JumpInstruction extends BaseInstruction
{
	final String label;

	public JumpInstruction(String address) throws RMerror
	{
		super("");
		this.label = address;
	}

	@Override
	public void execute() throws RMerror
	{
		goTo(label);
	}
}