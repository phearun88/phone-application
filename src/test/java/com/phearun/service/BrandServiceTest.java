/**
 * Author : PhearunPhin
 * Date : 7/28/2023
 */

package com.phearun.service;

import com.phearun.exception.ApiException;
import com.phearun.model.Brand;
import com.phearun.repository.BrandRepository;
import com.phearun.service.impl.BrandServiceImpl;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.AssertionErrors;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    private  BrandService brandService;

    private Brand brand;

    @BeforeEach
    public void setUp(){

        brandService = new BrandServiceImpl(brandRepository);
        brand = new Brand(1,"Apple");

        when(brandRepository.findById(1)).thenReturn(Optional.of(brand));
    }

   // @Test
    public void testSaveBrandOld(){

        //given
        Brand brand = new Brand();
        brand.setName("Apple");
        //when
        when(brandRepository.save(any(Brand.class))).thenAnswer(new Answer<Brand>() {
            @Override
            public Brand answer(InvocationOnMock invocation) throws Throwable {
                Brand brandEntity = invocation.getArgument(0);
                brandEntity.setId(1);
                return brandEntity;
            }
        });
        /*
        when(brandRepository.save(any(Brand.class))).thenAnswer(invocation -> {
            Brand brandEntity = invocation.getArgument(0);
            brandEntity.setId(1);
            return brandEntity;
        });
         */

        Brand branReturn = brandService.save(brand);

        //then

          assertEquals("Apple",branReturn.getName());
          assertEquals(1, branReturn.getId());
    }
    @Test
    public void testSaveBrand(){

        //given
        Brand brand = new Brand();
        brand.setName("Apple");

        //when
        Brand branReturn = brandService.save(brand);

        //then
        verify(brandRepository, times(1)).save(brand);

    }

    @Test
    public void getByIdSuccess(){
        //given
        Brand brand = new Brand(1, "Apple");

        //when
        when(brandRepository.findById(1)).thenReturn(Optional.of(brand));

        //then
        Brand brandReturn = brandService.getById(1);
        assertNotNull(brandReturn);
        assertEquals("Apple",brandReturn.getName());
        assertEquals(1, brandReturn.getId());
    }

    @Test
    public void getByIdThrowException(){

        //given

        //when
        when(brandRepository.findById(2)).thenReturn(Optional.empty());

        //then

        assertThatThrownBy(()->brandService.getById(2))
        .isInstanceOf(ApiException.class)
        .hasMessageStartingWith("brand not found for id=");
    }

    @Test
    public void testUpdateBrand(){
        //given
     //   Brand brandFromDB = new Brand(1, "Apple");
        Brand brandUpdate = new Brand(1, "Apple V2");

        //when
     //   when(brandRepository.findById(1)).thenReturn(Optional.of(brandFromDB));
        Brand brandAfterUpdate = brandService.update(1, brandUpdate);

        //then
        verify(brandRepository, times(1)).save(brandUpdate);
        //@TODO check brandAfterUpdate.getName() if it equals to "Apple V2"
       // assertEquals(brandAfterUpdate.getName(), "Apple V2");
    }

    @Test
    public void testDeleteBrand(){
        //given
        Integer brandToDelete = 1;

      //  Brand brand = new Brand(1,"Apple");
      //  when(brandRepository.findById(1)).thenReturn(Optional.of(brand));
        //when
        brandService.delete(brandToDelete);
        //then
        verify(brandRepository, times(1)).delete(brand);
    }


    @Test
    public void testListBrand(){

        //given
        List<Brand>brands = List.of(
                new Brand(1, "Apple"),
                new Brand(2, "Samsung")
        );

        //when
        when(brandRepository.findAll()).thenReturn(brands);
        List<Brand> brandsReturn = brandService.getBrands();

        //then
        assertEquals(2, brandsReturn.size());
        assertEquals("Apple", brandsReturn.get(0).getName());
        assertEquals("Samsung", brandsReturn.get(1).getName());

    }

}
