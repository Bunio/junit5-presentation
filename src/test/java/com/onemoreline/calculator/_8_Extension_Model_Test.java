package com.onemoreline.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


// Extensions can be declared on both method and class level
// Multiple extensions can be declared (in contrast to JUnit4 runners, where you can define only one Runner per class).
// You can define your own extensions, by implementing one of extension-specific interfaces eg:

@ExtendWith(BeforeCalculatorExtension.class)
public class _8_Extension_Model_Test {

    @Test
    @ExtendWith(CalculatorExtension.class)
    public void shouldAddNumbers(Calculator calculator) {
        assertEquals(15, calculator.add(10,5 ));
    }
}

class CalculatorExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == Calculator.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new Calculator();
    }
}

class BeforeCalculatorExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("BEFORE");
    }
}