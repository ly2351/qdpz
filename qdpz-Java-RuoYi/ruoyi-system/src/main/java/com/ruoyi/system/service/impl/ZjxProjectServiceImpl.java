package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.ZjxProject;
import com.ruoyi.system.mapper.ZjxProjectMapper;
import com.ruoyi.system.service.IZjxProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 开源项目Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-10
 */
@Service
public class ZjxProjectServiceImpl implements IZjxProjectService {
    @Autowired
    private ZjxProjectMapper zjxProjectMapper;

    /**
     * 查询开源项目
     *
     * @param id 开源项目主键
     * @return 开源项目
     */
    @Override
    public ZjxProject selectZjxProjectById(Long id) {
        return zjxProjectMapper.selectZjxProjectById(id);
    }

    /**
     * 查询开源项目列表
     *
     * @param zjxProject 开源项目
     * @return 开源项目
     */
    @Override
    public List<ZjxProject> selectZjxProjectList(ZjxProject zjxProject) {
        return zjxProjectMapper.selectZjxProjectList(zjxProject);
    }

    /**
     * 新增开源项目
     *
     * @param zjxProject 开源项目
     * @return 结果
     */
    @Override
    public int insertZjxProject(ZjxProject zjxProject) {
        zjxProject.setCreateTime(DateUtils.getNowDate());
        return zjxProjectMapper.insertZjxProject(zjxProject);
    }

    /**
     * 修改开源项目
     *
     * @param zjxProject 开源项目
     * @return 结果
     */
    @Override
    public int updateZjxProject(ZjxProject zjxProject) {
        zjxProject.setUpdateTime(DateUtils.getNowDate());
        return zjxProjectMapper.updateZjxProject(zjxProject);
    }

    /**
     * 批量删除开源项目
     *
     * @param ids 需要删除的开源项目主键
     * @return 结果
     */
    @Override
    public int deleteZjxProjectByIds(String ids) {
        return zjxProjectMapper.deleteZjxProjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除开源项目信息
     *
     * @param id 开源项目主键
     * @return 结果
     */
    @Override
    public int deleteZjxProjectById(Long id) {
        return zjxProjectMapper.deleteZjxProjectById(id);
    }
}
