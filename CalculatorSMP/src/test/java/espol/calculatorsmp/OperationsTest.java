package espol.calculatorsmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author CltControl
 */
public class OperationsTest {
    
    public OperationsTest() {
    }
    
    @Test
    @DisplayName("MakeFormula genera una cadena de fórmula válida")
    void testMakeFormulaFormat() {
        String formula = Operations.MakeFormula();
        assertTrue(formula.matches("\\d+([+\\-*/]\\d+)+"), "Formula tiene que tener el formato correcto");
    }

    @Test
    @DisplayName("Solve calcula la suma correctamente")
    void testSolveAddition() {
        String result = Operations.Solve("3+5");
        assertEquals("3+5=8", result);
    }
}