package wyx.manager.vo;


import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseVO<T> {

    public BaseVO(){

    }

    /**
     * 拷贝字段
     * @return
     */
    public BaseVO copyModel(T obj){

        BeanUtils.copyProperties(obj,this);

        return this;
    }

    /**
     * cop集合
     * @param source
     * @return
     */
    public List<BaseVO> copyArray(List<T> source){

        if(null==source)
        {
            return  null;
        }

        List<BaseVO> _tList = new ArrayList<>();

        BaseVO _baseVO =null;

        for (Object item : source) {
            _baseVO = new ShareIconVO();

            BeanUtils.copyProperties(item, _baseVO);
            _tList.add(_baseVO);
        }
        return  _tList;
    }

}
