package projectElements;

//An enum that represents the possible values for a grid space in
//Tic Tac Toe
public enum Piece {
	X, O, NONE;
	
	 public String toString() {
	    switch (this) {
	      case X:
	        return "x ";
	      case O:
	        return "o ";
	      case NONE:
	        return "- ";
	    }

	    return "- ";  // make compiler happy even though we should never reach here
	  }
}
