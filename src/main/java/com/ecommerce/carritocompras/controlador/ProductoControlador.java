package com.ecommerce.carritocompras.controlador;

import com.ecommerce.carritocompras.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public String listarProductos(Model modelo) {
        // Cargamos la lista de productos desde el servicio
        modelo.addAttribute("productos", productoServicio.obtenerTodosLosProductos());

        // Nombre de la vista Thymeleaf (productos.html)
        return "productos";
    }
}

