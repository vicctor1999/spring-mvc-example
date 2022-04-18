package com.formacion.nttdata.crud.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.formacion.nttdata.crud.dao.EmployeeMapper;
import com.formacion.nttdata.crud.dto.Employee;
import com.formacion.nttdata.crud.validator.Validator;


/* NOTAS
 * Corregir los campos erroneos en el formulario de addEmployee
 * Añadir campo fecha al registrar y al actualizar
 * Comprobar email???
 * 
 * */

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeMapper employeeMapper;
	private static final String EMPLOYEE = "Employee";
	private static final String EMPLOYEELIST = "ListEmployees";

	@RequestMapping("/listOfEmployee")
	public String showListOfEmployees(Model model) {
		model.addAttribute("employeeList", employeeMapper.getAllEmployees());
		return EMPLOYEELIST;
	}

	@RequestMapping("/showFormForAdd")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return EMPLOYEE;
	}

	@RequestMapping("/saveProcess")
	public String saveEmployee(@ModelAttribute("employee") Employee employee,Model model) {
		Validator validator = new Validator();
		/*ArrayList <String> errors= new ArrayList<>();
		if(employee.getFullname().isEmpty()) {
			 System.out.println("El nombre está vacio"); 
			 errors.add("El nombre está vacio");
		}
		
		if(employee.getEmail().isEmpty()) {
			 System.out.println("El email está vacio"); 
			 errors.add("El email está vacio");
		}
		if(employee.getGender()== null) {
			 System.out.println("Escoge un genero"); 
			 errors.add("El genero está vacio");
		}
		if(employee.getHobbies() == null) {
			 System.out.println("Introduce al menos un hobbie"); 
			 errors.add("Introduce al menos un hobbie");
		}
		if(employee.getCountry().isEmpty()) {
			 System.out.println("Escoge un pais"); 
			 errors.add("Escoge un pais");
		}
		if(employee.getAddress().isEmpty()) {
			 System.out.println("Introduce tu direccion"); 
			 errors.add("Introduce tu direccion");
		}
		if(errors.size()!=0) {
			System.out.println("El formulario contiene errores"); 
			model.addAttribute("errors",errors);
			return EMPLOYEE;
		}*/
		int contador=validator.comprobarFormulario(employee, model);
		if (contador != 0) {
			 System.out.println(contador); 
			 return EMPLOYEE;	
		}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");   
       	employee.setFecha(dtf.format(LocalDateTime.now()));
		if (employee.getId() == null) {
			employeeMapper.saveEmployee(employee);
		} else {
			employeeMapper.updateEmployee(employee);
		}
		return "redirect:/employee/listOfEmployee";
	}

	@RequestMapping("/displayUpdateForm")
	public String showUpdateForm(@RequestParam("employeeId") int employeeId, Model model) {
		model.addAttribute("employee", employeeMapper.findById(employeeId));
		return EMPLOYEE;
	}

	@RequestMapping("/displayDeleteForm")
	public String deleteEmployee(@RequestParam("employeeId") int employeeId) {
		employeeMapper.deleteEmployee(employeeId);
		return "redirect:/employee/listOfEmployee";
	}
}