package com.sickle.medu.ms.client.ui.dialog;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;

/**
 * 提示
 * 
 * @author chenhao
 *
 */
public class LoadingHintDialog extends AbstractDialog{
	
	
	private Label hintlabel;
	
	public LoadingHintDialog(){
		super("提示");
	}

	@Override
	public Canvas getView( )
	{
		HLayout v = new HLayout( );
		v.setWidth( 300 );
		v.setHeight100( );
		hintlabel = new Label();
		v.addMember( new Img("waiting.gif") );
		v.addMember( hintlabel );
		return v;
	}

	
	/**
	 * @return the hintlabel
	 */
	public Label getHintlabel( )
	{
		return hintlabel;
	}

	
	/**
	 * @param hintlabel the hintlabel to set
	 */
	public void setHintlabel( Label hintlabel )
	{
		this.hintlabel = hintlabel;
	}
	
	

}
