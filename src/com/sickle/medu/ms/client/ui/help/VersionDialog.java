/**
 * 
 */
package com.sickle.medu.ms.client.ui.help;

import com.sickle.medu.ms.client.ui.dialog.AbstractDialog;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 关于版本
 * 
 * @author chenhao
 *
 */
public class VersionDialog extends AbstractDialog
{
	
	public static final String VERSION = "<p>版本信息:<b> 0.1.0</b></p>";

	public VersionDialog()
	{
		super( "版本信息" );
	}

	@Override
	public Canvas getView( )
	{
		VLayout layout = new VLayout();
		
		layout.setWidth( 300 );
		
		Label author = new Label(VERSION);
		
		layout.addMember( author );
		return layout;
	}

}
