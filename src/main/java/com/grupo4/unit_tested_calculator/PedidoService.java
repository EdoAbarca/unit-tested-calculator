package com.grupo4.unit_tested_calculator;

public class PedidoService {
    public double calcularTotal(double subtotal, boolean    aplicaDescuento, boolean envioExpress) {
        double descuento = aplicaDescuento ? 0.1 : 0;
        double envio = envioExpress ? 20.0 : 10.0;
        return (subtotal * (1 - descuento)) + envio;
    }
}