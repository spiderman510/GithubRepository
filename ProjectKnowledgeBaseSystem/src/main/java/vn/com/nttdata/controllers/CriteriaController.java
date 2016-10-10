/**
 * 
 */
package vn.com.nttdata.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.com.nttdata.model.Criterias;
import vn.com.nttdata.service.CriteriaService;

/**
 * @author SPIDERMAN
 *
 */
@Controller
@RequestMapping("criteria")
public class CriteriaController {

	@Autowired
	public CriteriaService criteriaService;

	@RequestMapping(method = RequestMethod.GET)
	public String listCriteria(Map model) {
		List<Criterias> criterias = criteriaService.getAllCriteria();
		model.put("criteriaList", criterias);
		return "criteria";
	}
}
