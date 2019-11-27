package be.nmine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WrappertTest {

    @Test
    void should_return_true(){
        //Given
        boolean expected = true;
        //When
        boolean result = DummyTest.test();
        //Then
        assertThat(result).isEqualTo(expected);
    }

}
