package com.qu4rx.spotbuild;

import org.springframework.boot.SpringApplication;

public class TestSpotbuildApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpotbuildApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
