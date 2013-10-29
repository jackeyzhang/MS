package com.sickle.medu.ms.client.ui.dialog;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * 提示
 * 
 * @author chenhao
 *
 */
public class LoadingHintDialog extends AbstractDialog{
	
	private String hint;
	
	public LoadingHintDialog(String hint){
		super("提示");
		this.hint = hint;
	}

	@Override
	public Canvas getView( )
	{
		VLayout v = new VLayout( );
		v.setWidth( 300 );
		v.addMember( new Label(this.hint) );
		return v;
	}

}
