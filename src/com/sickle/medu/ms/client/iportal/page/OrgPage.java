/**
 * 
 */
package com.sickle.medu.ms.client.iportal.page;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.iportal.IPageConst;
import com.sickle.medu.ms.client.iportal.card.BigOrgCard;
import com.sickle.medu.ms.client.rpc.OrgService;
import com.sickle.medu.ms.client.rpc.OrgServiceAsync;
import com.sickle.medu.ms.client.ui.page.AbstractPage;
import com.sickle.medu.ms.client.ui.tabpanel.AbstractTab;
import com.sickle.medu.ms.client.ui.util.AsyncCallbackWithStatus;
import com.sickle.medu.ms.client.ui.util.ScreenUtil;
import com.sickle.medu.ms.client.ui.widget.LabelWithWhite;
import com.sickle.medu.ms.client.ui.widget.LabelWithYellow;
import com.sickle.pojo.edu.Org;
import com.sickle.pojo.edu.School;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.TabSet;

/**
 * 机构查看详细页
 * 
 */
public class OrgPage extends AbstractPage {

	private static OrgPage instance = new OrgPage();

	private OrgPannel orgPannel;

	private SchoolPannel schoolPannel;

	public static OrgPage getInstance() {
		return instance;
	}

	private OrgPage() {
		super(IPageConst.PAGE_ORG);
		init();
	}

	private void init() {
		this.setWidth100();
		this.setHeight100();

		// 上部分
		this.addMember(getDefaultTopPanel());
		// 中间部分
		this.addMember(getOrgPanel());
		// 下部分
		this.addMember(getDefaultVersionPanel());
	}

	public void loadingOrg(int orgid) {
		final OrgServiceAsync service = OrgService.Util.getInstance();
		service.getOrgById(orgid, new AsyncCallbackWithStatus<Org>("加载机构名片") {
			@Override
			public void call(Org org) {
				orgPannel.setTitle(org.getName() + "的资料");
				orgPannel.fillpanel(org);
				schoolPannel.fillpanel(org);
			}
		});
	}

	private Canvas getOrgPanel() {
		VLayout orgrpage = new VLayout();
		orgrpage.setStyleName("orgpage");

		HLayout titlepanel = new HLayout();
		titlepanel.setHeight(ScreenUtil.getHeight(0.05));

		LabelWithYellow returnpage = new LabelWithYellow("返回首页");
		returnpage.setWidth(ScreenUtil.getWidth(0.1));
		returnpage.setHeight(ScreenUtil.getHeight(0.05));
		returnpage.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				History.newItem(IPageConst.PAGE_MEDU);
			}
		});

		LabelWithWhite title = new LabelWithWhite("查看学校详细信息");
		title.setAlign(Alignment.CENTER);
		title.setWidth(ScreenUtil.getWidth(0.9));
		title.setHeight(ScreenUtil.getHeight(0.05));

		titlepanel.addMember(returnpage);
		titlepanel.addMember(title);
		orgrpage.addMember(titlepanel);

		TabSet ts = new TabSet();
		ts.setUseSimpleTabs(true);
		ts.setSmoothFade(true);
		ts.setTabBarPosition(Side.LEFT);
		ts.setTabBarThickness(ScreenUtil.getWidthInt(0.1));

		orgPannel = new OrgPannel();
		schoolPannel = new SchoolPannel();

		ts.addTab(orgPannel);
		ts.addTab(schoolPannel);

		orgrpage.addMember(ts);
		return orgrpage;
	}

	class OrgPannel extends AbstractTab {
		private VLayout wholepanel;

		public OrgPannel() {
			super("机构信息", "", false);
		}

		@Override
		public Canvas getPanel() {
			wholepanel = new VLayout();
			return wholepanel;
		}

		public void fillpanel(Org org) {
			wholepanel.setWidth100();
			wholepanel.setHeight100();
			for (Canvas mem : wholepanel.getMembers()) {
				wholepanel.removeMember(mem);
			}
			wholepanel.addMember(new BigOrgCard(org, ScreenUtil.getWidth(0.89),
					ScreenUtil.getHeight(0.78)));
		}

	}

	class SchoolPannel extends AbstractTab {
		private VLayout schoolPannel;

		public SchoolPannel() {
			super("分校信息", "", false);
		}

		@Override
		public Canvas getPanel() {
			schoolPannel = new VLayout();
			return schoolPannel;
		}

		public void fillpanel(Org org) {
			schoolPannel.setWidth100();
			schoolPannel.setHeight100();
			schoolPannel.setStyleName("bigmembercardborder");
			ScreenUtil.clearLayout(schoolPannel);
			for (School school : org.getSchools()) {
				Layout sLayout = getDescPanel(school.getName());
				Label city = new Label("学校省市：" + school.getProvinceCity());
				city.setHeight(15);
				sLayout.addMember(city);

				Label addr = new Label("学校地址：" + school.getAddress());
				addr.setHeight(15);
				sLayout.addMember(addr);

				schoolPannel.addMember(sLayout);
			}
		}

		/**
		 * 获取带标题的panel
		 * 
		 * @param title
		 * @return
		 */
		private Layout getDescPanel(String title) {
			VLayout panel = new VLayout();
			panel.setMargin(20);
			panel.setAlign(Alignment.CENTER);
			panel.setAlign(VerticalAlignment.TOP);
			panel.setWidth(500);
			panel.setHeight(200);
			panel.setBorder("2px solid #fffffb");

			// titlepanel
			HLayout titlepanel = new HLayout();
			titlepanel.setStyleName("vtitle");
			titlepanel.setWidth(500);
			titlepanel.setHeight(20);
			titlepanel.setAlign(Alignment.CENTER);
			// title
			LabelWithYellow bstitle = new LabelWithYellow(title);
			titlepanel.addMember(bstitle);

			panel.addMember(titlepanel);

			return panel;
		}
	}

}
