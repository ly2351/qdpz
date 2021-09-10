package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ZjxProject;

/**
 * 开源项目Service接口
 * 
 * @author ruoyi
 * @date 2021-09-10
 */
public interface IZjxProjectService 
{
    /**
     * 查询开源项目
     * 
     * @param id 开源项目主键
     * @return 开源项目
     */
    public ZjxProject selectZjxProjectById(Long id);

    /**
     * 查询开源项目列表
     * 
     * @param zjxProject 开源项目
     * @return 开源项目集合
     */
    public List<ZjxProject> selectZjxProjectList(ZjxProject zjxProject);

    /**
     * 新增开源项目
     * 
     * @param zjxProject 开源项目
     * @return 结果
     */
    public int insertZjxProject(ZjxProject zjxProject);

    /**
     * 修改开源项目
     * 
     * @param zjxProject 开源项目
     * @return 结果
     */
    public int updateZjxProject(ZjxProject zjxProject);

    /**
     * 批量删除开源项目
     * 
     * @param ids 需要删除的开源项目主键集合
     * @return 结果
     */
    public int deleteZjxProjectByIds(String ids);

    /**
     * 删除开源项目信息
     * 
     * @param id 开源项目主键
     * @return 结果
     */
    public int deleteZjxProjectById(Long id);
}
