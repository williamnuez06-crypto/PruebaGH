import org.example.CuentaBancaria;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaBancariaTest {
    private CuentaBancaria cuenta;
    @BeforeEach
    void setUp() {
        cuenta = new CuentaBancaria(2000.0); // Saldo inicial de 2000
    }
    @Test
    void testDepositar() {
        cuenta.depositar(300.0);
        assertEquals(2300.0, cuenta.consultarSaldo(), "Depositar 300 debería aumentar el saldo a 2300");
    }
    @Test
    void testDepositarCantidadNegativa() {
        cuenta.depositar(-200.0);
        assertEquals(2000.0, cuenta.consultarSaldo(), "Realizar el depósito de una cantidad negativa no debería cambiar el saldo");
    }
    @Test
    void testRetirarSaldoSuficiente() {
        assertTrue(cuenta.retirar(100.0), "Retirar 100 debería ser exitoso con saldo suficiente");
                assertEquals(1900.0, cuenta.consultarSaldo(), "Después de retirar 100, el saldo debería ser 1900");
    }
    @Test
    void testRetirarSaldoInsuficiente() {
        assertFalse(cuenta.retirar(3000.0), "Retirar 3000 debería provocar que falle método retirar por saldo insuficiente");
        assertEquals(2000.0, cuenta.consultarSaldo(), "El saldo debería permanecer igual después de un intento de retirar saldo superior al disponible");
    }
}
