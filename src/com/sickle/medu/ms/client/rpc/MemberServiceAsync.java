package com.sickle.medu.ms.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sickle.pojo.edu.Member;


public interface MemberServiceAsync
{

	void addMember( Member Member, AsyncCallback<Member> callback );

	void deleteMember( Member Member, AsyncCallback<Member> callback );

	void listAllMember( int startIndex,int length , AsyncCallback<List<Member>> callback );

}
