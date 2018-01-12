package wyx.manager.extend;

import org.dozer.Mapper;

import java.util.List;

public interface EMapper extends Mapper {

    /**
     * 集合转换
     * @param listArry
     * @param classObj
     * @param <T>
     * @return
     */
    <T,Z> List<T> mapArray(List<Z> listArry,Class<T> classObj);
}
