package com.yc.ssm.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Words;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class WordsServiceTest {
	
	@Autowired
	private WordsService wordsService;

	/*
	 * @Test public void testFindWords() { Words words=new Words(); List<Words>
	 * ws=wordsService.findWords(words); System.out.println(ws);
	 * assertNotNull(ws); }
	 */
	@Test
	public void testAdd() {
		Words words=new Words();
		words.setWaid("a30");
		words.setWcontent("我来留言了。。。。");
		words.setWfrendid("a28");
	}

}
