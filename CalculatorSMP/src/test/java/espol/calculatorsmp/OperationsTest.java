package espol.calculatorsmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    @DisplayName("Solve calcula la resta correctamente")
    void testSolveSubtraction() {
        String result = Operations.Solve("10-4");
        assertEquals("10-4=6", result);
    }

    @Test
    @DisplayName("Solve calcula la multiplicación correctamente")
    void testSolveMultiplication() {
        String result = Operations.Solve("7*6");
        assertEquals("7*6=42", result);
    }

    @Test
    @DisplayName("Solve calcula la división correctamente")
    void testSolveDivision() {
        String result = Operations.Solve("20/4");
        assertEquals("20/4=5", result);
    }

    @Test
    @DisplayName("Solve calcula operaciones mixtas con precedencia")
    void testSolveMixedPrecedence() {
        String result = Operations.Solve("2+3*4");
        assertEquals("2+3*4=14", result); // 2 + (3*4)
    }

    @Test
    @DisplayName("Solve calcula de izquierda a derecha para la misma precedencia")
    void testSolveLeftToRight() {
        String result = Operations.Solve("8-2+3");
        assertEquals("8-2+3=9", result); // (8-2)+3
    }

    @Test
    @DisplayName("Solve maneja múltiples operaciones")
    void testSolveMultipleOperations() {
        String result = Operations.Solve("5+2*3-1");
        assertEquals("5+2*3-1=10", result); // 5+(2*3)-1
    }

    @Test
    @DisplayName("Solve maneja la división por cero correctamente")
    void testSolveDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Operations.Solve("5/0");
        });
        assertTrue(exception.getMessage().contains("/ by zero"));
    }
    
}
