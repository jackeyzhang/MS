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

	/**
	 * @param title
	 * @param withmousechange
	 * @param outstylename
	 * @param instylename
	 */
	public LabelWithWhite( String title, boolean withmousechange,
			String outstylename, String instylename )
	{
		super( title, withmousechange, outstylename, instylename );
	}
	
	
}
