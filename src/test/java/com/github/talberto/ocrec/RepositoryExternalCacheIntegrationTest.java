/**
 * Copyright 2014 Tomas Rodriguez 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0 
 *  
 *  Unless required by applicable law or agreed to in writing, software 
 *  distributed under the License is distributed on an "AS IS" BASIS, 
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 *  See the License for the specific language governing permissions and 
 *  limitations under the License. 
 */

package com.github.talberto.ocrec;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import atg.nucleus.Nucleus;
import atg.nucleus.NucleusTestUtils;
import atg.nucleus.ServiceException;
import atg.repository.Repository;

public class RepositoryExternalCacheIntegrationTest {
  protected Logger mLog = LoggerFactory.getLogger(this.getClass());
  protected Nucleus mNucleus = null;
  protected Repository mUserRepository;
  
  @Before
  public void setUp() throws Exception {
    mLog.info("Start Nucleus.");
    try {
      mNucleus = NucleusTestUtils.startNucleusWithModules(new String[] { "DAF.Deployment" }, this.getClass(), "");
      assertThat("Nucleus is null", mNucleus, notNullValue());
      mUserRepository = (Repository) mNucleus.resolveName("/ocrec/UserRepository");
      assertThat("Repository is null", mUserRepository, notNullValue());
    } catch (ServletException e) {
      fail(e.getMessage());
    }
  }

  @After
  public void tearDown() {
    mLog.info("Stop Nucleus");
    if (mNucleus != null) {
      try {
        NucleusTestUtils.shutdownNucleus(mNucleus);
      } catch (ServiceException e) {
        fail(e.getMessage());
      } catch (IOException e) {
        fail(e.getMessage());
      }
    }
  }
  
  @Test
  public void test1() {
    
  }
}
