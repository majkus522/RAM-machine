package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.AddressType;
import pl.majkus522.rammachine.RMerror;

import static pl.majkus522.rammachine.MachineController.readInput;
import static pl.majkus522.rammachine.MachineController.setRegistry;

public class ReadInstruction extends BaseInstruction
{
	public ReadInstruction(String address) throws RMerror
	{
		super(address);
		if (type == AddressType.NUMBER)
			throw new RMerror("Nie możesz użyć '=' dla polecenia READ");
	}

	@Override
	public void execute() throws RMerror
	{
		setRegistry(getAddress(), readInput());
	}
}