package com.local.crowd.mvc.handler;

import com.local.crowd.entity.Admin;
import com.local.crowd.entity.ParamData;
import com.local.crowd.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class TestHandler {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/send/array.json")
    public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> array) {
        System.out.println(Arrays.toString(new List[]{array}));
        return "{1,2,3}";
    }

    @ResponseBody
    @RequestMapping("/send/array/two.json")
    public String testReceiveArrayTwo(ParamData paramData) {
        List<Integer> array = paramData.getArray();
        for (Integer number:array){
            System.out.println(number);
        }
        return "success";
    }

    @RequestMapping("/test/ssm.html")
    public String testSsm(ModelMap modelMap) {
        List<Admin> adminList = adminService.getAll();
        modelMap.addAttribute("adminList", adminList);
        return "target";
    }

}
