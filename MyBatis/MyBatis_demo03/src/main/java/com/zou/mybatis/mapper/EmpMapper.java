package com.zou.mybatis.mapper;

import com.zou.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

/*
*查询所有的员工信息*/

List<EmpMapper> getAllEmp();

/**
 * 查询员工以及员工对应部门信息
 */
	Emp getEmpAndDept(@Param("eid") int eid);


	/**
	 * 通过分布查询员工以及员工对应部门信息
	 * 分布查询先查询员工信息
	 */

	Emp getEmpAndDeptByStepOne(@Param("eid") int eid);
}
