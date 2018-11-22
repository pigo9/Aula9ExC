/**
 * Represents binary images.
 * Image data is represented as a matrix:
 * - the number of lines corresponds to the image height (data.length)
 * - the length of the lines corresponds to the image width (data[*].length)
 * - false values are mapped to black
 * - true values are mapped to white
 */
class BinaryImage {

	private boolean[][] data; // @binaryimage

	/**
	 * Creates a black binary image with the given dimension in pixels.
	 */
	BinaryImage(int width, int height) {
		data = new boolean[height][width];
	}

	/**
	 * Image width in pixels.
	 */
	int getWidth() {
		return data[0].length;
	}

	/**
	 * Image height in pixels.
	 */
	int getHeight() {
		return data.length;
	}

	/**
	 * Is pixel at (x, y) black?
	 */
	boolean isBlack(int x, int y) {
		validatePosition(x, y);
		return !data[y][x];
	}

	/**
	 * Sets the pixel at (x, y) to white.
	 */
	void setWhite(int x, int y) {
		validatePosition(x, y);
		data[y][x] = true;
	}

	/**
	 * Sets the pixel at (x, y) to black.
	 */
	void setBlack(int x, int y) {
		validatePosition(x, y);
		data[y][x] = false;
	}

	/**
	 * Is (x, y) a valid pixel position in this image?
	 */
	boolean validPosition(int x, int y) {
		return 
				x >= 0 && x < getWidth() &&
				y >= 0 && y < getHeight();
	}

	/**
	 * Validates if the given (x, y) is a valid pixel position,
	 * throwing an exception in case if it is not.
	 */
	void validatePosition(int x, int y) {
		if(!validPosition(x, y))
			throw new IllegalArgumentException(
					"invalid point " + x + ", " + y + 
					": matrix dimension is " + getWidth() + " x " + getHeight());
	}
	
	
	
	
	// Exercicio C.1

	BinaryImage(Rectangle r) {
		this(r.width, r.height);
	}

	// Exercicio C.2

	Rectangle createRectangleFromThis() {
		return new Rectangle(this.getWidth(), this.getHeight());
	}

	// Exercicio C.3

	boolean isWhite(Point p) {
		return !isBlack(p.x, p.y);
	}

	// Exercicio C.4

	void paint(Point p, boolean white) {
		if(white==!isBlack(p.x,p.y)){
			setBlack(p.x,p.y);
		} else {
			setWhite(p.x,p.y);
		}
	}
	
	// Exercicio C.5
	
	int getCount(boolean white) { 
		int sum=0;
		for(int i=0; i<this.getWidth();i++){
			for(int i2=0; i2<this.getHeight();i2++){
				if(white==!isBlack(i,i2)){
					sum+=1;
				} else {
				}
			}
		}
		return sum;
	}


	
	//Exercicio C.6

	Point[] getPoints(boolean white) {
		Point[] pointVector = new Point[getCount(white)];
		int counter=0;
		for (int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++) {
				if (white == !isBlack(x, y)) {
					pointVector[counter]=new Point(x,y);
					counter+=1;
				} else {
				}
			}
		}
		return pointVector;
	}
	
	//Exercicio C.7
	
	void invert(){
		for(int y=0; y<this.getHeight(); y++){
			for(int x=0; x<this.getWidth(); x++){
				if(isBlack(x,y)==true){
					setWhite(x,y);
				} else {
					setBlack(x,y);
				}
			}
		}
	}
	
	
	//Exercicio C.8
	
	void fillRectangle(Point p, Rectangle r) { 
		for(int y=p.y; y<r.height+p.y;y++){
			for(int x=p.x; x<r.width+p.x;x++){
				if(validPosition(x,y)==true){
					setWhite(x,y);
				}
			}
		}
	}
	
	
	//Exercicio C.9

	void fillAroundRectangle(Point p, Rectangle r) {
		for (int x = p.x; x <= r.width + p.x; x++) {
			if (validPosition(x, p.y) == true) {
				setWhite(x, p.y);
			}
			if (validPosition(x, p.y + r.height) == true) {
				setWhite(x, p.y + r.height);
			}
		}
		for (int y = p.y+1; y <= r.height-1 + p.y; y++) {
			if (validPosition(p.x, y) == true) {
				setWhite(p.x, y);
			}
			if (validPosition(p.x + r.width, y) == true) {
				setWhite(p.x + r.width, y);

			}
		}
	}
	
	
	//Exercicios C.10

	void changeSize(Rectangle r) {
		boolean[][] matrix = new boolean[r.height][r.width];
		for(int y=0; y<r.height;y++){
			for(int x=0; x<r.width;x++){
					if(x<this.getWidth() && y<this.getHeight()){
						if(isBlack(x,y)==true){
							matrix[y][x]=false;
						} else {
							matrix[y][x]=true;
						}
					} else {
						matrix[y][x]=false;
					}
				}
			}
		
		data = matrix;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}