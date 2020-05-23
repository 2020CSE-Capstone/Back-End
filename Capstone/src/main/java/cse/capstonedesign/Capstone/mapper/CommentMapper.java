package cse.capstonedesign.Capstone.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cse.capstonedesign.Capstone.model.Comment;

@Mapper
public interface CommentMapper {
	public List<Comment> getAllComments(@Param("board_no") int board_no);
}
