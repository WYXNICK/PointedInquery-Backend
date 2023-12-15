package com.pointedInquery.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pointedInquery.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
	//修改密码
	@Update("update user set password=#{newPasswd} where phone=#{userId}")
	public int changePasswd(String newPasswdd,String userId);
	
	//判断是否是行家
	@Select("select is_expert from user where phone=#{userId}")
	@ResultType(String.class)
	public boolean IsExpert(String userId);
	
	//认证行家身份
	@Update("update user set is_expert=\"是\" where phone=#{userId}")
	public int beExpert(String userId);

	//判断是否存在这样一条收藏关系
	@Select("SELECT COUNT(*) FROM favoritedirs WHERE phone = #{userId} AND expert_id = #{expertId}")
	int existsByUserIdAndExpertId(String userId, String expertId);

	@Select("SELECT name from user where phone=#{userId}")
    public String selectNameById(String userId);

	@Update("UPDATE user SET is_expert = 1 WHERE phone = #{phone}")
	void updateUserIsExpert(String phone);
}
