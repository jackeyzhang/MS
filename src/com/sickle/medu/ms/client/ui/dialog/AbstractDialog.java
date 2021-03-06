/**
 * 
 */

package com.sickle.medu.ms.client.ui.dialog;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * 抽象的dialog实现
 * 
 * @author chenhao
 * 
 */
public abstract class AbstractDialog extends Window
{

	private Canvas content;
	
	public AbstractDialog( String title )
	{
		this( title, false, true, true );
	}

	public AbstractDialog( String title, boolean isModal, boolean closeable,
			boolean isMinable )
	{
		this.setHeaderIcon( "pieces/16/cube_frame.png", 16, 16 );
		this.setKeepInParentRect( true );
		this.setAutoSize( true );
		this.setTitle( title );
		this.setIsModal( isModal );
		this.setShowCloseButton( closeable );
		this.setShowMinimizeButton( isMinable );
		this.content = getView( );
		this.addItem( content );
		this.content.setStyleName( "abstractdialog-content" );
		if ( getTitleView( ) != null )
		{
			this.addMember( getTitleView( ) );
		}

	}

	
	/**
	 * 获取到对话框的页面内容
	 * 
	 * 子类实现
	 * 
	 * @return
	 */
	public abstract Canvas getView( );
	
	public VLayout getDefaultVLayout(){
		VLayout wholepanel = new VLayout( );
		wholepanel.setStyleName( "abstractdialog-content" );
		return wholepanel;
	}

	public Canvas getTitleView( )
	{
		return null;
	}

	public void show( )
	{
		if(this.isCreated( ) == false)
		{
			this.draw( );
			this.centerInPage( );
		}else{
			this.setVisible( true );
			this.centerInPage( );
		}
	}
}
