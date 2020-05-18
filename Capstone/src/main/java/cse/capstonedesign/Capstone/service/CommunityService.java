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

	public boolean insertWriting(@RequestBody InsertWritingRequestDTO newWriting) {
		return communityMapper.insertWriting(newWriting) != 0;
	}

	public List<WritingSimpleResponseDTO> getAllWritings() {
		return communityMapper.getAllWritings().stream().map(WritingSimpleResponseDTO::of).collect(Collectors.toList());
	}

	public WritingDetailResponseDTO getWritingDetailById(@PathVariable("board_no") int board_no) {
		return WritingDetailResponseDTO.of(communityMapper.getWritingDetailById(board_no));
	}

	public boolean updateWriting(@PathVariable("board_no") int board_no, @RequestBody UpdateWritingRequestDTO updated_writing) {
		return communityMapper.updateWriting(board_no, updated_writing) != 0;
	}

	public boolean deleteWriting(@PathVariable("board_no") int board_no) {
		return communityMapper.deleteWriting(board_no) != 0;
	}
}
