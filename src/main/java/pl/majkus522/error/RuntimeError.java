package pl.majkus522.error;

public class RuntimeError extends Exception
{
	final String message;
	final int line;

	public RuntimeError(String message, int line)
	{
		this.message = message;
		this.line = line;
	}

	@Override
	public String getMessage()
	{
		return message + "\r\nLine: " + line;
	}
}