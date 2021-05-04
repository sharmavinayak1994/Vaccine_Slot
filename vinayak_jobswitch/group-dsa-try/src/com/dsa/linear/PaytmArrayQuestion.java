package com.dsa.linear;

public class PaytmArrayQuestion {

	public void find_kth_element(int arr[], int k) {

		int length = arr.length;
		int difference = arr[length - 1] - arr[0];
		int missing = 0;
		if (k < difference) {
			for (int i = 0; i < length - 1; i++) {
				int temp = (arr[i + 1] - arr[i]) -1;
				if (temp > 1) {
					if(temp>=k) {
						missing = arr[i] + k;
						break;
					}else {
						k = k-temp;
					}
				}
			}
			System.out.println("missing element is : " + missing);
		} else {
			if (k == difference) {
				missing = arr[length - 1] + 1;
			} else {
				missing = (k - difference) + arr[length - 1];
			}
			System.out.println("Missing element : " + missing);
		}
	}

	public static void main(String[] args) {
		PaytmArrayQuestion paytmArr = new PaytmArrayQuestion();
		int arr[] = { 90, 91, 99, 102, 110 };
		paytmArr.find_kth_element(arr, 16);
	}

}
