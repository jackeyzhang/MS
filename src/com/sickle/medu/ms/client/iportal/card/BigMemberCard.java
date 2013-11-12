/**
 * 
 */
package com.sickle.medu.ms.client.iportal.card;

import com.sickle.pojo.edu.Member;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 老师大名片
 * 
 * 更详尽更多内容更多操作
 * 
 * @author chenhao
 *
 */
public class BigMemberCard extends AbstractCard
{

	private VLayout information = new VLayout();
	
	private HLayout operate = new HLayout();
	
	private Member member;
	
	
	public BigMemberCard(Member member,String width,String height)
	{
		this.member = member;
		this.setWidth( width );
		this.setHeight( height );
		init();
		addMember(information);
		addMember(operate);
	}
	
	private void init()
	{
		initLayout();
		initInformation();
		initOperate();
	}
	
	private void initLayout()
	{
		this.setMargin( 2 );
		this.setStyleName( "bigmembercardborder" );
		information.setHeight( "90%" );
		information.setWidth100( );
	}
	
	private void initInformation()
	{
		//个人信息
		VLayout baseinformation = new VLayout();
		baseinformation.setMargin( 20 );
		baseinformation.setAlign( Alignment.CENTER );
		baseinformation.setWidth( 500 );
		baseinformation.setHeight( 200 );
		baseinformation.setBorder( "2px solid #fffffb" );
		
		//名字
		Label name = new Label(member.getName( ));
		name.setHeight( 15 );
		name.setStyleName( "bigmembercardname" );
		
		//组织名称
		Label orgname = new Label(member.getOrgname( ));
		orgname.setHeight( 15 );
		orgname.setStyleName( "bigmembercardorgname" );
		
		//职位
		Label title = new Label( member.getTitle( ));
		title.setHeight( 15 );
		title.setStyleName( "bigmembercardtitle" );
		
		baseinformation.addMember( name );
		baseinformation.addMember( orgname );
		baseinformation.addMember( title );
		
		//简历版面
		VLayout resumeinformation = new VLayout();
		resumeinformation.setMargin( 20 );
		resumeinformation.setAlign( Alignment.CENTER );
		resumeinformation.setWidth( 500 );
		resumeinformation.setHeight( 200 );
		resumeinformation.setBorder( "2px solid #fffffb" );
		//简历
		Label resume = new Label(member.getResume( ));
		resume.setHeight( 15 );
		resume.setStyleName( "bigmembercardresume" );
		resumeinformation.addMember( resume );
		
		information.addMember( baseinformation );
		information.addMember( resumeinformation );
	}
	
	private void initOperate()
	{
		//操作
		operate.setAlign( Alignment.RIGHT );
		operate.setWidth100( );
		operate.setHeight( 16 );
		operate.setStyleName( "bigmembercardoppanel" );
		operate.setVisible( false );
		
/*		Img message = new Img("icons/16/message.png");
		message.setPadding( 5 );
		message.setSize( "16px", "16px" );
		message.setTooltip( "留言" );
		operate.addMember( message );
		
		Img telephone = new Img("crystal/16/actions/irc_online.png");
		telephone.setPadding( 5 );
		telephone.setSize( "16px", "16px" );
		telephone.setTooltip( "查看联系方式" );
		operate.addMember( telephone );
		
		Img kecheng = new Img("demoApp/icon_view.png");
		kecheng.setPadding( 5 );
		kecheng.setSize( "16px", "16px" );
		kecheng.setTooltip( "查看开设课程" );
		operate.addMember( kecheng );*/
	}
}
