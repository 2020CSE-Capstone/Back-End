package cse.capstonedesign.Capstone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import cse.capstonedesign.Capstone.dto.request.InsertWritingRequestDTO;
import cse.capstonedesign.Capstone.dto.request.UpdateWritingRequestDTO;
import cse.capstonedesign.Capstone.dto.response.DefaultResponse;
import cse.capstonedesign.Capstone.dto.response.WritingDetailResponseDTO;
import cse.capstonedesign.Capstone.dto.response.WritingSimpleResponseDTO;
import cse.capstonedesign.Capstone.mapper.CommunityMapper;
import cse.capstonedesign.Capstone.model.Response;

@Service
public class CommunityService {

	private final CommunityMapper communityMapper;

	public CommunityService(CommunityMapper communityMapper) {
		this.communityMapper = communityMapper;
	}

	public ResponseEntity getRecentAllWritings() {
		Response response;
		
		if(communityMapper.getRecentAllWritings() != null) {
			response = new Response("200", "최신 게시글 리스트 조회 성공", communityMapper.getRecentAllWritings().stream().map(WritingSimpleResponseDTO::of).collect(Collectors.toList()));
			return DefaultResponse.ok(response);
		}else {
			response = new Response("400", "최신 게시글 리스트 조회 실패", null);
			return DefaultResponse.badRequest(response);
		}
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
