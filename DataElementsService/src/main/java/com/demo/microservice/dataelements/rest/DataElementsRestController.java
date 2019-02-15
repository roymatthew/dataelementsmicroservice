/**
 * 
 */
package com.demo.microservice.dataelements.rest;

import com.demo.microservice.dataelements.service.DataElementService;
import com.demo.microservice.dataelements.translator.DataElementsTranslator;
import com.demo.microservice.dataelements.vo.DataElementVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author rmathew
 *
 */
@Controller
@RequestMapping(value = "/dataelements")
public class DataElementsRestController {
    
    @Autowired
    private DataElementService dataElementService;
    
    @GetMapping(value="/elementtype/{elementType}")
    @ResponseBody
    public List<DataElementVO> listDataElementsByElementType(@PathVariable final String elementType)
    {
        final List<DataElementVO> listOfDataElements = new ArrayList<>();
        listOfDataElements.addAll(DataElementsTranslator.translateEntityCollection(dataElementService.getDataElementsByElementType(elementType)));
        return listOfDataElements;
    }
    
    @PostMapping(value="/new")
    @ResponseBody
    public DataElementVO addDataElement(@RequestBody final DataElementVO dataElementVO)
    {
        return DataElementsTranslator.translateEntity(dataElementService.addNewDataElement(dataElementVO));
    }

}
