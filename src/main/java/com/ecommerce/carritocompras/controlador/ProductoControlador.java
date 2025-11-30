package com.ecommerce.carritocompras.controlador;

import com.ecommerce.carritocompras.modelo.Producto;
import com.ecommerce.carritocompras.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("carrito")   
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @ModelAttribute("carrito")
    public List<Producto> carrito() {
        return new ArrayList<>();
    }

    @GetMapping("/")
    public String redirigirAlListado() {
        return "redirect:/productos";
    }

    @GetMapping("/productos")
    public String listarProductos(Model modelo) {
        modelo.addAttribute("productos", productoServicio.obtenerTodosLosProductos());
        return "productos";
    }

    @PostMapping("/carrito/agregar/{id}")
    public String agregarAlCarrito(@PathVariable Long id,
                                   @ModelAttribute("carrito") List<Producto> carrito) {

        Producto producto = productoServicio.obtenerProductoPorId(id);
        if (producto != null) {
            carrito.add(producto);
        }
        return "redirect:/productos";
    }

    @GetMapping("/carrito")
    public String verCarrito(@ModelAttribute("carrito") List<Producto> carrito, Model modelo) {
        modelo.addAttribute("itemsCarrito", carrito);
        return "carrito";
    }

    @PostMapping("/carrito/vaciar")
    public String vaciarCarrito(@ModelAttribute("carrito") List<Producto> carrito) {
        carrito.clear();
        return "redirect:/carrito";
    }
}
