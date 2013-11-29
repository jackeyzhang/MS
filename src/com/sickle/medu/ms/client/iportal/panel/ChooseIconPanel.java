/**
 * 
 */

package com.sickle.medu.ms.client.iportal.panel;

import com.sickle.medu.ms.client.iportal.IPageConst;
import com.sickle.medu.ms.client.ui.widget.MagicShow;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * 选择图标面板
 * 
 * @author chenhao
 * 
 */
public class ChooseIconPanel extends HLayout
{

	private Img defaultIcon = new Img( IPageConst.CHOOSE_ICON );
	
	private HeadIconPopupPanel iconpanel = new HeadIconPopupPanel( ){
		@Override
		public void chooseCallback( String chooseicon )
		{
			defaultIcon.setSrc( chooseicon );
		}
	};

	public ChooseIconPanel()
	{
		super();
		this.setWidth( 120 );
		this.setAlign( Alignment.RIGHT );
		
		MagicShow.addHighlightWhenMouseOver( defaultIcon );
		defaultIcon.setSize("50px", "50px");
		defaultIcon.setCursor( Cursor.POINTER );
		defaultIcon.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				iconpanel.show( );
			}
		} );
		
		Label chooseicon = new Label("选择你喜欢的头像");
		chooseicon.setHeight( 30 );
		
		HLayout defaulticonl = new HLayout( );
		defaulticonl.setWidth100( );
		defaulticonl.setHeight( 40 );
		defaulticonl.setAlign( Alignment.CENTER );
		defaulticonl.addMember( defaultIcon );
		
		VLayout vl = new VLayout();
		vl.setWidth( 100 );
		vl.setAlign( VerticalAlignment.CENTER );
		
		vl.addMember( defaulticonl );
		vl.addMember( chooseicon );
		
		addMember( vl );
	}

	public String getChooseIcon( )
	{
		return iconpanel.getHeadIcon( );
	}
	
	public void setIcon(String iconsrc){
		defaultIcon.setSrc( iconsrc );
	}
}
