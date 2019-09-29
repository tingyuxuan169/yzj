package com.yqrj.modules.yzj.store.controller;

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
import com.yqrj.modules.yzj.store.dto.YzjStoreBrandDTO;
import com.yqrj.modules.yzj.store.excel.YzjStoreBrandExcel;
import com.yqrj.modules.yzj.store.service.YzjStoreBrandService;
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
 * 商品品牌
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@RestController
@RequestMapping("yzj/brand")
@Api(tags="商品品牌")
public class YzjStoreBrandController {
    @Autowired
    private YzjStoreBrandService yzjStoreBrandService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("yzj:brand:page")
    public Result<PageData<YzjStoreBrandDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<YzjStoreBrandDTO> page = yzjStoreBrandService.page(params);

        return new Result<PageData<YzjStoreBrandDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("yzj:brand:info")
    public Result<YzjStoreBrandDTO> get(@PathVariable("id") Long id){
        YzjStoreBrandDTO data = yzjStoreBrandService.get(id);

        return new Result<YzjStoreBrandDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("yzj:brand:save")
    public Result save(@RequestBody YzjStoreBrandDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        yzjStoreBrandService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("yzj:brand:update")
    public Result update(@RequestBody YzjStoreBrandDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        yzjStoreBrandService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("yzj:brand:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        yzjStoreBrandService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("yzj:brand:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<YzjStoreBrandDTO> list = yzjStoreBrandService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, YzjStoreBrandExcel.class);
    }

}