package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.RMerror;

import static pl.majkus522.rammachine.MachineController.getRegistry;
import static pl.majkus522.rammachine.MachineController.setRegistry;

public class DivInstruction extends BaseInstruction
{
	public DivInstruction(String address) throws RMerror
	{
		super(address);
	}

	@Override
	public void execute() throws RMerror
	{
		if (getValueFromRegistry() == 0)
			throw new RMerror("Nie dziel przez 0");
		setRegistry(0, getRegistry(0) / getValueFromRegistry());
	}
}