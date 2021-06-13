package org.zerock.sample;

import static org.junit.Assert.assertNotNull;		
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)	// 현재 테스트 코드가 스프링을 실행하는 역활임을 표시
@ContextConfiguration(classes= {RootConfig.class})	// 지정된 클래스나 문자열을 이용하여 필요한 객체들을 스프링 내에 객체로 등록(스프링의 빈으로 등록)
@Log4j	// Lombok으로 로그를 기록하는 Logger를 변수로 생성
public class SampleTests {
	
	@Setter(onMethod_ = {@Autowired})	// 인스턴스 변수가 스프링으로부터 자동으로 주입해 달라는 표시 (Obj 변수에 Restairant 타입 객체를 주입)
	private Restaurant restaurant;
	
	@Test	// JUnit에서 테스트 대상을 표시
	public void testExist() {
		assertNotNull(restaurant);	// restaurant가 null이 아니어야만 테스트가 성공
		
		log.info(restaurant);
		log.info("-------------------------");
		log.info(restaurant.getChef());
	}
}
