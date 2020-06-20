package cse.capstonedesign.Capstone.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cse.capstonedesign.Capstone.dto.request.SignUpRequestDTO;
import cse.capstonedesign.Capstone.model.User;

@Mapper
public interface UserMapper {

	public List<User> getAllUsers();
	
	public User findByEmail(@Param("email") String email);

	public int findIdByEmail(@Param("email") String email);

	public int signup(@Param("user") SignUpRequestDTO user);
	
	public int isEmailOverlapCheck(@Param("email") String email);

	public int isNicknameOverlapCheck(@Param("nickname") String nickname);
}