package prZoologicoDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Animal a = new Animal ("Ardilla", "Bosque", 0.1);
		//AnimalDAO.insertAnimal(a);
		//AnimalDAO.deleteAnimal();
		//AnimalDAO.deleteAnimalByNombre("Ardilla");
		Animal a = AnimalDAO.findById(4);
		System.out.println(a);
		
	}

}
