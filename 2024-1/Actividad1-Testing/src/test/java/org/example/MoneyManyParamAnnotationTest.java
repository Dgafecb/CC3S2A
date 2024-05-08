package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

class MoneyManyParamAnnotationTest {
    @ParameterizedTest
    @CsvSource({
            "10,USD",//first set of arguments
            "15,EUR",// 2nd set of arguments
            "50,CHF",// 3rd set of arguments
    })
    void constructorShouldSetAmountAndCurrency(int amount, String currency){
        Money money = new Money (amount, currency);
        assertThat(money.getAmount()).isEqualTo(amount);
        assertThat(money.getCurrency()).isEqualTo(currency);


    }
}