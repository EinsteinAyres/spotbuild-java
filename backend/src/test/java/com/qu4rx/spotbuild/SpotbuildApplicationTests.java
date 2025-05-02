package com.qu4rx.spotbuild;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class SpotbuildApplicationTests {

	@Test
	void contextLoads() {
	}

}
