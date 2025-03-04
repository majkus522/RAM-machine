package pl.majkus522.error;

import pl.majkus522.MachineController;

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