package cse.capstonedesign.Capstone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cse.capstonedesign.Capstone.mapper.MemberMapper;
import cse.capstonedesign.Capstone.model.Member;

@Service
public class MemberService {

	private final MemberMapper memberMapper;

	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	public boolean saveMember(Member newMember) {
		return memberMapper.insertMember(newMember) != 0;
	}

	public List<Member> getAllMembers() {
		return memberMapper.getAllMembers();
	}

	public Member getMemberById(int memberId) {
		return memberMapper.getMemberById(memberId);
	}

	public boolean putMember(int memberId, Member puttedMember) {
		return memberMapper.updateMember(memberId, puttedMember) != 0;
	}

	public boolean deleteMember(int memberId) {
		return memberMapper.deleteMember(memberId) != 0;
	}
}
