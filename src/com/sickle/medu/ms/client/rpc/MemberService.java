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
package com.sickle.medu.ms.client.rpc;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sickle.pojo.edu.Member;

@RemoteServiceRelativePath("MemberService")
public interface MemberService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static MemberServiceAsync instance;
		public static MemberServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(MemberService.class);
			}
			return instance;
		}
	}
	
	public List<Member> listAllMember(int startIndex,int length );
	
	public Member addMember(Member Member) throws Exception;
	
	public Member modifyMember(Member Member) throws Exception;
	
	public Member deleteMember(Member Member)throws Exception;
	
	public Member findMember(int id)throws Exception;
	
}
