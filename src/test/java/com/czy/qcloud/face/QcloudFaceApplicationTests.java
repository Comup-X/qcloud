package com.czy.qcloud.face;

import com.czy.qcloud.face.service.PersonManagementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QcloudFaceApplicationTests {

	@Autowired
	private PersonManagementService personManagementService;

	@Test
	public void queryAllPersonInfo() {
		personManagementService.queryAllPersonInfo();
	}
}
