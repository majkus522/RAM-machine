package pl.majkus522.rammachine.error;

import pl.majkus522.rammachine.MachineController;

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