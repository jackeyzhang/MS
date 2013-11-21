/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.Member/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.sickle.medu.ms.server.rpc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sickle.dao.DaoServiceFactory;
import com.sickle.dto.MemberDTO;
import com.sickle.exception.CodeException;
import com.sickle.medu.ms.client.rpc.MemberService;
import com.sickle.pojo.edu.Member;
import com.sickle.service.itf.IMemberService;

public class MemberServiceImpl extends RemoteServiceServlet implements MemberService {

	private static final long serialVersionUID = -3779445533342577760L;
	
	private static IMemberService service = null;
	

	@Override
	public void init( ) throws ServletException
	{
		super.init( );
		try
		{
			service = DaoServiceFactory.getService( IMemberService.class );
		}
		catch ( CodeException e )
		{
			e.printStackTrace();
		}
	}



	@Override
	public List<Member> listAllMember(int startIndex,int length )
	{
		List<Member> members = null;
		try
		{
			members = service.listMembers(startIndex, length );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		if( members == null )
		{
			members = new ArrayList<Member>();
		}
		return new MemberDTO().to( members );
	}



	@Override
	public Member addMember( Member Member ) throws Exception
	{
		Member oMember = service.addMember( Member );
		return new MemberDTO().to( oMember );
	}



	@Override
	public Member deleteMember( Member Member ) throws Exception
	{
		if( service.removeMemberById( Member.getId( ) ))
		{
			return new MemberDTO().to( Member );
		}
		return null;
	}



	@Override
	public Member findMember( int id ) throws Exception
	{
		Member oMember = service.getMemberById( id );
		return new MemberDTO().to( oMember );
	}



	@Override
	public Member modifyMember( Member member ) throws Exception
	{
		Member m = service.modifyMember( member );
		return new MemberDTO().to( m );
	}

}
