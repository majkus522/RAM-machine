package pl.majkus522.rammachine;

import static pl.majkus522.rammachine.MachineController.getLineIndex;

public class RMerror extends Exception
{
	boolean isHalt = false;

	public RMerror(boolean isHalt)
	{
		this.isHalt = isHalt;
	}

	public RMerror(String message)
	{
		super(message + "\r\nLine: " + (getLineIndex() + 1));
	}

	public boolean isHalt()
	{
		return isHalt;
	}
}