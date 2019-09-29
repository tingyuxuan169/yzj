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
import com.yqrj.modules.yzj.store.dto.YzjStoreGoodsStandardDTO;
import com.yqrj.modules.yzj.store.excel.YzjStoreGoodsStandardExcel;
import com.yqrj.modules.yzj.store.service.YzjStoreGoodsStandardService;
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
 * 商品规格
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@RestController
@RequestMapping("yzj/goodsstandard")
@Api(tags="商品规格")
public class YzjStoreGoodsStandardController {
    @Autowired
    private YzjStoreGoodsStandardService yzjStoreGoodsStandardService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("yzj:goodsstandard:page")
    public Result<PageData<YzjStoreGoodsStandardDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<YzjStoreGoodsStandardDTO> page = yzjStoreGoodsStandardService.page(params);

        return new Result<PageData<YzjStoreGoodsStandardDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("yzj:goodsstandard:info")
    public Result<YzjStoreGoodsStandardDTO> get(@PathVariable("id") Long id){
        YzjStoreGoodsStandardDTO data = yzjStoreGoodsStandardService.get(id);

        return new Result<YzjStoreGoodsStandardDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("yzj:goodsstandard:save")
    public Result save(@RequestBody YzjStoreGoodsStandardDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        yzjStoreGoodsStandardService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("yzj:goodsstandard:update")
    public Result update(@RequestBody YzjStoreGoodsStandardDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        yzjStoreGoodsStandardService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("yzj:goodsstandard:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        yzjStoreGoodsStandardService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("yzj:goodsstandard:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<YzjStoreGoodsStandardDTO> list = yzjStoreGoodsStandardService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, YzjStoreGoodsStandardExcel.class);
    }

}