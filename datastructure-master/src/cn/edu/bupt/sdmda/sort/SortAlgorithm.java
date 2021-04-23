package cn.edu.bupt.sdmda.sort;

import java.util.ArrayList;
import java.util.List;

public class SortAlgorithm {
	public static ArrayList<Double> insertSort(ArrayList<Double> array) {
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (array.get(i) <= array.get(j)) {
					double tmp = array.get(i);
					array.add(j, tmp);
					array.remove(i + 1);
				}
			}
		}
		return array;

	}

	public static ArrayList<Double> selectionSort(ArrayList<Double> array) {
		int length = array.size();
		for (int i = 0; i < length; i++) {
			double min = array.get(i);
			int minindex = i;
			for (int j = i + 1; j < length; j++) {
				if (array.get(j) < min) {
					min = array.get(j);
					minindex = j;
				}
			}
			array.add(i, min);
			array.remove(minindex + 1);
		}
		return array;
	}

	public static ArrayList<Double> bubbleSort(ArrayList<Double> array) {
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.size() - 1; j++) {
				if (array.get(j) > array.get(j + 1)) {
					double tmp = array.get(j + 1);
					array.set(j + 1, array.get(j));
					array.set(j, tmp);
				}
			}
		}
		return array;
	}

	public static ArrayList<Double> QSort(ArrayList<Double> array, int left, int right) {
		if (left < right) {
			int k = partition(array, left, right);
			QSort(array, left, k - 1);
			QSort(array, k + 1, right);
		}
		return array;
	}

	private static int partition(List<Double> array, int left, int right) {
		double pivot = array.get(left);
		while (left < right) {
			while (pivot <= array.get(right) && left < right) {
				right--;
			}
			while (pivot >= array.get(left) && left < right) {
				left++;
			}
			if (left < right) {
				double tmp = array.get(left);
				array.set(left, array.get(right));
				array.set(right, tmp);
			}
		}
		return left;
	}

	public static ArrayList<Double> mergeSort(List<Double> array, int left, int right) {
		ArrayList<Double> leftarray = new ArrayList<Double>();
		for (int i = left; i < (((left + right) / 2) + 1); i++)
			leftarray.add(array.get(i));

		ArrayList<Double> rightarray = new ArrayList<Double>();
		for (int i = (((left + right) / 2) + 1); i < right + 1; i++)
			rightarray.add(array.get(i));

		if (right != left) {
			leftarray = mergeSort(array, left, (left + right) / 2);
			rightarray = mergeSort(array, ((left + right) / 2) + 1, right);
		}
		return merge(leftarray, rightarray);
	}

	private static ArrayList<Double> merge(List<Double> leftarray, List<Double> rightarray) {
		ArrayList<Double> mergeList = new ArrayList<Double>(leftarray);
		mergeList.addAll(rightarray);
		mergeList = insertSort(mergeList);
		return mergeList;
	}
}
