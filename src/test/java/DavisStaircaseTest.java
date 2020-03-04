import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class DavisStaircaseTest {
    @Test
    public void hackerank_samples() {
        assertThat(DavisStaircase.stepPerms(1)).isEqualTo(1);
        assertThat(DavisStaircase.stepPerms(3)).isEqualTo(4);
        assertThat(DavisStaircase.stepPerms(7)).isEqualTo(44);
    }
}
