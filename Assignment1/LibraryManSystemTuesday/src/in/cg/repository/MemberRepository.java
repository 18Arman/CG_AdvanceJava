package in.cg.repository;

import java.util.List;

import in.cg.model.Member;
import in.cg.service.MemberService;

public class MemberRepository {
	private List<Member> members;

	public MemberRepository(List<Member> members) {
		super();
		this.members = members;
	}
	public void addMember(Member m) {
		members.add(m);
	}
	public Member getMember(int id) {
		for(Member i:members) {
			if(i.getId()==id) {
				return i;
			}
		}
		return null;
	}
}
