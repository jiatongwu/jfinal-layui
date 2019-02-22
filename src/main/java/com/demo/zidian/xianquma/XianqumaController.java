package com.demo.zidian.xianquma;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

@Before(XianqumaInterceptor.class)
public class XianqumaController extends Controller {

	@Inject
	XianqumaService service;

	public void index() {		
		Integer pageNum = getParaToInt("pageNum", 1);
		Integer pageSize = getParaToInt("pageSize", 10);
		
		Page<Record> records=service.page(pageNum,pageSize);
		set("xianqumas", records);
		render("xianquma.html");
	}
}
	
