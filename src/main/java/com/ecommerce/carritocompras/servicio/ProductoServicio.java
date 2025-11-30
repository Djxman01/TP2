package com.ecommerce.carritocompras.servicio;

import com.ecommerce.carritocompras.modelo.Producto;
import com.ecommerce.carritocompras.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    // Método para obtener todos los productos de la base de datos
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepositorio.findAll();
    }
    public Producto obtenerProductoPorId(Long id) {
    return productoRepositorio.findById(id).orElse(null);
}
}


