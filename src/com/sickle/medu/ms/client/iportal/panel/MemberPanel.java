/**
 * 
 */
package com.sickle.medu.ms.client.iportal.panel;

import com.sickle.medu.ms.client.iportal.card.BigMemberCard;
import com.sickle.medu.ms.client.util.ScreenUtil;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * member panel 
 * 
 * @author chenhao
 *
 */
public class MemberPanel extends VLayout
{

	private Member member;
	
	public MemberPanel()
	{
		setWidth100( );
		setHeight100( );
	}
	
	public void fillpanel(Member _member)
	{
		ScreenUtil.clearLayout( this );
		this.member = _member;
		BigMemberCard card = new BigMemberCard( true , member, "100%", "100%" ) ;
		addMember( card );
	}
}
