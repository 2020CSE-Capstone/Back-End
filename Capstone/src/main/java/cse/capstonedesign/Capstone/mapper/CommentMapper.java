package cse.capstonedesign.Capstone.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cse.capstonedesign.Capstone.dto.request.GetCommentReplyRequestDTO;
import cse.capstonedesign.Capstone.dto.request.InsertCommentRequestDTO;
import cse.capstonedesign.Capstone.model.Comment;

@Mapper
public interface CommentMapper {
	public List<Comment> getAllComments(@Param("board_no") int board_no);
	
	public int getCommentCount(@Param("board_no") int board_no);
	
	public List<Comment> getAllReplyComments(@Param("board_no") int board_no, @Param("comment_no") int comment_no);
	
	public int insertComment(@Param("comment") InsertCommentRequestDTO comment);
}
