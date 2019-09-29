package com.yqrj.modules.yzj.sys.controller;

import com.yqrj.common.page.PageData;
import com.yqrj.common.utils.Result;
import com.yqrj.modules.yzj.sys.dto.YzjSlideshowDTO;
import com.yqrj.modules.yzj.sys.service.YzjSlideshowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @author ZhangRongFei
 * @date 2019/9/28 17:51
 */
@RestController
@Api(tags="前台轮播图")
public class QTYzSlideshowController {
    @Autowired
    private YzjSlideshowService yzjSlideshowService;

    @RequestMapping("slideshow/list")
    public Result<PageData<YzjSlideshowDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<YzjSlideshowDTO> page = yzjSlideshowService.page(params);

        return new Result<PageData<YzjSlideshowDTO>>().ok(page);
    }

    @GetMapping("slideshow/{id}")
    @ApiOperation("信息")
    public Result<YzjSlideshowDTO> get(@PathVariable("id") Long id){
        YzjSlideshowDTO data = yzjSlideshowService.get(id);

        return new Result<YzjSlideshowDTO>().ok(data);
    }
}
