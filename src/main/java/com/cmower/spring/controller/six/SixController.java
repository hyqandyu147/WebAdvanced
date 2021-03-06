package com.cmower.spring.controller.six;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmower.database.entity.Cities;
import com.cmower.database.entity.Provinces;
import com.cmower.database.entity.Votes;
import com.cmower.spring.controller.BaseController;
import com.cmower.spring.service.ProcityService;
import com.cmower.spring.service.VoteService;

@Controller
@RequestMapping("six")
public class SixController extends BaseController {
	@Autowired
	private ProcityService procityService;
	@Autowired
	private VoteService voteService;

	@RequestMapping("")
	public String index(@RequestParam(required = false, defaultValue = "index") String p) {
		return "six/" + p;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("chartjs/vote")
	@ResponseBody
	public HashMap chartjsVote() {
		logger.info("为chartjs获取投票数据");

		List<String> labels = new ArrayList<>();
		List<Integer> votes = new ArrayList<>();
		List<Integer> tickets = new ArrayList<>();
		List<Votes> list = voteService.selectList(new Votes());
		for (Votes vote : list) {
			// 横轴上的标签
			labels.add(DateFormatUtils.format(vote.getCreate_date(), "MM月"));
			// 得票数
			votes.add(vote.getVote());
			// 投票数
			tickets.add(vote.getTicket());
		}
		HashMap data = new HashMap();
		data.put("labels", labels);
		data.put("votes", votes);
		data.put("tickets", tickets);

		return data;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("treeview/procity")
	@ResponseBody
	public List<HashMap> treeviewProcity() {
		logger.info("treeview获取省市级数据");
		
		List<HashMap> data = new ArrayList<>();
		List<Provinces> provinces = procityService.selectProvinces();
		for (Provinces province : provinces) {
			HashMap parent = new HashMap();
			
			// 树节点上要显示的文本
			parent.put("text", province.getProname());
			// 节点的唯一性
			parent.put("id", province.getId());
			// 省会编码
			parent.put("procode", province.getProcode());
			
			// 根据省会ID获取城市列表
			List<Cities> citys = procityService.getCitiesByProvinceId(province.getId());
			
			List<HashMap> children = new ArrayList<>();
			for (Cities city : citys) {
				HashMap child = new HashMap();
				child.put("text", city.getCname());
				child.put("id", city.getId());
				// 省会ID
				child.put("proid", city.getProid());
				// 城市编码
				child.put("code", city.getCode());
				
				children.add(child);
			}
			parent.put("nodes", children);
			
			data.add(parent);
		}
		
		return data;
	}

	@RequestMapping("treeview/submit")
	@ResponseBody
	public String treeviewSubmit() {
		logger.debug(getPara("ids"));
		return "数据已收到";
	}

}
