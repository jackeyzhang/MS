/**
 * 
 */
package com.sickle.medu.ms.client.ui.tabpanel;

import com.sickle.medu.ms.client.form.MessageForm;
import com.sickle.medu.ms.client.ui.dialog.AbstractDialog;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.layout.HLayout;


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
				HLayout layout = new HLayout( );
				layout.setWidth100( );
				layout.setHeight( 500 );
				layout.addMember( new MessageForm().getLookForm( ) );
				layout.addMember( new MessageForm().getAddForm( ) );
				layout.addMember( new MessageForm().getModifyForm( ) );
				return layout;
			}
			
		};
		orglistwindow.setWidth( "80%" );
		orglistwindow.setHeight( 500 );
		return orglistwindow;
	}

}
