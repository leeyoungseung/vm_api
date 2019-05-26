package com.vm.api.service;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vm.api.dto.TestDTO;
import com.vm.api.model.Sentence;
import com.vm.api.model.Test;
import com.vm.api.model.Test_val;
import com.vm.api.repo.SentenceRepository;
import com.vm.api.repo.TestRepository;
import com.vm.api.repo.Test_valRepository;
import com.vm.api.repo.VerbRepository;

@Service
public class TestService {
	
	private static final Logger log = LogManager.getLogger(TestService.class.getName());
	
	@Autowired
	TestRepository testRepo;
	
	@Autowired
	Test_valRepository test_valRepo;
	
	@Autowired
	VerbService verbService;
	
	@Autowired
	SentenceService sentenceService;
	
	
	public List<Test> findAllTestById(Test test){
		List<Test> list = testRepo.findAllTestByUserId(test.getUser_id());
		if(list == null || list.size() == 0) {
			return null;
		}
		return list;
	}
	
	@Transactional
	public List<Test> createTest(Test test, List<Test_val> tvlist) {
		
		//1. 단어 수를 세팅해서 저장하기
		test.setTest_verb_count(tvlist.size());
		Test res = testRepo.save(test);
		
		//2. Test의 저장이 성공했다면 그 다음의 작업으로 이동
		//Test의 id를 가져와서 Test_val의 리스트에 test의 값 대입하기
		if(res.getTest_id() == null || res.getTest_id() ==0 ) {
			return null;
		}
		
		
		
		for(Test_val val : tvlist) {
			val.setTest_id(res.getTest_id());
			//3. 문제와 답을 생성하기
			Random rd = new Random();
			
			List<Sentence> slist = sentenceService.findAllSentenceById(val.getVerb_id());
			int num1 = rd.nextInt(slist.size());
			
			int num2 = 0;
			int count = 0;
			while(count > slist.size()) {
				int temp = rd.nextInt(slist.size());
				if(temp != num1) {
					num2 = temp;
					count = 0;
					break;
				}
			}
			
			int num3 = 0;
			while(count > slist.size()) {
				int temp = rd.nextInt(slist.size());
				if(temp != num1 && temp != num2) {
					num3 = temp;
					break;
				}
			}
			
			for(Sentence s_val : slist) {
				//s_val.getS_sort("");
				
			}
			
			
		}
		
		
		
		
		
		//4. 저장하기
		test_valRepo.saveAll(tvlist);
		
		return testRepo.findAllTestByUserId(test.getUser_id());
	}
	
	
	public List<TestDTO> findOneTest() {
		
		
		
		return null;
	}
	
	
}
