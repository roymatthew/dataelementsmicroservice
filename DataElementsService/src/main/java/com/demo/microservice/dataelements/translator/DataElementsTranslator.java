/**
 * 
 */
package com.demo.microservice.dataelements.translator;

import com.demo.microservice.dataelements.entity.DataElement;
import com.demo.microservice.dataelements.vo.DataElementVO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author rmathew
 *
 */
public class DataElementsTranslator {

    /**
     * @param dataElementsByElementType
     * @return
     */
    public static Collection<DataElementVO> translateEntityCollection(
        final List<DataElement> dataElementsByElementType) {
        final List<DataElementVO> voList = new ArrayList<>();
        for (DataElement dataElement : dataElementsByElementType)
        {
            final DataElementVO vo = new DataElementVO();
            vo.setId(dataElement.getId());
            vo.setDisplayName(dataElement.getDisplayName());
            vo.setElementName(dataElement.getElementName());
            vo.setElementType(dataElement.getElementType());
            vo.setGroupName(dataElement.getGroupName());
            voList.add(vo);
        }
        return voList;
    }

    /**
     * @param dataElementVO
     * @return
     */
    public static DataElement translateVOtoEntity(final DataElementVO dataElementVO) {
        final DataElement dataElement = new DataElement();
        dataElement.setDisplayName(dataElementVO.getDisplayName());
        dataElement.setElementName(dataElementVO.getElementName());
        dataElement.setElementType(dataElementVO.getElementType());
        dataElement.setGroupName(dataElementVO.getGroupName());
        
        return dataElement;
    }

    /**
     * @param addNewDataElement
     * @return
     */
    public static DataElementVO translateEntity(DataElement dataElement) {
        final DataElementVO vo = new DataElementVO();
        vo.setId(dataElement.getId());
        vo.setDisplayName(dataElement.getDisplayName());
        vo.setElementName(dataElement.getElementName());
        vo.setElementType(dataElement.getElementType());
        vo.setGroupName(dataElement.getGroupName());
        return vo;
    }

}
