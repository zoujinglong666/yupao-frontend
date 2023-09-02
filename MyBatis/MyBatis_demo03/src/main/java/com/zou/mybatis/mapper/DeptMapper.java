package com.zou.mybatis.mapper;

import com.zou.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
//	分布查询的第二步
	//通过did查询员工所属部门
	Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

//	获取部门以及部门所有的员工信息

	Dept getDeptAndEmp(@Param("did")Integer did);
}
