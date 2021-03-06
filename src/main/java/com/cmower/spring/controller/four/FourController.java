package com.cmower.spring.controller.four;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("four")
public class FourController {
	@RequestMapping("")
	public String index(@RequestParam(required = false, defaultValue = "index") String p) {
		return "four/" + p;
	}

	@RequestMapping("lazyload1")
	public String lazyload1() {
		return "four/lazyload1";
	}

	@RequestMapping("lazyload2")
	public String lazyload2() {
		return "four/lazyload2";
	}

	@RequestMapping("icheck1")
	public String icheck1() {
		return "four/icheck1";
	}

	@RequestMapping("icheck2")
	public String icheck2() {
		return "four/icheck2";
	}

	@RequestMapping("icheck3")
	public String icheck3() {
		return "four/icheck3";
	}

	@RequestMapping("switch1")
	public String switch1() {
		return "four/switch1";
	}

	@RequestMapping("switch2")
	public String switch2() {
		return "four/switch2";
	}

	@RequestMapping("datetimepicker1")
	public String datetimepicker1() {
		return "four/datetimepicker1";
	}

	@RequestMapping("datetimepicker2")
	public String datetimepicker2() {
		return "four/datetimepicker2";
	}
}
