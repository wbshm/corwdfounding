package com.local.crowd.mvc.handler;

import com.local.crowd.entity.Admin;
import com.local.crowd.entity.ParamData;
import com.local.crowd.entity.Student;
import com.local.crowd.service.api.AdminService;
import com.local.crowd.util.CrowdUtil;
import com.local.crowd.util.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class TestHandler {
    @Autowired
    private AdminService adminService;

    private Logger logger = LoggerFactory.getLogger(TestHandler.class);


    @RequestMapping("/send/array.json")
    public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> array) {
        System.out.println(Arrays.toString(new List[]{array}));
        return "{1,2,3}";
    }

    @ResponseBody
    @RequestMapping("/send/array/two.json")
    public String testReceiveArrayTwo(ParamData paramData) {
        List<Integer> array = paramData.getArray();
        for (Integer number : array) {
            System.out.println(number);
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/send/array/three.json")
    public String testReceiveArrayThree(@RequestBody List<Integer> array) {
        logger.info(Arrays.toString(new List[]{array}));
        return "Success";
    }

    @RequestMapping("/test/ssm.html")
    public String testSsm(ModelMap modelMap,HttpServletRequest request) {
        List<Admin> adminList = adminService.getAll();
        boolean requestType = CrowdUtil.judgeRequestType(request);
        logger.info("judgeResult" + requestType);
        modelMap.addAttribute("adminList", adminList);
        String a = null;
        System.out.println(a.length());
        return "target";
    }

    @ResponseBody
    @RequestMapping("/send/compose/object.json")
    public ResultEntity<Student> testReceiveComposeObject(@RequestBody Student student, HttpServletRequest request) {
        boolean requestType = CrowdUtil.judgeRequestType(request);
        logger.info("judgeResult" + requestType);
        logger.info(student.toString());
        String a = null;
        System.out.println(a.length());
        return ResultEntity.successWithData(student);
    }

}
