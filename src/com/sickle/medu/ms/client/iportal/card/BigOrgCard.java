/**
 * 
 */
package com.sickle.medu.ms.client.iportal.card;

import com.sickle.medu.ms.client.ui.widget.LabelWithYellow;
import com.sickle.pojo.edu.Org;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 机构大名片
 * 
 * 更详尽更多内容更多操作
 * 
 * @author chenhao
 *
 */
public class BigOrgCard extends AbstractCard
{

	private VLayout information = new VLayout();
	
	private HLayout operate = new HLayout();
	
	private Org org;
	
	
	public BigOrgCard(Org org,String width,String height)
	{
		this.org = org;
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
		Layout baseinformation = getDescPanel("基本信息");
		
		//名字
		Label name = new Label("学校名称：" + org.getName( ));
		name.setHeight( 15 );
		name.setStyleName( "bigmembercardname" );

		baseinformation.addMember( name );
		
		Label tel= new Label("联系电话："+org.getTelephone());
		tel.setHeight(15);
		tel.setStyleName("bigmembercardname");
		baseinformation.addMember(tel);
		
		Label city = new Label("学校省市：" + org.getProvinceCity());
		city.setHeight(15);
		city.setStyleName("bigmembercardname");
		baseinformation.addMember(city);
		
		Label addr = new Label("学校地址：" + org.getAddress());
		addr.setHeight(15);
		addr.setStyleName("bigmembercardname");
		baseinformation.addMember(addr);
		
		//分校信息
		Layout schoolLayout = getDescPanel("学校简介");
		Label introduction = new Label(org.getIntroduction());
		schoolLayout.addMember(introduction);
		
		information.addMember( baseinformation );
		information.addMember( schoolLayout );
	}
	
	private void initOperate()
	{
		//操作
		operate.setAlign( Alignment.RIGHT );
		operate.setWidth100( );
		operate.setHeight( 16 );
		operate.setStyleName( "bigmembercardoppanel" );
		operate.setVisible( false );
		
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
		LabelWithYellow bstitle = new LabelWithYellow( title );
		titlepanel.addMember( bstitle );
		
		panel.addMember( titlepanel );
		
		return panel;
	}
}
