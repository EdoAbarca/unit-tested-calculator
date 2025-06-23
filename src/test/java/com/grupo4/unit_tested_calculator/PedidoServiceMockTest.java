package com.grupo4.unit_tested_calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoServiceMockTest {

    @Test
    void testConMockDeDescuento() {
        // 1. Create mock
        DescuentoRepository mockRepo = mock(DescuentoRepository.class);
        
        // 2. Configure mock behavior
        when(mockRepo.obtenerPorcentaje("PROMO10")).thenReturn(0.10);
        
        // 3. Create service with mock dependency
        PedidoService service = new PedidoService(mockRepo);
        
        // 4. Execute test using the new method
        double total = service.calcularTotalConCodigo(100, "PROMO10", true);
        
        // 5. Verify result
        assertEquals(110.0, total); // 100 - 10% + 20
        
        // 6. Verify mock interaction
        verify(mockRepo).obtenerPorcentaje("PROMO10");
    }
}