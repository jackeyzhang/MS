/**
 * 
 */
package com.sickle.medu.ms.client.iportal.panel;

import com.sickle.medu.ms.client.ui.widget.LabelWithWhite;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * free product panel
 * 
 * @author chenhao
 *
 */
public class FreeProductPanel extends VLayout
{
	
	private static String descstr = "<h1>本网站由开源组织sickle制作<br>如果您有定制化企业或组织网站的需求,请联系我们<br>"+
			"<a target=blank href=tencent://message/?uin=276431729&Site=QQ在线&Menu=yes>QQ:276431729</a><br>" +
			"mail:zhangchenhao@139.com</h1>";
	
	public FreeProductPanel()
	{
		setWidth100( );
		setHeight100( );
		setStyleName( "freeproductpanel" );
		
		LabelWithWhite desc = new LabelWithWhite( descstr );
		addMember( desc );
	}

}
