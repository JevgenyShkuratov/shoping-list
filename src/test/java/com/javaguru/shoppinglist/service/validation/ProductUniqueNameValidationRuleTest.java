package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductUniqueNameValidationRuleTest {

    @Mock
    private ProductInMemoryRepository inMemoryRepository;
    
    @Spy

    @InjectMocks
    private ProductUniqueNameValidationRule victim;

    @Test
    public void shouldThrowExceptionProductMustBeUnique() {
        ProductEntity entity = new ProductEntity(1L,
                "TEST_UNIQUE_NAME",
                "TEST_DESCRIPTION",
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                "TEST_CATEGORY");
        when(inMemoryRepository.findProductByName("TEST_UNIQUE_NAME")).thenReturn(Optional.of(entity));
        ProductDto input = new ProductDto();
        input.setName("TEST_UNIQUE_NAME");

       assertThatThrownBy(()->victim.validate(input))
               .isInstanceOf(IllegalArgumentException.class)
               .hasMessage("Product name must be unique.");

        verify(victim).checkNotNull(input);
    }

    @Test
    public void shouldNotThrowException() {
        ProductDto input = new ProductDto();
        input.setName("TEST_UNIQUE_NAME");

        victim.validate(input);
        verify(victim).checkNotNull(input);
    }
}