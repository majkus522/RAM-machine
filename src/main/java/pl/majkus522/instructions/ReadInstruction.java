package pl.majkus522.instructions;

import pl.majkus522.Main;
import pl.majkus522.error.RuntimeError;

public class ReadInstruction extends BaseInstruction
{
	public ReadInstruction(String address)
	{
		super(address);
	}

	@Override
	public void execute() throws RuntimeError
	{
		Main.getRegistry(address);
	}
}