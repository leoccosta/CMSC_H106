package basic;

public class Bird extends Animal {
	private int height;
	
	public Bird(String inputLoc, int inputHeight) {
		super(inputLoc); // calling the constructor for Animal
		
		height = inputHeight; 
	}
	
	@Override
	public void move(String newLoc) {
		super.move(newLoc);
		height = 0;
	}
	
	public void move(String newLoc, int newHeight) {
		super.move(newLoc);
		height = newHeight;
	}
}
