package in.cg.service;

import in.cg.model.Member;
import in.cg.repository.MemberRepository;

public class MemberService {

    private MemberRepository mRepo;
    private int memberCounter = 4;

    public MemberService(MemberRepository mRepo) {
        this.mRepo = mRepo;
    }

    public void registerMember(String name, String email) {
        Member m = new Member(memberCounter++, name, email);
        mRepo.addMember(m);
        System.out.println("Member registered successfully");
    }

    public Member fetchMember(int id) {
        return mRepo.getMember(id);
    }
}