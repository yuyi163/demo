package com.yy.metronic.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yy.metronic.entity.Yydata;
import com.yy.metronic.repository.YydataRepository;


@RestController
@RequestMapping("yydata")
public class YydataRestController {

	@Autowired
	private YydataRepository yydataRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> index() {
		List<Yydata> l = yydataRepository.findAll();
		int iTotalRecords = l.size();
		Map<String, Object> res = new HashMap<String, Object>(); //为了使用datatables，需要为databales提供aaData
		res.put("aaData", l);
		res.put("sEcho", 1);
		res.put("iTotalRecords", iTotalRecords);
		res.put("iTotalDisplayRecords", 100);
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	}

}
