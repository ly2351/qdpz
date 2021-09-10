package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.ZjxProject;
import com.ruoyi.system.service.IZjxProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 开源项目Controller
 *
 * @author ruoyi
 * @date 2021-09-10
 */
@Controller
@RequestMapping("/system/project")
public class ZjxProjectController extends BaseController {
    private String prefix = "system/project";

    @Autowired
    private IZjxProjectService zjxProjectService;

    @RequiresPermissions("system:project:view")
    @GetMapping()
    public String project() {
        return prefix + "/project";
    }

    /**
     * 查询开源项目列表
     */
    @RequiresPermissions("system:project:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ZjxProject zjxProject) {
        startPage();
        List<ZjxProject> list = zjxProjectService.selectZjxProjectList(zjxProject);
        return getDataTable(list);
    }

    /**
     * 导出开源项目列表
     */
    @RequiresPermissions("system:project:export")
    @Log(title = "开源项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZjxProject zjxProject) {
        List<ZjxProject> list = zjxProjectService.selectZjxProjectList(zjxProject);
        ExcelUtil<ZjxProject> util = new ExcelUtil<ZjxProject>(ZjxProject.class);
        return util.exportExcel(list, "开源项目数据");
    }

    /**
     * 新增开源项目
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存开源项目
     */
    @RequiresPermissions("system:project:add")
    @Log(title = "开源项目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZjxProject zjxProject) {
        zjxProject.setCreateBy(getLoginName());
        return toAjax(zjxProjectService.insertZjxProject(zjxProject));
    }

    /**
     * 修改开源项目
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ZjxProject zjxProject = zjxProjectService.selectZjxProjectById(id);
        mmap.put("zjxProject", zjxProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存开源项目
     */
    @RequiresPermissions("system:project:edit")
    @Log(title = "开源项目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZjxProject zjxProject) {
        zjxProject.setUpdateBy(getLoginName());
        return toAjax(zjxProjectService.updateZjxProject(zjxProject));
    }

    /**
     * 删除开源项目
     */
    @RequiresPermissions("system:project:remove")
    @Log(title = "开源项目", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(zjxProjectService.deleteZjxProjectByIds(ids));
    }
}
