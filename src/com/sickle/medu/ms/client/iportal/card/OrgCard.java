/**
 * 
 */
package com.sickle.medu.ms.client.iportal.card;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.pojo.edu.Org;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * 学校名片
 * 
 * @author chenhao
 * 
 */
public class OrgCard extends AbstractCard {

	private HLayout information = new HLayout();

	private HLayout operate = new HLayout();

	private Org org;

	public OrgCard(Org org, String width, String height) {
		this.org = org;
		this.setWidth(width);
		this.setHeight(height);
		init();
		addMember(information);
		addMember(operate);
	}

	private void init() {
		initLayout();
		initInformation();
	}

	private void initLayout() {
		this.setMargin(2);
		this.setStyleName("orgcardborder");
		information.setHeight("90%");
		information.setWidth100();
		operate.setHeight("10%");
		operate.setWidth100();
		operate.setAlign(Alignment.RIGHT);
		this.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				setStyleName("orgcardborder-mousein");
			}
		});
		this.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				setStyleName("orgcardborder");
			}
		});
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				History.newItem(IPageConst.PAGE_ORG + IPageConst.PAGE_EQ + org.getId());
			}
		});
	}

	private void initInformation() {
		VLayout leftLayout = new VLayout();
		leftLayout.setWidth("35%");
		leftLayout.setHeight("100%");
		Img img = new Img(IPageConst.DEFAULT_ORG_ICON, 100, 40);
		leftLayout.addMember(img);
		Label orgName = new Label("学校名称：" + org.getName());
		leftLayout.addMember(orgName);
		leftLayout.setAlign(Alignment.LEFT);
		information.addMember(leftLayout);

		VLayout rightLayout = new VLayout();
		leftLayout.setWidth("65%");
		leftLayout.setHeight("100%");
		Label name = new Label("学校名称：" + org.getName());
		name.setHeight("15px");
		Label provinceCity = new Label("学校省市：" + org.getProvinceCity());
		provinceCity.setHeight("15px");

		Label address = new Label("学校地址：" + org.getAddress());
		address.setHeight("15px");

		Label telephone = new Label("电话：" + org.getTelephone());
		telephone.setHeight("15px");
		rightLayout.addMember(name);
		rightLayout.addMember(telephone);
		rightLayout.addMember(provinceCity);
		rightLayout.addMember(address);
		rightLayout.setAlign(Alignment.LEFT);

		information.addMember(rightLayout);
	}
}
