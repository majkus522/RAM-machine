package pl.majkus522.instructions;

import org.jetbrains.annotations.Nullable;

public class HaltInstruction extends BaseInstruction
{
	public HaltInstruction(@Nullable String address)
	{
		super("");
	}

	@Override
	public void execute()
	{
		System.out.println("halt " + toString());
	}
}
