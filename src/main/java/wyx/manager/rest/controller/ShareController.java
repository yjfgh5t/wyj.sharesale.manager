package wyx.manager.rest.controller;

import org.jeecgframework.core.annotation.JAuth;
import org.jeecgframework.core.enums.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wyx.manager.entity.WyxShareEntity;
import wyx.manager.entity.WyxTempPacketEntity;
import wyx.manager.extend.EMapper;
import wyx.manager.service.WyxShareServiceI;
import wyx.manager.service.WyxStatisticalServiceI;
import wyx.manager.service.WyxTempPacketServiceI;
import wyx.manager.vo.ShareVO;

import java.util.List;

@JAuth(auth = Permission.SKIP_AUTH)
@RestController
@RequestMapping("api/shares")
public class ShareController extends BaseController{

    @Autowired
    WyxShareServiceI wyxShareService;

    @Autowired
    WyxTempPacketServiceI wyxTempPacketService;

    @Autowired
    WyxStatisticalServiceI wyxStatisticalService;

    @Autowired
    EMapper mapper;


    /**
     * 添加分享
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public boolean SaveShare(@RequestBody ShareVO model) throws Exception {
        if(model==null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return false;
        }
        //数据转换
        WyxShareEntity shareModel = mapper.map(model,WyxShareEntity.class);

        WyxTempPacketEntity tempPacket = mapper.map(model,WyxTempPacketEntity.class);

        //分享数据
        wyxShareService.save(shareModel,tempPacket);

        return true;
    }

    /**
     * 获取分享口令-单个
     * @param shareid
     * @return
     */
    @RequestMapping(value = "{id}")
    public String GetShare(@PathVariable("id") int shareid)
    {
        //获取模板数据
        List<WyxTempPacketEntity> listArray = wyxTempPacketService.findByProperty(WyxTempPacketEntity.class,"id",shareid);

        if(null==listArray || listArray.size()==0) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return null;
        }

        //增加查看次数
        wyxStatisticalService.addSeeCount(shareid);

        return listArray.get(0).getTpToken();
    }

    /**
     * 获取分享口令-列表
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<ShareVO> GetShareArray(@RequestParam("uid") String createid){

        List<WyxTempPacketEntity> listArray = wyxTempPacketService.findByProperty(WyxTempPacketEntity.class,"createId",createid);

        if(null==listArray || listArray.size()==0) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return null;
        }

        List<ShareVO> renList = mapper.mapArray(listArray,ShareVO.class);

        return renList;
    }

}
