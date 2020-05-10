package cse.capstonedesign.Capstone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cse.capstonedesign.Capstone.dto.request.InsertMemberRequestDTO;
import cse.capstonedesign.Capstone.dto.request.UpdateMemberRequestDTO;
import cse.capstonedesign.Capstone.dto.response.MemberDetailResponseDTO;
import cse.capstonedesign.Capstone.dto.response.MemberSimpleResponseDTO;
import cse.capstonedesign.Capstone.mapper.MemberMapper;

@Service
public class MemberService {

	private final MemberMapper memberMapper;

	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	public boolean saveMember(InsertMemberRequestDTO newMember) {
		return memberMapper.insertMember(newMember) != 0;
	}

	public List<MemberSimpleResponseDTO> getAllMembers() {
		return memberMapper.getAllMembers().stream().map(MemberSimpleResponseDTO::of).collect(Collectors.toList());
	}

	public MemberDetailResponseDTO getMemberById(int memberId) {
		return MemberDetailResponseDTO.of(memberMapper.getMemberById(memberId));
	}

	public boolean putMember(int memberId, UpdateMemberRequestDTO puttedMember) {
		return memberMapper.updateMember(memberId, puttedMember) != 0;
	}

	public boolean deleteMember(int memberId) {
		return memberMapper.deleteMember(memberId) != 0;
	}
}
