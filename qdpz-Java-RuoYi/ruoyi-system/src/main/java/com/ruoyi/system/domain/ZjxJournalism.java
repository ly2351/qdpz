package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章资讯对象 zjx_journalism
 * 
 * @author ruoyi
 * @date 2021-09-10
 */
public class ZjxJournalism extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String journalismName;

    /** 类型 */
    @Excel(name = "类型")
    private Integer journalismType;

    /** 内容 */
    @Excel(name = "内容")
    private String journalismDesc;

    /** 缩略图 */
    @Excel(name = "缩略图")
    private String thumbnail;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setJournalismName(String journalismName) 
    {
        this.journalismName = journalismName;
    }

    public String getJournalismName() 
    {
        return journalismName;
    }
    public void setJournalismType(Integer journalismType) 
    {
        this.journalismType = journalismType;
    }

    public Integer getJournalismType() 
    {
        return journalismType;
    }
    public void setJournalismDesc(String journalismDesc) 
    {
        this.journalismDesc = journalismDesc;
    }

    public String getJournalismDesc() 
    {
        return journalismDesc;
    }
    public void setThumbnail(String thumbnail) 
    {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() 
    {
        return thumbnail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("journalismName", getJournalismName())
            .append("journalismType", getJournalismType())
            .append("journalismDesc", getJournalismDesc())
            .append("createTime", getCreateTime())
            .append("thumbnail", getThumbnail())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
