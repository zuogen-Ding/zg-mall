package club.banyuan.demo.authentication.controller;

import club.banyuan.demo.authentication.common.ResponseResult;
import club.banyuan.demo.authentication.dto.AdminLoginReq;
import club.banyuan.demo.authentication.dto.AdminLoginResp;
import club.banyuan.demo.authentication.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult login(@RequestBody AdminLoginReq adminLoginReq) {
        AdminLoginResp adminLoginResp = adminService.login(adminLoginReq);
        return ResponseResult.success(adminLoginResp);
    }
}
