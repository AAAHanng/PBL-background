package com.pbl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pbl.entity.dto.UpdateFile;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AAAHang
 * @since 2023-12-05
 */
@Mapper
public interface FileMapper extends BaseMapper<UpdateFile> {

}
