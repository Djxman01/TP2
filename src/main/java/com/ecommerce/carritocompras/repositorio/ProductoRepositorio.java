package com.ecommerce.carritocompras.repositorio;

import com.ecommerce.carritocompras.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}
