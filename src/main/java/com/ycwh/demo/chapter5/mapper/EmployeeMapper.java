package com.ycwh.demo.chapter5.mapper;

import com.ycwh.demo.chapter5.POJO.Employee;

public interface EmployeeMapper
{
    public Employee getEmployee(int id);

    public void insert(Employee employee);
}
