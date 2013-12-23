/**
 * 
 */
package com.sickle.medu.ms.client.iportal.card;

import java.util.Date;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.iportal.IPageConst;
import com.sickle.medu.ms.client.iportal.dialog.SendMessageDialog;
import com.sickle.medu.ms.client.iportal.page.IndexPage;
import com.sickle.medu.ms.client.ui.widget.label.LabelWithWhite;
import com.sickle.pojo.edu.Member;
import com.sickle.pojo.edu.Org;
import com.sickle.pojo.website.Message;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
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
		super();
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
		initOperate();
	}

	private void initLayout() {
		this.setMargin(2);
		this.setStyleName("orgcardborder");
		information.setHeight("90%");
		information.setWidth100();
		//operate.setHeight("10%");
		//operate.setWidth100();
		//operate.setAlign(Alignment.RIGHT);
		this.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				setStyleName("orgcardborder-mousein");
				operate.setVisible(true);
			}
		});
		this.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				setStyleName("orgcardborder");
				operate.setVisible(false);
			}
		});
		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				History.newItem(IPageConst.PAGE_ORG + IPageConst.PAGE_EQ
						+ org.getId());
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

	private void initOperate() {
		// 操作
		operate.setAlign(Alignment.RIGHT);
		operate.setWidth100();
		//operate.setHeight("10%");
		operate.setVisible(false);
		ClickHandler msg = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Member send = IndexPage.getInstance().getTopbar().getMember();
				Message msg = new Message();
				msg.setReceiver(org.getId());
				msg.setSend(send.getId());
				msg.setReceivetime(new Date());

				SendMessageDialog messagedialog = new SendMessageDialog() {
					@Override
					public void preSubmit(DynamicForm form) {
						Member send = IndexPage.getInstance().getTopbar()
								.getMember();
						form.setValue("send", send.getId());
						form.setValue("receiver", org.getId());
						form.setValue("receivetime", new Date());
					}
				};

				messagedialog.show();
			}
		};
		ClickHandler evaluate = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				
			}
		};
		ClickHandler praise = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				
			}
		};
		Canvas detail = getControlWidget("赞一下", praise, 50, "#694d9f");
		Canvas message = getControlWidget("留言", msg, 40, "#1d953f");
		Canvas report = getControlWidget("评价", evaluate, 40, "#6d5826");

		operate.addMember(detail);
		operate.addMember(message);
		operate.addMember(report);
	}

	private Canvas getControlWidget(String controlname, ClickHandler cl,
			int width, final String backgroundColor) {
		final HLayout operate = new HLayout();
		operate.setWidth(width);
		operate.setAlign(Alignment.CENTER);
		operate.setStyleName("orgcard-operate");
		operate.setBackgroundColor(backgroundColor);

		LabelWithWhite operatelabel = new LabelWithWhite(controlname, true);
		operatelabel.addClickHandler(cl);
		operatelabel.setWidth(width);
		operate.addMember(operatelabel);
		operate.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				operate.setStyleName("orgcard-operate-mousein");
				operate.setBackgroundColor("#e0861a");
			}
		});
		operate.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				operate.setStyleName("membercard-operate");
				operate.setBackgroundColor(backgroundColor);
			}
		});
		return operate;
	}
}
