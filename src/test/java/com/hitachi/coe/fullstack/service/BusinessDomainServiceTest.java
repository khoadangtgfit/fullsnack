package com.hitachi.coe.fullstack.service;

import com.hitachi.coe.fullstack.entity.BusinessDomain;
import com.hitachi.coe.fullstack.entity.Practice;
import com.hitachi.coe.fullstack.model.BusinessDomainModel;
import com.hitachi.coe.fullstack.repository.BusinessDomainRepository;
import com.hitachi.coe.fullstack.repository.PracticeRepository;
import com.hitachi.coe.fullstack.service.impl.BusinessDomainServiceImpl;
import com.hitachi.coe.fullstack.transformation.BusinessDomainModelTransformer;
import com.hitachi.coe.fullstack.transformation.BusinessDomainTransformer;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class BusinessDomainServiceTest {

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    BusinessDomainServiceImpl businessDomainService;

    @Mock
    BusinessDomainRepository businessDomainRepository;

    @Mock
    BusinessDomainTransformer businessDomainTransformer;

    @Mock
    BusinessDomainModelTransformer businessDomainModelTransformer;

    @Mock
    PracticeRepository practiceRepository;

    @Test
    public void testGetAllBusinessDomians(){
        List<BusinessDomainModel> businessDomainModelList= new ArrayList<>();
        for(int i=0;i<3;i++){
            BusinessDomainModel businessDomainModel=new BusinessDomainModel();
            businessDomainModel.setCode("code"+i);
            businessDomainModel.setDescription("decription"+i);
            businessDomainModel.setName("name"+i);
            businessDomainModel.setCreatedBy("khoa"+i);
            businessDomainModel.setUpdatedBy("khoa"+i);
            businessDomainModelList.add(businessDomainModel);
        }
        List<BusinessDomainModel> businessDomainModelList1 = businessDomainTransformer.applyList(businessDomainRepository.findAll());
        when(businessDomainTransformer.applyList(businessDomainRepository.findAll())).thenReturn(businessDomainModelList);

        List<BusinessDomainModel> result=businessDomainService.getBusinessDomains();
        assertEquals(3,result.size());
    }

    @Test
    public void addBusinessDomain(){
//        Practice practice=practiceRepository.getById(2);
        BusinessDomain businessDomain=new BusinessDomain();
        businessDomain.setId(1);
        businessDomain.setCode("1s");
        businessDomain.setDescription("ds");
        businessDomain.setName("ds");
//        businessDomain.setPractice(practice);

        when(businessDomainRepository.save(businessDomain)).thenReturn(businessDomain);

        BusinessDomain result=businessDomainModelTransformer.apply(businessDomainService.addBusinessDomain(2,businessDomainTransformer.apply(businessDomain)));
        assertEquals(Optional.of(1),result.getId());

    }
}
