package com.formacion.nttdata.crud.validator;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.formacion.nttdata.crud.dto.Employee;

public class Validator {
	
	public static int comprobarFormulario(Employee employee, Model model) {
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
		}*/
		int cont=0;
		if(employee.getFullname().isEmpty()) {
            model.addAttribute("errorNombre","error de nombre");
            //return EMPLOYEE;
            cont++;
        }
		if(employee.getEmail().isEmpty()) {
            model.addAttribute("errorEmail","error de email");
            //return EMPLOYEE;
            cont++;
        }
		if(employee.getGender() == null) {
            model.addAttribute("errorGender","error de gender");
            //return EMPLOYEE;
            cont++;
        }
		if(employee.getHobbies() == null) {
            model.addAttribute("errorHobbies","error de hobbies");
            //return EMPLOYEE;
            cont++;
        }
		if(employee.getAddress().isEmpty()) {
            model.addAttribute("errorAddress","error de direccion");
            //return EMPLOYEE;
            cont++;
        }
		return cont;
	}

}
