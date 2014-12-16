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

import infinispan.com.google.common.collect.Lists;
import infinispan.com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import atg.adapter.gsa.GSAItemData;
import atg.adapter.gsa.externalcache.GSAExternalCacheAdapter;

/**
 * 
 * @author Tomas Rodriguez (rodriguez@progiweb.com)
 *
 */
public class GSAInfinispanCacheAdapter implements GSAExternalCacheAdapter {

  protected final Logger mLog = LoggerFactory.getLogger(GSAInfinispanCacheAdapter.class);
  protected final EmbeddedCacheManager mCacheManager = new DefaultCacheManager();
  protected final Cache<String, GSAItemData> mCache = mCacheManager.getCache();
  
  @Override
  public String dump() {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public int getEntryCount() {
    mLog.debug("getEntryCount()");
    return mCache.size();
  }

  @Override
  public GSAItemData getItemData(String pId) {
    mLog.debug("getItemData({})", pId);
    return mCache.get(pId);
  }

  @Override
  public Map<String, GSAItemData> getItemDatas(List<String> pIds) {
    mLog.debug("getItemDatas({})", pIds);
    Map<String, GSAItemData> datas = Maps.newHashMap();
    
    for(String id : pIds) {
      datas.put(id, mCache.get(id));
    }
    
    return datas;
  }

  @Override
  public void invalidate() {
    mLog.debug("invalidate()");
    mCache.clear();
  }

  @Override
  public List<GSAItemData> putItemData(String pId, GSAItemData pItemData) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public void removeItemData(String pId) {
    mLog.debug("removeItemData({})", pId);
    mCache.remove(pId);
  }

  @Override
  public void resetStatistics() {
    mLog.debug("resetStatistics()");
  }

  @Override
  public void shutdown() {
    mLog.debug("shutdown()");
    mCache.stop();
  }
}
