/**
 * 
 */
package com.sickle.medu.ms.client.ui.help;

import com.sickle.medu.ms.client.ui.dialog.AbstractDialog;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 关于作者
 * 
 * @author chenhao
 *
 */
public class AboutAuthorDialog extends AbstractDialog
{

	public AboutAuthorDialog()
	{
		super( "作者信息" );
	}

	@Override
	public Canvas getView( )
	{
		VLayout layout = new VLayout();
		
		layout.setWidth( 300 );
		
		Label author = new Label("<p>本网站是由<b>张琛浩</b>、<b>魏斌斌</b>、<b>王振华</b>联合开发,版权归个人所有，<br>如果您对本网站有兴趣或者像定制归属于您企业的管理系统，请联系我们.</p><br>" +
				"<a target=blank href=tencent://message/?uin=276431729&Site=QQ在线&Menu=yes>QQ:276431729</a><br>" +
				"mail:zhangchenhao@139.com");
		layout.addMember( author );
		return layout;
	}

}
