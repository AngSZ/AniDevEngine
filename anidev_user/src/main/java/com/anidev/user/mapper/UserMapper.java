package com.anidev.user.mapper;

import com.anidev.user.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sza
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
