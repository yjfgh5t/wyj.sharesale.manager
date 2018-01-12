package wyx.manager.extend.impl;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import wyx.manager.extend.EMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("EMapper")
public class EMapperImpl extends DozerBeanMapper implements EMapper {

    @Override
    public <T,Z> List<T> mapArray(List<Z> listArry, Class<T> classObj) {

        //判断非空
        if(null==listArry || listArry.size()==0) {
            return null;
        }

        List<T> renArry = new ArrayList<>(listArry.size());

        //添加到集合
        for(Z item :listArry)
        {
            renArry.add(map(item,classObj));
        }

        return renArry;
    }
}
