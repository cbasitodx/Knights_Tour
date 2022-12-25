package aed.knightTour;

public class Coord {
	
	private int[] coord = new int[2];
	
	public Coord(int xPos, int yPos) {
		coord[0] = xPos;
		coord[1] = yPos;
	}
	
	public Integer getX() {
		return coord[0];
	}
	
	public Integer getY() {
		return coord[1];
	}

	@Override
	public int hashCode() {	
		return 31*this.getX() + this.getY();
	}
	
	@Override
	public boolean equals(Object o) {
		//Coord coord = (Coord)o;
		//return coord.getX() == this.getX() && coord.getY() == this.getY();
		return ((Coord)o).hashCode() == this.hashCode();
	}
	
	public static void main(String[] args) {
		
		Coord c1 = new Coord(0,1);
		Coord c2 = new Coord(0,1);
		
		System.out.println(c1.equals(c2));
	}
}
