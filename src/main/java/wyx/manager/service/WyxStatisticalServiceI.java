package wyx.manager.service;
import wyx.manager.entity.WyxStatisticalEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WyxStatisticalServiceI extends CommonService{
	
 	public void delete(WyxStatisticalEntity entity) throws Exception;
 	
 	public Serializable save(WyxStatisticalEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WyxStatisticalEntity entity) throws Exception;
 	
}
