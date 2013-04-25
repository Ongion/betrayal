package pathFinding;

import java.util.ArrayList;
import java.util.Set;

import Game.Game;
import characters.Character;

import rooms.Room;
import rooms.Room.Relative_Direction;
import floors.Location;

public class PathFinding {
	
	ArrayList<PathfindingNode> openList;
	ArrayList<PathfindingNode> closedList;
	
	public Character getNearestCharacterTo(Character curr){
		ArrayList<Character> characters = new ArrayList<Character>();
		characters.addAll(Game.getInstance().getCharacters());
		
		characters.remove(curr);
		
		if (characters.size() == 1){
			return characters.get(0);
		}
		
		openList = new ArrayList<PathfindingNode>();
		closedList = new ArrayList<PathfindingNode>();
		
		for (Character c: characters){
			PathfindingNode n = new PathfindingNode(c.getCurrentRoom());
			openList.add(n);
		}
		
		while (!closedList.contains(new PathfindingNode(curr.getCurrentRoom())) && openList.size() > 0){
			PathfindingNode lowest = getLowestCostNodeTo(curr.getCurrentRoom());
			
			Set<Relative_Direction> exits = lowest.getRoom().getExits();
			
			ArrayList<Room> adjacentRooms = new ArrayList<Room>();
			
			for (Relative_Direction dir : exits){
				adjacentRooms.add(lowest.getRoom().getRoomFromExit(dir));
			}
			
			for (Room r : adjacentRooms){
				if (r != null){
					PathfindingNode newNode = new PathfindingNode(r,lowest,lowest.getGCost()+1);
					if (!closedList.contains(newNode) && !openList.contains(newNode)){
						openList.add(newNode);
					}
				}
				
				
			}
			
			openList.remove(lowest);
			closedList.add(lowest);
		}
		
		if (openList.isEmpty()){
			return null;
		}
		
		PathfindingNode last = null;
		for (PathfindingNode n : closedList){
			if (n.getRoom().equals(curr.getCurrentRoom())){
				last = n;
				break;
			}
		}
		
		while (last.getParent() != null){
			last = last.getParent();
		}
		
		
		for (Character c :characters){
			if (c.getCurrentRoom().equals(last.getRoom())){
				return c;
			}
		}
		
		//This return should never happen
		return null;
	}

	private PathfindingNode getLowestCostNodeTo(Room r){
		int lowestScore = openList.get(0).getScoreToRoom(r);
		PathfindingNode lowestNode = openList.get(0);
		
		for(PathfindingNode n: openList){
			int score = n.getScoreToRoom(r); 
			if (score < lowestScore){
				lowestScore = score;
				lowestNode = n;
			}
		}
		
		return lowestNode;
	}


	private class PathfindingNode{
		PathfindingNode parent = null;
		int gCost = 0;
		Room room;
		
		public PathfindingNode(Room room){
			this.room = room;
		}
		
		public PathfindingNode(Room room, PathfindingNode parent, int gCost){
			this.room = room;
			this.parent = parent;
			this.gCost = gCost;
		}
		
		public int getScoreToRoom(Room r){
			Location l = r.getLocation();
			Location cur = room.getLocation();
			int xDif = Math.abs(cur.getX() - l.getX());
			int yDif = Math.abs(cur.getY()- l.getY());
			
			return xDif + yDif + gCost;
		}
		
		public Room getRoom(){
			return this.room;
		}
		
		public int getGCost(){
			return this.gCost;
		}
		
		public boolean equals(Object obj){
			if (obj instanceof PathfindingNode){
				PathfindingNode n = ((PathfindingNode) obj);
				return this.room.equals(n.getRoom());
			}
			return false;
		}
		
		public PathfindingNode getParent() {
			return this.parent;
		}
		
	}
}
