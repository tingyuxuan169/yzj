package com.yqrj.modules.yzj.sys.controller;

import com.yqrj.common.annotation.LogOperation;
import com.yqrj.common.constant.Constant;
import com.yqrj.common.page.PageData;
import com.yqrj.common.utils.ExcelUtils;
import com.yqrj.common.utils.Result;
import com.yqrj.common.validator.AssertUtils;
import com.yqrj.common.validator.ValidatorUtils;
import com.yqrj.common.validator.group.AddGroup;
import com.yqrj.common.validator.group.DefaultGroup;
import com.yqrj.common.validator.group.UpdateGroup;
import com.yqrj.modules.security.user.SecurityUser;
import com.yqrj.modules.yzj.sys.dto.YzjNoticeDTO;
import com.yqrj.modules.yzj.sys.excel.YzjNoticeExcel;
import com.yqrj.modules.yzj.sys.service.YzjNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 公告信息
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-04
 */
@RestController
@RequestMapping("yzj/notice")
@Api(tags="公告信息")
public class YzjNoticeController {
    @Autowired
    private YzjNoticeService yzjNoticeService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("yzj:notice:page")
    public Result<PageData<YzjNoticeDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
    	if(SecurityUser.getUserId()!=null) {
    		params.put("eq_creator", SecurityUser.getUserId());
    	}
        PageData<YzjNoticeDTO> page = yzjNoticeService.page(params);

        return new Result<PageData<YzjNoticeDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("yzj:notice:info")
    public Result<YzjNoticeDTO> get(@PathVariable("id") Long id){
        YzjNoticeDTO data = yzjNoticeService.get(id);

        return new Result<YzjNoticeDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("yzj:notice:save")
    public Result save(@RequestBody YzjNoticeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        yzjNoticeService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("yzj:notice:update")
    public Result update(@RequestBody YzjNoticeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        yzjNoticeService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("yzj:notice:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        yzjNoticeService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("yzj:notice:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<YzjNoticeDTO> list = yzjNoticeService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, YzjNoticeExcel.class);
    }

}