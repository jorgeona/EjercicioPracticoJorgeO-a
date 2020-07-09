package ec.com.altioracorp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ec.com.altioracorp.entities.dto.ArticuloDTO;
import ec.com.altioracorp.entities.dto.ClienteDTO;
import ec.com.altioracorp.entities.dto.DetalleCompraDTO;
import ec.com.altioracorp.entities.dto.OrdenDTO;
import ec.com.altioracorp.repository.IArticuloRepository;
import ec.com.altioracorp.repository.IClienteRepository;
import ec.com.altioracorp.repository.IDetalleCompraRepository;
import ec.com.altioracorp.repository.IOrdenRepository;
import ec.com.altioracorp.service.IClienteServicio;

@Controller
public class Controlador {

	@Autowired
	private IClienteRepository clienteCrud;
	@Autowired
	private IArticuloRepository articuloCrud;
	@Autowired
	private IOrdenRepository ordenCrud;
	@Autowired
	private IClienteServicio clienteService;
	@Autowired
	private IDetalleCompraRepository detalleCompraCrud;

	@RequestMapping(value = "/listar-cliente", method = RequestMethod.GET)
	public String listaClientes1(ModelMap mp) {
		mp.put("clientes", clienteService.obtenerClientes());
		return "ver-clientes";
	}

	@GetMapping("/registar-cliente")
	public String showSignUpForm(ClienteDTO clientedto) {
		return "add-user";
	}

	@PostMapping("/adduser")
	public String addUser(@Valid ClienteDTO clientedto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}
		clienteCrud.save(clientedto);
		model.addAttribute("clientes", clienteCrud.findAll());
		return "ver-clientes";
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listaClientes(ModelMap mp) {
		mp.put("clientes", clienteService.obtenerClientes());
		mp.put("articulos", articuloCrud.findAll());
		mp.put("ordenes", ordenCrud.findAll());
		mp.put("detallecompras", detalleCompraCrud.findAll());
		return "ver-pedidos";
	}

	@GetMapping("/delete/{idcliente}")
	public String deleteUser(@PathVariable("idcliente") long idcliente, Model model) {
		ClienteDTO clientedto = clienteCrud.findById(idcliente)
				.orElseThrow(() -> new IllegalArgumentException("Id de cliente invalido:" + idcliente));
		clienteCrud.delete(clientedto);
		model.addAttribute("clientes", clienteCrud.findAll());
		return "ver-clientes";
	}

	@GetMapping("/edit/{idcliente}")
	public String showUpdateForm(@PathVariable("idcliente") long idcliente, Model model) {
		ClienteDTO clientedto = clienteCrud.findById(idcliente)
				.orElseThrow(() -> new IllegalArgumentException("Id de cliente invalido:" + idcliente));
		model.addAttribute("clientedto", clientedto);
		return "update-user";
	}

	@PostMapping("/update/{idcliente}")
	public String updateUser(@PathVariable("idcliente") long idcliente, @Valid ClienteDTO clientedto,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			clientedto.setIdcliente(idcliente);
			return "update-user";
		}

