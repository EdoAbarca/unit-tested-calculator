package com.grupo4.unit_tested_calculator;

public class PedidoService {
    private DescuentoRepository descuentoRepository;

    // Original constructor (no args)
    public PedidoService() {
    }

    // New constructor for dependency injection
    public PedidoService(DescuentoRepository descuentoRepository) {
        this.descuentoRepository = descuentoRepository;
    }

    // Original method with boolean parameters
    public double calcularTotal(double subtotal, boolean aplicaDescuento, boolean envioExpress) {
        double descuento = aplicaDescuento ? 0.1 : 0;
        double envio = envioExpress ? 20.0 : 10.0;
        return (subtotal * (1 - descuento)) + envio;
    }

    // New method with String discount code
    public double calcularTotalConCodigo(double subtotal, String codigoDescuento, boolean envioExpress) {
        if (descuentoRepository == null) {
            throw new IllegalStateException("DescuentoRepository not initialized");
        }
        double descuento = descuentoRepository.obtenerPorcentaje(codigoDescuento);
        double envio = envioExpress ? 20.0 : 10.0;
        return (subtotal * (1 - descuento)) + envio;
    }
}