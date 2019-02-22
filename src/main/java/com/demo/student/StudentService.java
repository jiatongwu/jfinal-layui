package com.demo.student;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public class StudentService {
	public List<Record> getBaominghaoXianquma() {
		List<Record> findAll = Db.findAll("baominghaoXianquma");
		return findAll;
	}

	public Page<Record> page(Integer pageNum, Integer pageSize, String name, String school) {
		StringBuilder selectsql = new StringBuilder();
		StringBuilder fromsql = new StringBuilder();
		selectsql.append("select * ");
		fromsql.append("from student where 1=1 ");

		List<Object> paras = new ArrayList<>();

		if (StringUtils.isNotBlank(name)) {
			fromsql.append(" and name like ? ");
			paras.add("%" + name + "%");
		}
		if (StringUtils.isNotBlank(school)) {
			fromsql.append(" and school like ? ");
			paras.add("%" + school + "%");
		}
		Page<Record> paginate = Db.paginate(pageNum, pageSize, selectsql.toString(), fromsql.toString(),paras.toArray());

		return paginate;
	}
}
