/**
 * 
 */
package com.sickle.medu.ms.client.iportal.card;

import com.sickle.medu.ms.client.ui.widget.LinkLabel;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
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
		information.setHeight100( );
		information.setWidth100( );
	}
	
	private void initInformation()
	{
		//个人信息
		Layout baseinformation = getDescPanel("基本信息");
		
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
		
		//地址
		Label address = new Label( member.getCity( ) + "." + member.getArea( ) );
		address.setHeight( 15 );
		address.setStyleName( "bigmembercardtitle" );
		
		baseinformation.addMember( name );
		baseinformation.addMember( orgname );
		baseinformation.addMember( title );
		baseinformation.addMember( address );
		
		//简历版面
		Layout resumeinformation = getDescPanel("个人简历");
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
	
	/**
	 * 获取带标题的panel
	 * 
	 * @param title
	 * @return
	 */
	private Layout getDescPanel(String title)
	{
		VLayout panel = new VLayout();
		panel.setMargin( 20 );
		panel.setAlign( Alignment.CENTER );
		panel.setAlign( VerticalAlignment.TOP );
		panel.setWidth( 500 );
		panel.setHeight( 200 );
		panel.setBorder( "2px solid #fffffb" );
		
		//titlepanel
		HLayout titlepanel = new HLayout();
		titlepanel.setStyleName( "vtitle" );
		titlepanel.setWidth( 500 );
		titlepanel.setHeight( 20 );
		titlepanel.setAlign( Alignment.CENTER );
		//title
		LinkLabel bstitle = new LinkLabel( title,false );
		titlepanel.addMember( bstitle );
		
		
		panel.addMember( titlepanel );
		
		return panel;
	}
}
