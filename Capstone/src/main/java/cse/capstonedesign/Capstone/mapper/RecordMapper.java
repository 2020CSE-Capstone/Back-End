package cse.capstonedesign.Capstone.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cse.capstonedesign.Capstone.dto.request.InsertDrinkRecordRequestDTO;
import cse.capstonedesign.Capstone.dto.request.MonthRecordRequestDTO;
import cse.capstonedesign.Capstone.dto.response.DrinkTotalResponseDTO;
import cse.capstonedesign.Capstone.dto.response.RecordResponseDTO;
import cse.capstonedesign.Capstone.dto.response.SmokeTotalResponseDTO;
import cse.capstonedesign.Capstone.model.MonthRecords;
import cse.capstonedesign.Capstone.model.Record;

@Mapper
public interface RecordMapper {

	public List<Record> getAllDrinkRecords(@Param("user_id") int user_id);
	
	public List<Record> getAllSmokeRecords(@Param("user_id") int user_id);

	public int insertDrinkRecord(@Param("record") InsertDrinkRecordRequestDTO record);

	public DrinkTotalResponseDTO getTotalDrink(@Param("user_id") int user_id);

	public SmokeTotalResponseDTO getTotalSmoke(@Param("user_id") int user_id);

	public List<MonthRecords> getMonthDrinkRecords(@Param("user_id") int user_id, @Param("month") String month);
	
	public List<MonthRecords> getMonthSmokeRecords(@Param("user_id") int user_id, @Param("month") String month);
}
