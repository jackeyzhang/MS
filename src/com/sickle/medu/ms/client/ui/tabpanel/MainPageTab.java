/**
 * 
 */
package com.sickle.medu.ms.client.ui.tabpanel;

import com.sickle.medu.ms.client.form.auto.MessageDForm;
import com.sickle.medu.ms.client.ui.dialog.AbstractDialog;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 主界面默认不可关闭的首页
 * 
 * @author chenhao
 *
 */
public class MainPageTab extends AbstractTab
{

	public MainPageTab()
	{
		super( "主界面", "pieces/16/cube_frame.png", false );
	}

	@Override
	public Canvas getPanel( )
	{
		
		return getOrgListWindow();
	}
	
	private Window getOrgListWindow()
	{
		Window orglistwindow = new AbstractDialog("公司列表"){
			@Override
			public Canvas getView( )
			{
				VLayout layout = new VLayout( );
				layout.setWidth100( );
				layout.setHeight( 500 );
				layout.addMember( new MessageDForm( ).getDefaultLayout( ) );
				return layout;
			}
			
		};
		orglistwindow.setWidth( "80%" );
		orglistwindow.setHeight( 500 );
		return orglistwindow;
	}

}
