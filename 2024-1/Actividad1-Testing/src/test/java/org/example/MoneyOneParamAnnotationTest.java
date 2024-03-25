package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
class MoneyOneParamAnnotationTest {
    @ParameterizedTest
    @ValueSource(ints={10,15,50})
    void constructorShouldSetAmountAndCurrency(int amount){
        Money money = new Money(amount,"USD");
        assertThat(money.getAmount()).isEqualTo(amount);
    }
}