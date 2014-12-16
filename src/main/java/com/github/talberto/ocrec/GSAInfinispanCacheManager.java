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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import atg.adapter.gsa.GSAItemDescriptor;
import atg.adapter.gsa.GSARepository;
import atg.adapter.gsa.externalcache.GSAExternalCacheAdapter;
import atg.adapter.gsa.externalcache.GSAExternalCacheManager;

/**
 * 
 * @author Tomas Rodriguez (rodriguez@progiweb.com)
 * 
 */
public class GSAInfinispanCacheManager implements GSAExternalCacheManager {

  protected final Logger mLog = LoggerFactory.getLogger(GSAInfinispanCacheManager.class);
  
  @Override
  public GSAExternalCacheAdapter getExternalCacheAdapter(GSARepository pRepository, GSAItemDescriptor pItemDescriptor) {
    mLog.debug("getExternalCacheAdapter({}, {})", pRepository, pItemDescriptor);
    return new GSAInfinispanCacheAdapter();
  }
}
