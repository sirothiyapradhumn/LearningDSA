public static void reverse(int a[], int left , int right){
    
    while(left < right){
      int temp = a[left];
      a[left] = a[right];
      a[right] = temp;

      left++;
      right--;
    }
  }

  public static void rotate(int[] a, int k){

    // jab k ki value arr.length sai jyda ho
    k = k % a.length;
    // when k's value is in negative
    if(k<0){
      k = k + a.length;
    }

    int n = a.length;
   
    // full 0 -> n-1
    reverse(a, 0, n-1);
    // 0 -> k -1
    reverse(a, 0, k-1);
    // k -> n-1
    reverse(a, k, n-1);

  }