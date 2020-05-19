package cse.capstonedesign.Capstone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import cse.capstonedesign.Capstone.dto.request.InsertWritingRequestDTO;
import cse.capstonedesign.Capstone.dto.request.UpdateWritingRequestDTO;
import cse.capstonedesign.Capstone.dto.response.WritingDetailResponseDTO;
import cse.capstonedesign.Capstone.dto.response.WritingSimpleResponseDTO;
import cse.capstonedesign.Capstone.mapper.CommunityMapper;

@Service
public class CommunityService {

	private final CommunityMapper communityMapper;

	public CommunityService(CommunityMapper communityMapper) {
		this.communityMapper = communityMapper;
	}

	public List<WritingSimpleResponseDTO> getRecentAllWritings() {
		return communityMapper.getRecentAllWritings().stream().map(WritingSimpleResponseDTO::of).collect(Collectors.toList());
	}
	
	public List<WritingSimpleResponseDTO> getLikeAllWritings() {
		return communityMapper.getLikeAllWritings().stream().map(WritingSimpleResponseDTO::of).collect(Collectors.toList());
	}
	
	public List<WritingSimpleResponseDTO> getUserAllWritings(@PathVariable("user_id") int user_id) {
		return communityMapper.getUserAllWritings(user_id).stream().map(WritingSimpleResponseDTO::of).collect(Collectors.toList());
	}

	public WritingDetailResponseDTO getWritingDetailByNo(@PathVariable("board_no") int board_no) {
		return WritingDetailResponseDTO.of(communityMapper.getWritingDetailByNo(board_no));
	}

	public boolean insertWriting(@RequestBody InsertWritingRequestDTO newWriting) {
		return communityMapper.insertWriting(newWriting) != 0;
	}

	public boolean updateWriting(@PathVariable("board_no") int board_no, @RequestBody UpdateWritingRequestDTO updated_writing) {
		return communityMapper.updateWriting(board_no, updated_writing) != 0;
	}

	public boolean deleteWriting(@PathVariable("board_no") int board_no) {
		return communityMapper.deleteWriting(board_no) != 0;
	}
}
