package pl.majkus522.rammachine.gui;

import javafx.scene.control.TextField;

public class IntField extends TextField
{
	@Override
	public void replaceText(int start, int end, String text)
	{
		if (validate(text))
		{
			super.replaceText(start, end, text);
		}
	}

	@Override
	public void replaceSelection(String text)
	{
		if (validate(text))
		{
			super.replaceSelection(text);
		}
	}

	private boolean validate(String text)
	{
		return text.matches("[0-9]*");
	}

	public int getValue()
	{
		return Integer.parseInt(getText());
	}

	public void setValue(int value)
	{
		setText(value + "");
	}
}