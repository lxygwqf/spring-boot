package com.springboot.chapter7.main;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("INisdfjslfj");
		return application.sources(Chapter7Main.class);
	}

}
