package cse.capstonedesign.Capstone.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cse.capstonedesign.Capstone.dto.request.InsertWritingRequestDTO;
import cse.capstonedesign.Capstone.dto.request.UpdateWritingRequestDTO;
import cse.capstonedesign.Capstone.model.Writing;

@Mapper
public interface CommunityMapper {
	public List<Writing> getRecentAllWritings();
	
	public List<Writing> getLikeAllWritings();
	
	public List<Writing> getUserAllWritings();

	public Writing getWritingDetailById(@Param("board_no") int board_no);

	public int insertWriting(@Param("writing") InsertWritingRequestDTO writing);

	public int updateWriting(@Param("board_no") int board_no, @Param("writing") UpdateWritingRequestDTO writing);

	public int deleteWriting(@Param("board_no") int board_no);
}
