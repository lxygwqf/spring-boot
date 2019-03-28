package com.springboot.chapter9.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springboot.chapter9.pojo.ValidatorPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.springboot.chapter9.pojo.User;
import com.springboot.chapter9.service.UserService;

import javax.validation.Valid;

/**** import ****/
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
//	调用这里的服务接口 实际是 调用UserServiceImpl 去调用xml文件下的sql语句
	private UserService userService = null;

	// 展示用户详情
	@RequestMapping("details")
	public ModelAndView details(Long id) {
		// 访问模型层得到数据
		User user = userService.getUser(id);
		// 模型和视图
		ModelAndView mv = new ModelAndView();
		// 定义模型视图 jsp文件
		mv.setViewName("user/details");
		// 加入数据模型
		mv.addObject("user", user);
		// 返回模型和视图
		return mv;
	}

	@RequestMapping("/detailsForJson")
	public ModelAndView detailsForJson(Long id) {
		// 访问模型层得到数据
		User user = userService.getUser(id);
		// 模型和视图
		ModelAndView mv = new ModelAndView();
		// 生成JSON视图
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		mv.setView(jsonView);
		// 加入模型
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping("/table")
	public ModelAndView table() {
		// 访问模型层得到数据
		List<User> userList = userService.findUsers(null, null);
		// 模型和视图
		ModelAndView mv = new ModelAndView();
		// 定义模型视图
		mv.setViewName("user/table");
		// 加入数据模型
		mv.addObject("userList", userList);
		// 返回模型和视图
		return mv;
	}

	@RequestMapping("/list")
	@ResponseBody
	public List<User> list(@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "note", required = false) String note) {
		// 访问模型层得到数据
		List<User> userList = userService.findUsers(userName, note);
		return userList;
	}

	/**
	 * 打开请求页面
	 *
	 * @return 字符串，指向页面
	 */
	@GetMapping("/add")
	public String add() {
		return "/user/add";
	}

	/**
	 * 新增用户
	 *
	 * @param user
	 *            通过@RequestBody注解得到JSON参数
	 * @return 回填id后的用户信息
	 */
	@PostMapping("/insert")
//	@ResponseBody
//	RequestBody传入的是json对象
	public User insert(@RequestBody User user) {
		userService.insertUser(user);
		return user;
	}

	@GetMapping("/converter")
	@ResponseBody
	public User getUserByConverter(User user) {
		return user;
	}

	@GetMapping("/list")
	@ResponseBody
	public List<User> list(List<User> userList) {
		return userList;
	}

	@GetMapping("/valid/page")
	public String validPage() {
		return "/validator/pojo";
	}

	/***
	 * 解析验证参数错误
	 * @param vp —— 需要验证的POJO，使用注解@Valid 表示验证
	 * @param errors  错误信息，它由Spring MVC通过验证POJO后自动填充
	 * @return 错误信息Map
	 */
	@RequestMapping(value = "/valid/validate")
	@ResponseBody
	public Map<String, Object> validate(
			@Valid @RequestBody ValidatorPojo vp, Errors errors) {
		Map<String, Object> errMap = new HashMap<>();
		// 获取错误列表
		List<ObjectError> oes = errors.getAllErrors();
		for (ObjectError oe : oes) {
			String key = null;
			String msg = null;
			// 字段错误
			if (oe instanceof FieldError) {
				FieldError fe = (FieldError) oe;
				key = fe.getField();// 获取错误验证字段名
			} else {
				// 非字段错误
				key = oe.getObjectName();// 获取验证对象名称
			}
			// 错误信息
			msg = oe.getDefaultMessage();
			errMap.put(key, msg);
		}
		return errMap;
	}

}