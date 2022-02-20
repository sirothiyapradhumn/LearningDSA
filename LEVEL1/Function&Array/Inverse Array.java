  public static int[] inverse(int[] a){
    int n = a.length;
    int[] inverseArr = new int[n];

    for(int idx = 0; idx<n; idx++){
      
      inverseArr[a[idx]] = idx;
    }
    
    return inverseArr;
  }