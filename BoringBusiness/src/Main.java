import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// With the input, calculate the new position, see if the position is already taken.
		Scanner sc=new Scanner(System.in);
		String line=sc.nextLine();
		
		ArrayList<Position> takenPositions=new ArrayList<>();
		Position currentPosition=new Position(-1,-5);
		takenPositions.add(currentPosition);
		
		while (line!="") {
			String[] cmd=line.split(" ");
			int steps=Integer.parseInt(cmd[1]);
			char command=cmd[0].charAt(0);
			Position newPosition=calculateNewPosition(currentPosition,command,steps);
		
			
			if (takenPositions.contains(newPosition)) {
				System.out.println(newPosition.x+" "+newPosition.y+"DANGER");
				return;
			} else {
				System.out.println(newPosition.x+" "+newPosition.y+"safe");
				takenPositions.add(newPosition);
				currentPosition=newPosition;
				line=sc.nextLine();
			}
		}
	}

	private static Position calculateNewPosition(Position currentPosition, char command, int steps) {
		// TODO Auto-generated method stub
		Position newPosition=null;
		if (command=='l') {
			newPosition=new Position(currentPosition.x-steps,currentPosition.y);
		} else if (command=='r') {
			newPosition=new Position(currentPosition.x+steps,currentPosition.y);
		} else if (command=='u') {
			newPosition=new Position(currentPosition.x,currentPosition.y-steps);
		} else { // down
			newPosition=new Position(currentPosition.x,currentPosition.y+steps);
		}
		return newPosition;
	}

}

class Position {
	
	int x;
	int y;
	
	public Position(int i,int j) {
		this.x=i;
		this.y=j;
	}
	
	@Override
	public boolean equals(Object o) {
		Position positionObject=(Position)o;
		return this.x==positionObject.x && this.y==positionObject.y;
	}
}
