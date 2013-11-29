/**
 * 
 */
package com.sickle.medu.ms.client.iportal.card;

import com.sickle.medu.ms.client.iportal.IPageConst;
import com.sickle.medu.ms.client.iportal.dialog.ModifyMemberDialog;
import com.sickle.medu.ms.client.ui.widget.LabelWithYellow;
import com.sickle.medu.ms.client.ui.widget.MButton;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Img;
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
	
	private Member member;
	
	private boolean showModify = false;;
	
	public BigMemberCard(boolean showModify,Member member,String width,String height)
	{
		this.showModify = showModify;
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
		
		String icon = member.getIcon( );
		if( icon == null || icon.length( ) == 0 )
		{
			icon = IPageConst.DEFAULT_HEAD_ICON;
		}
		
		Img img = new Img(icon,60,60);
		
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
		
		baseinformation.addMember( img );
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
		
		//修改信息
		HLayout buttonpanel = new HLayout();
		buttonpanel.setAlign( Alignment.CENTER );
		buttonpanel.setWidth( 500 );
		MButton modify = new MButton( "修改个人信息", "150px" ){
			@Override
			public void handleClick( )
			{
				new ModifyMemberDialog(member).show();
			}
		};
		buttonpanel.addMember( modify );
		
		information.addMember( baseinformation );
		information.addMember( resumeinformation );
		if( showModify )
		{
			information.addMember( buttonpanel );
		}
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
		LabelWithYellow bstitle = new LabelWithYellow( title,false );
		titlepanel.addMember( bstitle );
		
		panel.addMember( titlepanel );
		
		return panel;
	}
}
