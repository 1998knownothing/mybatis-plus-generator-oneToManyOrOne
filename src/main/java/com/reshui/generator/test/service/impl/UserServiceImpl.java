package com.reshui.generator.test.service.impl;

import com.reshui.generator.test.entity.User;
import com.reshui.generator.test.mapper.UserMapper;
import com.reshui.generator.test.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuye
 * @since 2021-08-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
