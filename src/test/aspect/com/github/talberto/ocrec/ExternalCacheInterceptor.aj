package com.github.talberto.ocrec;

import java.io.File;
import atg.adapter.gsa.GSARepository;
import atg.adapter.gsa.externalcache.GSAExternalCacheManager;
import com.google.common.io.Files;
import com.github.talberto.ocrec.HeapDumper;

/**
 * @author Tomas Rodriguez (rodriguez@progiweb.com)
 *
 */
public aspect ExternalCacheInterceptor {  
  
  private File tempDir = Files.createTempDir();
  
  pointcut getExternalCacheManager(): get(GSAExternalCacheManager GSARepository.mExternalCacheManager);
  
  pointcut setExternalCacheManager(GSAExternalCacheManager newvalue): set(GSAExternalCacheManager GSARepository.mExternalCacheManager) && args(newvalue);
  
  before(): getExternalCacheManager() {
  	String timestamp = String.valueOf(System.currentTimeMillis());
  	String filename = tempDir.getAbsolutePath() + File.pathSeparator + timestamp;
  	System.out.println(filename);
  	HeapDumper.dumpHeap(filename, false);
  }
  
  before(GSAExternalCacheManager newvalue): setExternalCacheManager(newvalue) {
  	String timestamp = String.valueOf(System.currentTimeMillis());
  	String filename = tempDir.getAbsolutePath() + File.pathSeparator + timestamp;
  	System.out.println(filename);
  	HeapDumper.dumpHeap(filename, false);
  }
}