package br.com.devmos.model;

import java.util.Stack;

import br.com.devmos.util.Tower;

public class Tower {
	private Stack<Integer> disks;
	private int index;
	
	public Tower(int i) {
		disks = new Stack<>();
		index = i;
	}
	
	public int index() {
		return index;
	}
	
	public void add(int disk) {
		if(!disks.isEmpty() && disks.peek() <= disk) {
			System.out.println("Error placing disk " + disk);
		}
	}
	
	public void moveToTop(Tower tower) {
		int top = disks.pop();
		tower.add(top);
	}
	
	public void moveDisks(int n, Tower destination, Tower buffer) {
		
		if(n > 0) {
			moveDisks(n - 1, buffer, destination);
			moveToTop(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
	}

}
