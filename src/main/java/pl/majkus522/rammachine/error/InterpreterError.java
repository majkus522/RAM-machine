package pl.majkus522.rammachine.error;

import pl.majkus522.rammachine.MachineController;

import static pl.majkus522.rammachine.MachineController.getLineIndex;

public class InterpreterError extends Exception
{
	public InterpreterError(String message)
	{
		super(message + "\r\nLine: " + getLineIndex());
	}
}