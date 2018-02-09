/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.lotte.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibm.lotte.model.QueryResult;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PredictionRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PredictionRepository predictions;

	@Test
	public void testFindByLastName() {
		QueryResult result = new QueryResult("0", "brand_nm0", "func_nm0", "maker_nm0", "mat_1_nm0", "mat_2_nm0", "mat_3_nm0", "mat_4_nm0", "mat_5_nm0", "mat_6_nm0", "prod_cat_2_nm0", "prod_cat_3_nm0", "taste_1_nm0", "taste_2_nm0", "taste_3_nm0", "txtre_1_nm0", "txtre_2_nm0", "txtre_3_nm0", "key_nm0", 10);
		entityManager.persist(result);

		List<QueryResult> findByLastName = predictions.findByVersion(result.getVersion());

		assertThat(findByLastName).extracting(QueryResult::getKeyNm).containsOnly(result.getKeyNm());
	}
}