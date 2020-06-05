package com.ywzf.ainurse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ywzf.ainurse.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther: 李志坚
 * @Date: 2020/6/2
 * @Description: 互联网医院联调接口
 */
public interface UserMapper extends BaseMapper<User> {

}
