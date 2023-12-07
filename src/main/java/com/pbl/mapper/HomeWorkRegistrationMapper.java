package com.pbl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pbl.entity.dto.HomeWork;
import com.pbl.entity.dto.HomeWorkRegistration;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeWorkRegistrationMapper extends BaseMapper<HomeWorkRegistration> {
}
