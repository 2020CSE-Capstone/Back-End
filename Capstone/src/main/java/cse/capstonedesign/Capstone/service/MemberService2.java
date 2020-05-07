package cse.capstonedesign.Capstone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cse.capstonedesign.Capstone.model.Member;

@Service
public class MemberService2 {
	private List<Member> members = new ArrayList<>();
	private int autoIncrement = 1;

	public Member saveMember(Member newMember) { 
		for (Member member : members) {
			if (member.getEmail().equals(newMember.getEmail())) {
				return null;
			}
		}
		
		newMember.setId(autoIncrement++);
		members.add(newMember);

		return newMember;
	}

	public List<Member> getAllMembers() {
		return members;
	}

	public Member getMemberById(int memberId) {
		for (Member member : members) {
			if (member.getId() == memberId) {
				return member;
			}
		}
		return null;
	}

	public Member putMember(int memberId, Member puttedMember) {
		for (Member member : members) {
			if (member.getId() == memberId) {
				member.setEmail(puttedMember.getEmail());
				member.setPassword(puttedMember.getPassword());
				member.setName(puttedMember.getName());
				member.setPhoneNumber(puttedMember.getPhoneNumber());
				return member;
			}
		}
		puttedMember.setId(autoIncrement++);
		members.add(puttedMember);
		return puttedMember;
	}

	public Member deleteMember(int memberId) {
		for (Member member : members) {
			if (member.getId() == memberId) {
				members.remove(member);
				return member;
			}
		}
		return null;
	}
}