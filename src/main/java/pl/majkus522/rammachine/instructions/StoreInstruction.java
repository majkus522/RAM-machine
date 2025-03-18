package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.AddressType;
import pl.majkus522.rammachine.RMerror;

import static pl.majkus522.rammachine.MachineController.getRegistry;
import static pl.majkus522.rammachine.MachineController.setRegistry;

public class StoreInstruction extends BaseInstruction
{
	public StoreInstruction(String address) throws RMerror
	{
		super(address);
		if (type == AddressType.NUMBER)
			throw new RMerror("Can't use = operand in STORE command");
	}

	@Override
	public void execute() throws RMerror
	{
		setRegistry(getAddress(), getRegistry(0));
	}
}