		clienteCrud.save(clientedto);
		model.addAttribute("clientes", clienteCrud.findAll());
		return "ver-clientes";
	}

	// controlador articulos

	@RequestMapping(value = "/listar-articulo", method = RequestMethod.GET)
	public String listaArticulos(ModelMap mp) {
		mp.put("articulos", articuloCrud.findAll());
		return "ver-articulos";
	}

	@GetMapping("/registar-articulo")
	public String showSignUpForm(ArticuloDTO articulo) {
		return "add-userArt";
	}

	@PostMapping("/adduser1")
	public String addUser(@Valid ArticuloDTO articulo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-userArt";
		}
		articuloCrud.save(articulo);
		model.addAttribute("articulos", articuloCrud.findAll());
		return "ver-articulos";
	}

	@GetMapping("/delete1/{idarticulo}")
	public String deleteArticulo(@PathVariable("idarticulo") long idarticulo, Model model) {
		ArticuloDTO articulo = articuloCrud.findById(idarticulo)
				.orElseThrow(() -> new IllegalArgumentException("Id articulo invalido:" + idarticulo));
		articuloCrud.delete(articulo);
		model.addAttribute("articulos", articuloCrud.findAll());
		return "ver-articulos";
	}

	@GetMapping("/edit1/{idarticulo}")
	public String showUpdateForm3(@PathVariable("idarticulo") long idarticulo, Model model) {
		ArticuloDTO articulo = articuloCrud.findById(idarticulo)
				.orElseThrow(() -> new IllegalArgumentException("Invalid usuario Id:" + idarticulo));
		model.addAttribute("articulo", articulo);
		return "update-userArt";
	}

	@PostMapping("/update1/{idarticulo}")
	public String updateArt(@PathVariable("idarticulo") long idarticulo, @Valid ArticuloDTO articulo,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			articulo.setIdarticulo(idarticulo);
			return "update-userArt";
		}

		articuloCrud.save(articulo);
		model.addAttribute("articulos", articuloCrud.findAll());
		return "ver-articulos";
	}

	// controlador orden
	
	@RequestMapping(value = "/listar-orden", method = RequestMethod.GET)
	public String listaOrdenes(ModelMap mp) {
		mp.put ("ordenes", ordenCrud.findAll());
		return "ver-ordenes";
	}

	@GetMapping("/registrar-orden")
	public String showSignUpForm(OrdenDTO orden) {
		return "add-userOrd";
	}

	@PostMapping("/adduser2")
	public String addUser(@Valid OrdenDTO orden, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-userOrd";
		}
		List<ArticuloDTO> articuloSel = new ArrayList<>();
		model.addAttribute("articuloSel", articuloSel);
		List<ArticuloDTO> articuloSelect = (List<ArticuloDTO>) (articuloCrud.findAll());
		model.addAttribute("articuloSelect", articuloSelect);
		ordenCrud.save(orden);
		model.addAttribute("ordenes", ordenCrud.findAll());
		return "ver-ordenes";
	}

	@GetMapping("/delete2/{idorden}")
	public String deleteOrden(@PathVariable("idorden") long idorden, Model model) {
		OrdenDTO orden = ordenCrud.findById(idorden)
				.orElseThrow(() -> new IllegalArgumentException("Id orden invalido:" + idorden));
		ordenCrud.delete(orden);
		model.addAttribute("ordenes", ordenCrud.findAll());
		return "ver-ordenes";
	}

	@GetMapping("/edit2/{idorden}")
	public String showUpdateForm2(@PathVariable("idorden") long idorden, Model model) {
		OrdenDTO orden = ordenCrud.findById(idorden)
				.orElseThrow(() -> new IllegalArgumentException("Id de orden invalida:" + idorden));
		model.addAttribute("orden", orden);
		return "update-userOrd";
	}

	@PostMapping("/update2/{idorden}")
	public String updateOrd(@PathVariable("idorden") long idorden, @Valid OrdenDTO orden, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			orden.setIdorden(idorden);
			return "update-userOrd";
		}

		ordenCrud.save(orden);
		model.addAttribute("ordenes", ordenCrud.findAll());
		return "ver-ordenes";
	}
//controlador  compra
	
	@RequestMapping(value = "/listar-detalle", method = RequestMethod.GET)
	public String listaDetalle(ModelMap mp) {
		mp.put("detallecompras", detalleCompraCrud.findAll());
		return "ver-compras";
	}
	
	@GetMapping("/registrar-compra")
	public String showSignUpForm2(DetalleCompraDTO detalleCompraDto) {
		return "add-compra";
	}

	@PostMapping("/addcompra")
	public String addUser(@Valid DetalleCompraDTO detalleCompra, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-compra";
		}
		detalleCompraCrud.save(detalleCompra);
		model.addAttribute("detallecompras", detalleCompraCrud.findAll());
		return "ver-compras";
	}
	
	@GetMapping("/delete3/{iddetalle}")
	public String deleteDetalle(@PathVariable("iddetalle") long iddetalle, Model model) {
		DetalleCompraDTO detalleCompra = detalleCompraCrud.findById(iddetalle)
				.orElseThrow(() -> new IllegalArgumentException("Id Detalle invalido:" + iddetalle));
		detalleCompraCrud.delete(detalleCompra);
		model.addAttribute("detallecompras", detalleCompraCrud.findAll());
		return "ver-compras";
	}
	
	@GetMapping("/edit3/{iddetalle}")
	public String showUpdateForm4(@PathVariable("iddetalle") long iddetalle, Model model) {
		DetalleCompraDTO detalleCompra = detalleCompraCrud.findById(iddetalle)
				.orElseThrow(() -> new IllegalArgumentException("Id Detalle invalido:" + iddetalle));
		model.addAttribute("detalleCompra", detalleCompra);
		return "update-userDet";
	}

	@PostMapping("/update3/{iddetalle}")
	public String updateDetalle(@PathVariable("iddetalle") long iddetalle, @Valid DetalleCompraDTO detalleCompra, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			detalleCompra.setIddetalle(iddetalle);
			return "update-userDet";
		}

		detalleCompraCrud.save(detalleCompra);
		model.addAttribute("detalleCompras", detalleCompraCrud.findAll());
		return "ver-compras";
	}
	
	
}
