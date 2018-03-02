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

import com.ibm.lotte.model.PredictModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PredictionRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PredictionRepository predictions;

    @Test
    public void testFindByLastName() {
        String version = "2018-01-01";
        String condition = "brand_nm0_func_nm0_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_taste_3_nm0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0";
        PredictModel result = new PredictModel( version, false, "201801", condition, condition, 10 );

        entityManager.persist( result );

        List<PredictModel> findResult = predictions.findByVersionAndNewBrandAndKeyCd( version,false,  condition );

        assertThat( findResult ).extracting( PredictModel::getKeyCd ).containsOnly( result.getKeyCd() );
        assertThat( findResult ).extracting( PredictModel::getKeyNm ).containsOnly( result.getKeyNm() );
    }
}