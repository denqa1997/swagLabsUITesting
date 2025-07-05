package testData;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static utils.propertyManager.SetUpProperty.getProps;

public class TestDataLoginPage {

    public static Stream<Arguments> provideArguments () {
        return Stream.of(
             Arguments.of(getProps("standartLogin")),
             Arguments.of(getProps("lockedOutUserLogin")),
             Arguments.of(getProps("problemUserLogin")),
             Arguments.of(getProps("performanceGlitchUserLogin")),
             Arguments.of(getProps("errorUserLogin")),
             Arguments.of(getProps("visualUserLogin"))
        );
    }
}
