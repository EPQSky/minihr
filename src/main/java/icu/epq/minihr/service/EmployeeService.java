package icu.epq.minihr.service;


import icu.epq.minihr.mapper.EmployeeMapper;
import icu.epq.minihr.model.Employee;
import icu.epq.minihr.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author EPQ
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public RespPageBean getEmployeeByPage(Integer page, Integer size, String keyword) {

        if (page != null && size != null) {
            page = (page - 1) * size;
        }

        List<Employee> data = employeeMapper.getEmployeeByPage(page, size, keyword);
        Long total = employeeMapper.getTotal(keyword);

        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setTotal(total);
        respPageBean.setData(data);

        return respPageBean;
    }

    public Integer addEmployee(Employee employee) {
        long beginDate = employee.getBeginContract().getTime();
        long endDate = employee.getEndContract().getTime();
        long date = endDate - beginDate;
        double days = (double) (date / (1000 * 60 * 60 * 24));
        double year = Double.parseDouble(String.format("%.2f", days / 365));
        employee.setContractTerm(year);
        employee.setWorkState("在职");
        return employeeMapper.insertSelective(employee);
    }

    public synchronized Integer getMaxWorkID() {
        return employeeMapper.getMaxWorkID();
    }

    public Integer deleteEmployeeById(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmployee(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }
}
