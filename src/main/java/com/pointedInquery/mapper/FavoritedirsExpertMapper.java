package com.pointedInquery.mapper;

import com.pointedInquery.entity.Expert;
import com.pointedInquery.entity.FavoritedirsExpert;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * VIEW Mapper 接口
 * </p>
 *
 */
@Mapper
public interface FavoritedirsExpertMapper extends BaseMapper<FavoritedirsExpert> {
      @Select("SELECT expert_id from favoritedirs where phone=#{customer_id}")
      public List<String> selectFavoriteExpertsById(String customer_id);

      @Select("SELECT COUNT(*) FROM favoritedirs WHERE phone = #{customer_id} AND expert_id = #{expert_id}")
      public int selectFavoriteExpertRecord(String customer_id,String expert_id);
      @Insert("INSERT INTO favoritedirs (phone, expert_id,collect_time) VALUES (#{customer_id}, #{expert_id},CURRENT_TIMESTAMP)")
      public int addFavoriteExpert(String customer_id,String expert_id);

      @Select("SELECT * from favoritedirs_expert where customer_id=#{customer_id}")
      public List<FavoritedirsExpert> selectExpertList(String customer_id);

      @Insert("INSERT INTO favoritedirs_expert (customer_id, expert_id,real_name,job,rating,title,price,addr_province)" +
              " VALUES (#{customerId}, #{expertId},#{realName},#{job},#{rating},#{title}" +
              ",#{price},#{addrProvince})")
      public void addDetaiedInfo(FavoritedirsExpert fdExpert);
}
