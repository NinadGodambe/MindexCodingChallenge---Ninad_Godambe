package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//Method implementation for ReportingStructureService
@Service
public class ReportingStructureServiceImpl implements ReportingStructureService{
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ReportingStructure read(String employeeId){
        LOG.debug("Reporting Structure for Employee with Employee ID : [{}]", employeeId);
        Employee employee = employeeService.read(employeeId);
        int totalDistReports = getDirectReports(employeeId);
        return new ReportingStructure(employee,totalDistReports);

    }

    public int getDirectReports(String employeeId){
        Employee employee = employeeService.read(employeeId);
        List<Employee> ReportList = employee.getDirectReports();
        if(ReportList == null){
            throw new RuntimeException("No more direct reports for : " + employeeId);
        }
        int DirectReports = 0;
        for(Employee e : ReportList){
            try {
                DirectReports += 1;
                DirectReports += getDirectReports(e.getEmployeeId());
            }
            catch(RuntimeException ex){
            }
        }
        return DirectReports;
    }
}