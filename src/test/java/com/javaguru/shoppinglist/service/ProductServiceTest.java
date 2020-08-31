package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductInMemoryRepository repository;
    @Mock
    private ProductValidationService validationService;
    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService victim;

    @Test
    public void shouldSaveProduct() {
        when(repository.save(any())).thenReturn(entity());
        when(productMapper.toDto(entity())).thenReturn(productDto(20L));
        ProductDto dto = victim.save(productDto(null));
        assertEquals(productDto(20L), dto);
    }

    private ProductDto productDto(Long id) {
        ProductDto dto = new ProductDto();
        dto.setId(id);
        dto.setName("Product");
        dto.setDescription("Product_Description");
        dto.setPrice(BigDecimal.ZERO);
        dto.setDiscount(BigDecimal.ZERO);
        dto.setCategory("Test_Category");
        return dto;
    }
    private ProductEntity entity() {
        ProductEntity productEntity = new ProductEntity(
                20L,
                "name",
                "desc",
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                "cat");
        return productEntity;
    }
}