package com.demo.zidian.xianquma;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public class XianqumaService {
	

	public Page<Record> page(Integer pageNum, Integer pageSize) {
		StringBuilder countsql = new StringBuilder();
		StringBuilder findsql = new StringBuilder();
		countsql.append("select * ");
		findsql.append("from baominghaoXianquma where 1=1 ");

		List<Object> paras = new ArrayList<>();

		
		Page<Record> paginate = Db.paginate(pageNum, pageSize, countsql.toString(), findsql.toString(),paras.toArray());

		return paginate;
	}
}
