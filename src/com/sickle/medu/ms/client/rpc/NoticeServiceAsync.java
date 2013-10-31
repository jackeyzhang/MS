package com.sickle.medu.ms.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sickle.pojo.edu.Notice;


public interface NoticeServiceAsync
{

	void listAllNotice( int startIndex, int length,
			AsyncCallback<List<Notice>> callback );

	void addNotice( Notice notice, AsyncCallback<Notice> callback );

	void deleteNotice( Notice notice, AsyncCallback<Notice> callback );

}
