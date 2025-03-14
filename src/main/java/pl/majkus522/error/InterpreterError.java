package pl.majkus522.error;

import pl.majkus522.MachineController;

public class InterpreterError extends Exception
{
	final String message;

	public InterpreterError(String message)
	{
		this.message = message;
	}

	@Override
	public String getMessage()
	{
		return message + "\r\nLine: " + MachineController.lineIndex;
	}
}