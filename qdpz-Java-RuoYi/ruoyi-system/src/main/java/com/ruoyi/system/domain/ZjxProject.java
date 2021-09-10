package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 开源项目对象 zjx_project
 * 
 * @author ruoyi
 * @date 2021-09-10
 */
public class ZjxProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String projectName;

    /** 内容 */
    @Excel(name = "内容")
    private String projectDesc;

    /** 类型 */
    @Excel(name = "类型")
    private Integer projectType;

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
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setProjectDesc(String projectDesc) 
    {
        this.projectDesc = projectDesc;
    }

    public String getProjectDesc() 
    {
        return projectDesc;
    }
    public void setProjectType(Integer projectType) 
    {
        this.projectType = projectType;
    }

    public Integer getProjectType() 
    {
        return projectType;
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
            .append("projectName", getProjectName())
            .append("projectDesc", getProjectDesc())
            .append("createBy", getCreateBy())
            .append("projectType", getProjectType())
            .append("createTime", getCreateTime())
            .append("thumbnail", getThumbnail())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
