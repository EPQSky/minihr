package icu.epq.minihr.controller.emp.basic;

import icu.epq.minihr.model.RespPageBean;
import icu.epq.minihr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author EPQ
 * <p>
 * 员工基本资料接口
 */
@RestController
@RequestMapping("/emp/basic/empBasic")
public class EmpBasicController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer size,
                                          @RequestParam String keyword) {
        return employeeService.getEmployeeByPage(page, size, keyword);
    }
}
