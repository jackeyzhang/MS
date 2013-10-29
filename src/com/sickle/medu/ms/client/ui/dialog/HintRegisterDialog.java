/**
 * 
 */
package com.sickle.medu.ms.client.ui.dialog;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * @author chenhao
 *
 */
public class HintRegisterDialog extends AbstractDialog
{

	public HintRegisterDialog( String title )
	{
		super( title,true,true,false );
	}

	@Override
	public Canvas getView( )
	{
		VLayout panel = new VLayout( );
		panel.setWidth( 500 );
		panel.addMember( new Label("请您花费几秒钟先登录或注册成为本网站会员.") );
		return panel;
	}

}
