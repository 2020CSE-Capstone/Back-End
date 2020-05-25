package cse.capstonedesign.Capstone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import cse.capstonedesign.Capstone.dto.request.InsertCommentReplyRequestDTO;
import cse.capstonedesign.Capstone.dto.request.InsertCommentRequestDTO;
import cse.capstonedesign.Capstone.dto.response.CommentResponseDTO;
import cse.capstonedesign.Capstone.mapper.CommentMapper;

@Service
public class CommentService {

	private final CommentMapper commentMapper;

	public CommentService(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}

	public List<CommentResponseDTO> getAllComments(@PathVariable("board_no") int board_no) {
		return commentMapper.getAllComments(board_no).stream().map(CommentResponseDTO::of).collect(Collectors.toList());
	}
	
	public List<CommentResponseDTO> getAllReplyComments(@RequestParam("board_no") int board_no, @RequestParam("comment_no") int comment_no) {
		return commentMapper.getAllReplyComments(board_no,comment_no).stream().map(CommentResponseDTO::of).collect(Collectors.toList());
	}

	public boolean insertComment(@RequestBody InsertCommentRequestDTO newComment) {
		return commentMapper.insertComment(newComment) != 0;
	}

	public boolean insertCommentReply(@RequestBody InsertCommentReplyRequestDTO newComment) {
		return commentMapper.insertCommentReply(newComment) != 0;
	}
}
