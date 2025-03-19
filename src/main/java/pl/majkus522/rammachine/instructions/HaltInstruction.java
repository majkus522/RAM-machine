package pl.majkus522.rammachine.instructions;

import pl.majkus522.rammachine.RMerror;


public class HaltInstruction extends BaseInstruction
{
	public HaltInstruction(String address) throws RMerror
	{
		super("");
		if (!address.isEmpty())
			throw new RMerror("Polecenie HALT nie akceptuje rzadnych operandów");
	}

	@Override
	public void execute() throws RMerror
	{
		throw new RMerror(true);
	}
}
