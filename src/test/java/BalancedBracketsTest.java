import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class BalancedBracketsTest {
    @Test
    public void empty() {
        assertThat(BalanceBrackets.indexOfUnbalancedBracket("")).isEqualTo(-1);
    }

    @Test
    public void simpleBalanced() {
        assertThat(BalanceBrackets.indexOfUnbalancedBracket("(())")).isEqualTo(-1);
    }

    @Test
    public void complexBalanced() {
        assertThat(BalanceBrackets.indexOfUnbalancedBracket("(()())")).isEqualTo(-1);
    }

    @Test
    public void unbalancedSimple() {
        assertThat(BalanceBrackets.indexOfUnbalancedBracket("()))")).isEqualTo(2);
    }

    @Test
    public void unbalancedComplex() {
        assertThat(BalanceBrackets.indexOfUnbalancedBracket(")()()")).isEqualTo(0);
    }
}
