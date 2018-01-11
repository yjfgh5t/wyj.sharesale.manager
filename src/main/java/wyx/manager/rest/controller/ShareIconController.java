package wyx.manager.rest.controller;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wyx.manager.entity.WyxShareIconEntity;
import wyx.manager.service.WyxShareIconServiceI;
import wyx.manager.vo.ShareIconVO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ShareIconController{

    @Autowired
    WyxShareIconServiceI wyxShareIconService;

    /**
     * 查询所有icon
     * @return
     */
    @RequestMapping(value = "shareicon",method = RequestMethod.GET)
    public List<ShareIconVO> GetArray(){

        CriteriaQuery criteriaQuery = new CriteriaQuery(WyxShareIconEntity.class);
        criteriaQuery.eq("siDelete","1");

       List<WyxShareIconEntity> shareIconList = wyxShareIconService.getListByCriteriaQuery(criteriaQuery,false);

       List<ShareIconVO> renList = new ShareIconVO<WyxShareIconEntity>().copyArray(shareIconList);

       return renList;
    }


}
