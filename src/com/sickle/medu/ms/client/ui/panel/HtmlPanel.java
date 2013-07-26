
package com.sickle.medu.ms.client.ui.panel;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.HTMLPane;

/**
 * 可以包含html的panel
 * 
 * @author chenhao
 *
 */
public class HtmlPanel extends HTMLPane {
	
    public HtmlPanel(String htmlurl) {
        setContentsURL(htmlurl);
        setOverflow(Overflow.AUTO);
        setStyleName("defaultBorder");
        setPadding(10);
    }
}