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
		
		if(!communityMapper.getRecentAllWritings().isEmpty()) {
			response = new Response("200", "�ֽ� �Խñ� ����Ʈ ��ȸ ����", communityMapper.getRecentAllWritings().stream().map(WritingSimpleResponseDTO::of).collect(Collectors.toList()));
			return DefaultResponse.ok(response);
		}else {
			response = new Response("400", "�ֽ� �Խñ� ����Ʈ�� �������� �ʽ��ϴ�.", null);
			return DefaultResponse.ok(response);
		}
	}
	
	public ResponseEntity getLikeAllWritings() {
		Response response;
		
		if(!communityMapper.getLikeAllWritings().isEmpty()) {
			response = new Response("200", "�α� �Խñ� ����Ʈ ��ȸ ����", communityMapper.getLikeAllWritings().stream().map(WritingSimpleResponseDTO::of).collect(Collectors.toList()));
			return DefaultResponse.ok(response);
		}else {
			response = new Response("200", "�α� �Խñ� ����Ʈ�� �������� �ʽ��ϴ�.", null);
			return DefaultResponse.ok(response);
		}
	}
	
	public ResponseEntity getUserAllWritings(@PathVariable("user_id") int user_id) {
		Response response;
		
		if(!communityMapper.getUserAllWritings(user_id).isEmpty()) {
			response = new Response("200", "���� �ۼ��� �Խñ� ����Ʈ ��ȸ ����", communityMapper.getUserAllWritings(user_id).stream().map(WritingSimpleResponseDTO::of).collect(Collectors.toList()));
			return DefaultResponse.ok(response);
		}else {
			response = new Response("200", "���� �ۼ��� �Խñ� ����Ʈ�� �������� �ʽ��ϴ�.", null);
			return DefaultResponse.ok(response);
		}
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
