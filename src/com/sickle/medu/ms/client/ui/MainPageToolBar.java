/**
 * 
 */
package com.sickle.medu.ms.client.ui;

import com.sickle.medu.ms.client.ui.dialog.UILoginDialog;
import com.sickle.medu.ms.client.ui.help.AboutAuthorDialog;
import com.sickle.medu.ms.client.ui.help.VersionDialog;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.IconButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.menu.IconMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.toolbar.RibbonGroup;
import com.smartgwt.client.widgets.toolbar.ToolStrip;


/**
 * 主界面工具栏
 * 
 * @author chenhao
 *
 */
public class MainPageToolBar extends ToolStrip
{

	public MainPageToolBar()
	{
        setLeft(0);  
        setTop(75);  
        setWidth100();  
  
        setMembersMargin(2);  
        setLayoutMargin(2);  
  
        Menu menu = new Menu();  
          
        menu.addItem(new MenuItem("Document", "icons/16/document_plain_new.png", "Ctrl+D"));  
        menu.addItem(new MenuItem("Picture", "icons/16/folder_out.png", "Ctrl+P"));  
        menu.addItem(new MenuItem("Email", "icons/16/disk_blue.png", "Ctrl+E"));  
  
        RibbonGroup fileGroup = new RibbonGroup();  
        fileGroup.setTitle("个人工作台");  
        fileGroup.setTitleAlign(Alignment.LEFT);  
        fileGroup.setNumRows(3);  
        fileGroup.setRowHeight(26);  
        fileGroup.addControl(getIconMenuButton("New", "piece_blue", menu, true));  
        fileGroup.addControl(getIconButton("Open", "star_yellow", true));  
        fileGroup.addControl(getIconButton("Save", "pawn_red", true));  
        fileGroup.addControl(getIconMenuButton("Save As", "cube_green", menu, true));  
  
        RibbonGroup editGroup = new RibbonGroup();  
        editGroup.setTitle("Edit");  
        editGroup.setNumRows(3);  
        editGroup.setRowHeight(26);  
        editGroup.addControl(getIconButton("Edit", "piece_blue", false));  
        editGroup.addControl(getIconButton("Copy", "pawn_green", false));  
        editGroup.addControl(getIconButton("Paste", "cube_yellow", false));  
        editGroup.addControl(getIconMenuButton("Undo", null, menu, false));  
        editGroup.addControl(getIconMenuButton("Redo", null, menu, false));  
  
  
        RibbonGroup insertGroup = new RibbonGroup();  
        insertGroup.setTitle("帮助");  
        insertGroup.setNumRows(3);  
        insertGroup.setRowHeight(26);  
        insertGroup.addControl(getIconMenuButton("Picture", null, menu, true));  
        
        IconButton b = getIconButton("帮助内容", "pawn_white", false);
        b.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				UILoginDialog.getInstance( ).show( );
			}
		} );
        insertGroup.addControl(b);  
        
        IconButton aboutVersion = getIconButton("版本信息", "star_yellow", false);
        aboutVersion.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				new VersionDialog().show( );
			}
		} );
        insertGroup.addControl(aboutVersion);  
        
        IconButton aboutSf = getIconButton("关于该软件", "piece_red", false);
        aboutSf.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				new AboutAuthorDialog().show( );
			}
		} );
        insertGroup.addControl(aboutSf);  
  
        addMember(fileGroup);  
        addMember(editGroup);  
        addMember(insertGroup);  
    }  
  
    private IconButton getIconButton(String title, String iconName, boolean vertical) {  
        IconButton button = new IconButton(title);  
        button.setTitle(title);  
        if (iconName == null) iconName = "cube_blue";  
        button.setIcon("pieces/16/" + iconName + ".png");  
        button.setLargeIcon("pieces/48/" + iconName + ".png");  
        if (vertical == true) button.setOrientation("vertical");  
        return button;  
    }  
  
    private IconMenuButton getIconMenuButton(String title, String iconName, Menu menu, boolean vertical) {  
        IconMenuButton button = new IconMenuButton();  
        button.setTitle(title);  
        if (iconName == null) iconName = "cube_blue";  
        button.setIcon("pieces/16/" + iconName + ".png");  
        button.setLargeIcon("pieces/48/" + iconName + ".png");  
        if (vertical == true) button.setOrientation("vertical");  
        if (menu != null) button.setMenu(menu);  
  
        button.setShowMenuIcon(true);  
        return button;  
    }  
}
