package pl.majkus522.rammachine.error;

import pl.majkus522.rammachine.MachineController;

public class RuntimeError extends Exception
{
	final String message;

	public RuntimeError(String message)
	{
		this.message = message;
	}

	@Override
	public String getMessage()
	{
		return message + "\r\nLine: " + MachineController.lineIndex;
	}
}