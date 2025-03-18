package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.AddressType;
import pl.majkus522.rammachine.MachineController;
import pl.majkus522.rammachine.RMerror;

import static pl.majkus522.rammachine.MachineController.getRegistry;

public abstract class BaseInstruction
{
	protected AddressType type;
	protected int address;

	public BaseInstruction(String address) throws RMerror
	{
		if (address.isEmpty())
			return;
		int index = 1;
		switch (address.charAt(0))
		{
			case '=':
				type = AddressType.NUMBER;
				break;

			case '*':
				type = AddressType.POINTER;
				break;

			default:
				type = AddressType.REGISTER;
				index = 0;
				break;
		}
		try
		{
			this.address = Integer.parseInt(address.substring(index));
		}
		catch (NumberFormatException e)
		{
			throw new RMerror("Not a number");
		}
	}

	public abstract void execute() throws RMerror;

	protected final int getAddress() throws RMerror
	{
		return switch (type)
		{
			case AddressType.REGISTER -> address;
			case POINTER -> MachineController.getRegistry(address);
			default -> 0;
		};
	}

	protected final int getValueFromRegistry() throws RMerror
	{
		return type == AddressType.NUMBER ? address : getRegistry(getAddress());
	}
}