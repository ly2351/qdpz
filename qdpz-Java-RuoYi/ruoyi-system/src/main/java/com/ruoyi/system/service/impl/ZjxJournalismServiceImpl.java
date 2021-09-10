package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.ZjxJournalism;
import com.ruoyi.system.mapper.ZjxJournalismMapper;
import com.ruoyi.system.service.IZjxJournalismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章资讯Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-10
 */
@Service
public class ZjxJournalismServiceImpl implements IZjxJournalismService {
    @Autowired
    private ZjxJournalismMapper zjxJournalismMapper;

    /**
     * 查询文章资讯
     *
     * @param id 文章资讯主键
     * @return 文章资讯
     */
    @Override
    public ZjxJournalism selectZjxJournalismById(Long id) {
        return zjxJournalismMapper.selectZjxJournalismById(id);
    }

    /**
     * 查询文章资讯列表
     *
     * @param zjxJournalism 文章资讯
     * @return 文章资讯
     */
    @Override
    public List<ZjxJournalism> selectZjxJournalismList(ZjxJournalism zjxJournalism) {
        return zjxJournalismMapper.selectZjxJournalismList(zjxJournalism);
    }

    /**
     * 新增文章资讯
     *
     * @param zjxJournalism 文章资讯
     * @return 结果
     */
    @Override
    public int insertZjxJournalism(ZjxJournalism zjxJournalism) {
        zjxJournalism.setCreateTime(DateUtils.getNowDate());
        return zjxJournalismMapper.insertZjxJournalism(zjxJournalism);
    }

    /**
     * 修改文章资讯
     *
     * @param zjxJournalism 文章资讯
     * @return 结果
     */
    @Override
    public int updateZjxJournalism(ZjxJournalism zjxJournalism) {
        zjxJournalism.setUpdateTime(DateUtils.getNowDate());
        return zjxJournalismMapper.updateZjxJournalism(zjxJournalism);
    }

    /**
     * 批量删除文章资讯
     *
     * @param ids 需要删除的文章资讯主键
     * @return 结果
     */
    @Override
    public int deleteZjxJournalismByIds(String ids) {
        return zjxJournalismMapper.deleteZjxJournalismByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章资讯信息
     *
     * @param id 文章资讯主键
     * @return 结果
     */
    @Override
    public int deleteZjxJournalismById(Long id) {
        return zjxJournalismMapper.deleteZjxJournalismById(id);
    }
}
