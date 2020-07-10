package sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Quick extends Sorter {
	private ArrayList< ArrayList<Sortable> > subarrs;
	
	
	public Quick(Sortable[] sortable) {
		super(sortable);
		
		subarrs = new ArrayList< ArrayList<Sortable> >();
		//convert sortable to arraylist and add to subarrs
		List<Sortable> sortableAsList = Arrays.asList(sortable);
		ArrayList<Sortable> sortableAsArrayList = new ArrayList<Sortable>(sortableAsList);
		subarrs.add(sortableAsArrayList);
	}


	@Override
	public String nextLine() {
		//String old = toString(subarrs);
		
		sortSubarrs();
		String newer = toString(subarrs);

		//TODO - figure out new method that works for this
		/*
		 * this method does not work. Some steps seemingly just involve breaking 
		 * arraylists into smaller ones, without making any order changes.
		 * 
		 * 
		 * diagnose by System.out.println(subarrs)
		 * 
		if(old.equals(newer)) {
			return "Done!";
		}*/
		System.out.println(subarrs);
		return newer;
	}
	
	private String toString(ArrayList< ArrayList<Sortable> > arr) {
		String str = "";
		for(int i = 0; i < arr.size(); i++) {
			for(int j = 0; j < arr.get(i).size(); j++) {
				str += arr.get(i).get(j).getValue() + ", ";
			}
		}
		
		return str;
	}
	
	
	//TODO
	@Override
	public Sortable[] iter() {
		sortSubarrs();
		//convert to arrays
		
		//return the array
		return null;
	}
	
	private void sortSubarrs() {
		ArrayList< ArrayList<Sortable> > next = new ArrayList<ArrayList<Sortable>>();
		
		for(int i = 0; i < subarrs.size(); i++ ) {
			int pivot = subarrs.get(i).get(0).getValue();
			int pivIndex = 0;
			ArrayList<Sortable> _temp = subarrs.get(i);
			
			for(int j = 1; j < _temp.size(); j++) {
				if(_temp.get(j).getValue() < pivot) {
					pivIndex++;
					//swap pivIndex with current index
					Collections.swap(_temp, pivIndex, j);
				}
			}
			//swap pivIndex with pivot
			Collections.swap(_temp, pivIndex, 0);
			//split _temp into 3 and place in next
			ArrayList<ArrayList<Sortable>> subs = splitIntoThree(_temp, pivIndex);
			for(int j = 0; j < subs.size(); j++) {
				next.add(subs.get(j));
			}
			
		}
		//replace subarrs with next
		subarrs = next;
		
	}
	
	
	/**
	 * Splits ArrayList into maximum three arraylists;
	 * - left of the pivot
	 * - the pivot itself
	 * - right of the pivot
	 * 
	 * If the pivot is at the far left or right side of the list, the result will only contain two.
	 * 
	 * If arrList is empty or has a length of 1, it will be returned
	 * 
	 * 
	 */
	private ArrayList<ArrayList<Sortable>> splitIntoThree(ArrayList<Sortable> arrList, int pivot){
		ArrayList<Sortable> _temp = arrList;
		ArrayList<ArrayList<Sortable>> three = new ArrayList<ArrayList<Sortable>>();
		
		if (arrList.size() <= 1) {
			three.add(arrList);
			return three;
		}
		
		//make pivot its own ArrayList
		ArrayList<Sortable> piv = new ArrayList<Sortable>();
		piv.add(_temp.get(pivot));
		_temp.remove(pivot);
		
		ArrayList<Sortable> left = new ArrayList<Sortable>(_temp.subList(0, pivot));
		ArrayList<Sortable> right = new ArrayList<Sortable>(_temp.subList(pivot, _temp.size()));
	
		if(left.size()>0) {
			three.add(left);
		}
		
		three.add(piv);
		
		if(right.size() > 0) {
			three.add(right);
		}
		
		return three;
	}
	

}
