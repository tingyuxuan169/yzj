package com.yqrj.modules.yzj.sys.controller;

import com.yqrj.common.page.PageData;
import com.yqrj.common.utils.Result;
import com.yqrj.modules.security.user.SecurityUser;
import com.yqrj.modules.yzj.sys.dto.YzjNoticeDTO;
import com.yqrj.modules.yzj.sys.dto.YzjSlideshowDTO;
import com.yqrj.modules.yzj.sys.service.YzjNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @author ZhangRongFei
 * @date 2019/9/28 16:17
 */
@RestController
@Api(tags = "公告信息")
public class QTYzjNoticeController {
    @Autowired
    private YzjNoticeService yzjNoticeService;


    @RequestMapping("notice/list")
    public Result<PageData<YzjNoticeDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
//        if(SecurityUser.getUserId()!=null) {
//            params.put("eq_creator", SecurityUser.getUserId());
//        }
        PageData<YzjNoticeDTO> page = yzjNoticeService.page(params);

        return new Result<PageData<YzjNoticeDTO>>().ok(page);
    }

    @GetMapping("notice/{id}")
    @ApiOperation("信息")
    public Result<YzjNoticeDTO> get(@PathVariable("id") Long id){
        YzjNoticeDTO data = yzjNoticeService.get(id);

        return new Result<YzjNoticeDTO>().ok(data);
    }
}
