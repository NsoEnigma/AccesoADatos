package prZoologicoDAO;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Animal a = new Animal ("Ardilla", "Bosque", 0.1);
		//AnimalDAO.insertAnimal(a);
		//Animal a = new Animal ("Kakapoo", "Bosque", 5);
		//AnimalDAO.insertAnimal(a);
		//AnimalDAO.deleteAllAnimales();
		//AnimalDAO.deleteAnimalByNombre("ARDILLA");
		//Animal a = AnimalDAO.findById(4);
		//System.out.println(a);
		
		Animal a = AnimalDAO.findById(4);
		a.setPeso_aproximado(10);
		AnimalDAO.updateAnimal(a); 
		
		ArrayList<Animal> animales = AnimalDAO.findAllAnimales();
		
		for (int i = 0; i < animales.size(); i++) {
			System.out.println(animales.get(i));
		}
	}

}
