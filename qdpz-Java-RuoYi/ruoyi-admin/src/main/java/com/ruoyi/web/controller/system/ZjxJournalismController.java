package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.ZjxJournalism;
import com.ruoyi.system.service.IZjxJournalismService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章资讯Controller
 *
 * @author ruoyi
 * @date 2021-09-10
 */
@Controller
@RequestMapping("/system/journalism")
public class ZjxJournalismController extends BaseController {
    private String prefix = "system/journalism";

    @Autowired
    private IZjxJournalismService zjxJournalismService;

    @RequiresPermissions("system:journalism:view")
    @GetMapping()
    public String journalism() {
        return prefix + "/journalism";
    }

    /**
     * 查询文章资讯列表
     */
    @RequiresPermissions("system:journalism:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ZjxJournalism zjxJournalism) {
        startPage();
        List<ZjxJournalism> list = zjxJournalismService.selectZjxJournalismList(zjxJournalism);
        return getDataTable(list);
    }

    /**
     * 导出文章资讯列表
     */
    @RequiresPermissions("system:journalism:export")
    @Log(title = "文章资讯", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZjxJournalism zjxJournalism) {
        List<ZjxJournalism> list = zjxJournalismService.selectZjxJournalismList(zjxJournalism);
        ExcelUtil<ZjxJournalism> util = new ExcelUtil<ZjxJournalism>(ZjxJournalism.class);
        return util.exportExcel(list, "文章资讯数据");
    }

    /**
     * 新增文章资讯
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存文章资讯
     */
    @RequiresPermissions("system:journalism:add")
    @Log(title = "文章资讯", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZjxJournalism zjxJournalism) {
        zjxJournalism.setCreateBy(getLoginName());
        return toAjax(zjxJournalismService.insertZjxJournalism(zjxJournalism));
    }

    /**
     * 修改文章资讯
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ZjxJournalism zjxJournalism = zjxJournalismService.selectZjxJournalismById(id);
        mmap.put("zjxJournalism", zjxJournalism);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章资讯
     */
    @RequiresPermissions("system:journalism:edit")
    @Log(title = "文章资讯", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZjxJournalism zjxJournalism) {
        zjxJournalism.setUpdateBy(getLoginName());
        return toAjax(zjxJournalismService.updateZjxJournalism(zjxJournalism));
    }

    /**
     * 删除文章资讯
     */
    @RequiresPermissions("system:journalism:remove")
    @Log(title = "文章资讯", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(zjxJournalismService.deleteZjxJournalismByIds(ids));
    }
}
