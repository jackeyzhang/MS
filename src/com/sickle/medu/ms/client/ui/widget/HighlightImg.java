package com.sickle.medu.ms.client.ui.widget;

import com.sickle.medu.ms.client.ui.util.MagicShow;
import com.smartgwt.client.widgets.Img;


public class HighlightImg extends Img
{

	public HighlightImg(String src)
	{
		super(src);
		init();
	}
	
	private void init()
	{
		MagicShow.addHighlightWhenMouseOver( this );
	}
}
