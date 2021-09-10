package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ZjxJournalism;

/**
 * 文章资讯Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-10
 */
public interface ZjxJournalismMapper 
{
    /**
     * 查询文章资讯
     * 
     * @param id 文章资讯主键
     * @return 文章资讯
     */
    public ZjxJournalism selectZjxJournalismById(Long id);

    /**
     * 查询文章资讯列表
     * 
     * @param zjxJournalism 文章资讯
     * @return 文章资讯集合
     */
    public List<ZjxJournalism> selectZjxJournalismList(ZjxJournalism zjxJournalism);

    /**
     * 新增文章资讯
     * 
     * @param zjxJournalism 文章资讯
     * @return 结果
     */
    public int insertZjxJournalism(ZjxJournalism zjxJournalism);

    /**
     * 修改文章资讯
     * 
     * @param zjxJournalism 文章资讯
     * @return 结果
     */
    public int updateZjxJournalism(ZjxJournalism zjxJournalism);

    /**
     * 删除文章资讯
     * 
     * @param id 文章资讯主键
     * @return 结果
     */
    public int deleteZjxJournalismById(Long id);

    /**
     * 批量删除文章资讯
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZjxJournalismByIds(String[] ids);
}
