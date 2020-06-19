package cse.capstonedesign.Capstone.service;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import cse.capstonedesign.Capstone.dto.request.InsertCommentReplyRequestDTO;
import cse.capstonedesign.Capstone.dto.request.InsertCommentRequestDTO;
import cse.capstonedesign.Capstone.dto.request.UpdateCommentRequestDTO;
import cse.capstonedesign.Capstone.dto.response.CommentResponseDTO;
import cse.capstonedesign.Capstone.dto.response.DefaultResponse;
import cse.capstonedesign.Capstone.mapper.CommentMapper;
import cse.capstonedesign.Capstone.model.Response;

@Service
public class CommentService {

	private final CommentMapper commentMapper;

	public CommentService(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}

	public ResponseEntity getAllComments(@PathVariable("board_no") int board_no) {
		Response response;

		response = new Response("200", "댓글 리스트 조회 성공", commentMapper.getAllComments(board_no).stream()
				.map(CommentResponseDTO::of).collect(Collectors.toList()));
		return DefaultResponse.ok(response);

//		return commentMapper.getAllComments(board_no).stream().map(CommentResponseDTO::of).collect(Collectors.toList());
	}

	public ResponseEntity getAllReplyComments(@RequestParam("board_no") int board_no,
			@RequestParam("comment_no") int comment_no) {
		Response response;

		response = new Response("200", "대댓글 리스트 조회 성공", commentMapper.getAllReplyComments(board_no, comment_no).stream()
				.map(CommentResponseDTO::of).collect(Collectors.toList()));
		return DefaultResponse.ok(response);

//		return commentMapper.getAllReplyComments(board_no,comment_no).stream().map(CommentResponseDTO::of).collect(Collectors.toList());
	}

	public ResponseEntity insertComment(@RequestBody InsertCommentRequestDTO newComment) {
		Response response;

		if (commentMapper.insertComment(newComment) != 0) {
			response = new Response("200", "댓글 삽입 성공", true);
			return DefaultResponse.ok(response);
		} else {
			response = new Response("400", "댓글 삽입 실패", false);
			return DefaultResponse.badRequest(response);
		}

//		return commentMapper.insertComment(newComment) != 0;
	}

	public ResponseEntity insertCommentReply(@RequestBody InsertCommentReplyRequestDTO newComment) {
		Response response;

		if (commentMapper.insertCommentReply(newComment) != 0) {
			response = new Response("200", "대댓글 수정 성공", true);
			return DefaultResponse.ok(response);
		} else {
			response = new Response("400", "대댓글 수정 실패", false);
			return DefaultResponse.badRequest(response);
		}

//		return commentMapper.insertCommentReply(newComment) != 0;
	}

	public ResponseEntity updateComment(@PathVariable("comment_no") int comment_no,
			@RequestBody UpdateCommentRequestDTO updatedComment) {
		Response response;

		if (commentMapper.updateComment(comment_no, updatedComment) != 0) {
			response = new Response("200", "댓글 수정 성공", true);
			return DefaultResponse.ok(response);
		} else {
			response = new Response("400", "댓글 수정 실패", false);
			return DefaultResponse.badRequest(response);
		}

//		return commentMapper.updateComment(comment_no, updatedComment) != 0;
	}
}
