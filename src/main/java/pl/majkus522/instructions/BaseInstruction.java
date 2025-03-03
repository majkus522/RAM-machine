package pl.majkus522.instructions;

import pl.majkus522.AddressType;
import pl.majkus522.Main;
import pl.majkus522.error.RuntimeError;

public abstract class BaseInstruction
{
	protected AddressType type;
	protected int address;

	public BaseInstruction(String address)
	{
		if (address.length() == 0)
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
		this.address = Integer.parseInt(address.substring(index));
	}

	public abstract void execute() throws RuntimeError;

	@Override
	public String toString()
	{
		return "BaseInstruction{" + "type=" + type + ", address=" + address + '}';
	}

	protected final int getAddress() throws RuntimeError
	{
		return switch (type)
		{
			case AddressType.REGISTER -> address;
			case POINTER -> Main.getRegistry(address);
			default -> 0;
		};
	}
}