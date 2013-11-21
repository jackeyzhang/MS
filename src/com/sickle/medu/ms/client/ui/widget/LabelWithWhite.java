package com.sickle.medu.ms.client.ui.widget;


public class LabelWithWhite extends MouseChangeLabel
{

	public LabelWithWhite(String title )
	{
		this(title , false);
	}
	
	public LabelWithWhite(String title,boolean change )
	{
		super(title , change ,"whitelittlelabel","whitelittlelabel-mousein");
	}
}
