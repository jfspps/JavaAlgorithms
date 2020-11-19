package com.algorithms.ArrayList.algorithms;

public class DynArray<T> {
	private int maxLength;
	private int size;	//denotes either the index which follows after the last element, or, number of elements in array
	T[] array;
	
	public DynArray() {
		this.maxLength = 4;
		this.size = 0;
	}
	
	/**
	 * Builds a new instance with optional maxLength (min. 4).
	 * 
	 * */
	public DynArray(int length) {
		if (length > 4)
			this.maxLength = length;
		else
			this.maxLength = 4;
		
		this.size = 0;
	}

	/**
	 * Appends element to the end of the array.
	 * 
	 * */
	void append(T element) {
		if (this.size >= this.array.length/2) {
			DynArray<T> newArray = new DynArray<T>();
			int i;
			for (i = 0; i < this.size; i++) {
				newArray.array[i] = this.array[i];
				newArray.size++;
			}
			newArray.array[i] = element;
			newArray.size++;
			this.array = newArray.array;
			this.size = newArray.size;
		} else {
			this.array[size++] = element;
		}
	}
	
	/**
	 * Finds the element and returns its index. Returns -1 if not found.
	 * 
	 * */
	int find(T element) {
		int i = 0;
		while (i <= this.size) {
			if (this.array[i] == element) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	/**
	 * Finds and then removes element from the array. Returns true if found and false if not.
	 * 
	 * */
	boolean remove(T element) {
		int index = this.find(element);
		if (index >= 0) {
			//shuffle proceeding elements along
			for (int j = index; j <= this.size; j++) {
				this.array[j] = this.array[j+1];
			}
			this.size -= 1;
			return true;
		} else {
			System.out.println("Element not found");
			return false;
		}
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
