import java.util.ArrayList;
import java.util.List;

public class Main {
  public static int coinChangePermutationInfi(List<Integer> arr, int tar, String ans) {
    if (tar == 0) {
        System.out.println(ans);
        return 1;
    }
    int count = 0;
    for (int ele : arr) {
      if (tar - ele >= 0){
        count += coinChangePermutationInfi(arr, tar - ele, ans + Integer.toString(ele));
      }
    }
    return count;
  }

  public static int coinChangeCombinationInfi(List<Integer> arr, int idx, int tar, String ans) {
    if (tar == 0) {
        System.out.println(ans);
        return 1;
    }
    int count = 0;
    for (int i = idx; i<arr.size(); i++) {
      if (tar - arr.get(i) >= 0){
        count += coinChangeCombinationInfi(arr, i, tar - arr.get(i), ans+arr.get(i));
      }
    }
    return count;
  }

  public static int coinChangeCombinationSingle(List<Integer> arr, int idx, int tar, String ans) {
    if (tar == 0) {
        System.out.println(ans);
        return 1;
    }
    int count = 0;
    for (int i = idx; i<arr.size(); i++) {
      if (tar - arr.get(i) >= 0){
        count += coinChangeCombinationSingle(arr, i+1, tar - arr.get(i), ans+arr.get(i));
      }
    }
    return count;
  }

    public static int coinChangePermutationSingle(List<Integer> arr, int tar, String ans) {
      if (tar == 0) {
          System.out.println(ans);
          return 1;
      }
      int count = 0;
      for (int i = 0; i < arr.size(); i++) {
          int ele = arr.get(i);
          if (arr.get(i) > 0 && tar - ele >= 0) {
              arr.set(i, -arr.get(i));
              count += coinChangePermutationSingle(arr, tar - ele, ans + ele);
              arr.set(i, -arr.get(i));
          }
      }
      return count;
  }

    public static int coinChangeCombinationSubSeq(List<Integer> arr, int idx, int tar, String ans) {
      if(arr.size() == idx || tar == 0) {
        if(tar == 0) {
          System.out.println(ans);
          return 1;
        }
        return 0;
      }
      
      int count =0; 
      if(tar - arr.get(idx) >= 0) {
        count += coinChangeCombinationSubSeq(arr, idx+1, tar-arr.get(idx), ans+arr.get(idx));
      }
      count += coinChangeCombinationSubSeq(arr, idx+1, tar, ans);
      
      return count;
  }

    public static int coinChangeCombinationInfiSubSeq(List<Integer> arr, int idx, int tar, String ans) {
      if(arr.size() == idx || tar == 0) {
        if(tar == 0) {
          System.out.println(ans);
          return 1;
        }
        return 0;
      }
      
      int count =0; 
      if(tar - arr.get(idx) >= 0) {
        count += coinChangeCombinationInfiSubSeq(arr, idx, tar-arr.get(idx), ans+arr.get(idx));
      }
      count += coinChangeCombinationInfiSubSeq(arr, idx+1, tar, ans);
      
      return count;
  }

    public static int coinChangePermutationInfiSubSeq(List<Integer> arr, int idx, int tar, String ans) {
      if(arr.size() == idx || tar == 0) {
        if(tar == 0) {
          System.out.println(ans);
          return 1;
        }
        return 0;
      }
      
      int count =0; 
      if(tar - arr.get(idx) >= 0 ) {
        count += coinChangePermutationInfiSubSeq(arr, 0, tar-arr.get(idx), ans+arr.get(idx));
      }
      count += coinChangePermutationInfiSubSeq(arr, idx+1, tar, ans);
      
      return count;
  }

  public static int coinChangePermutationSubSeq(List<Integer> arr, int idx, int tar, String ans) {
    if(arr.size() == idx || tar == 0) {
      if(tar == 0) {
        System.out.println(ans);
        return 1;
      }
      return 0;
    }
    
    int count =0; 
    int ele = arr.get(idx);
    if(tar - ele >= 0 && arr.get(idx) > 0) {
      arr.set(idx, -arr.get(idx));
      count += coinChangePermutationSubSeq(arr, 0, tar-ele, ans+ele);
      arr.set(idx, -arr.get(idx));
    }
    count += coinChangePermutationSubSeq(arr, idx+1, tar, ans);
    
    return count;
  }

  // 39

    List<Integer> smallAns = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public void combinationSum(int[] arr, int idx, int target) {
        if (idx == arr.length || target == 0) {
            if (target == 0) {
                List<Integer> base = new ArrayList<>(smallAns);
                res.add(base);
            }
            return;
        }

        if (target - arr[idx] >= 0) {
            smallAns.add(arr[idx]);
            combinationSum(arr, idx, target - arr[idx]);
            smallAns.remove(smallAns.size() - 1);
        }
        combinationSum(arr, idx + 1, target);
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        combinationSum(arr, 0, target);
        return res;

    }

    // 46
    public void permute(int[] nums, int count, boolean[] vis) {
        if (count == nums.length) {

            res.add(new ArrayList<>(smallAns));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                smallAns.add(nums[i]);
                permute(nums, count + 1, vis);
                smallAns.remove(smallAns.size() - 1);
                vis[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        permute(nums, 0, vis);
        return res;
    }

  public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>();
    arr.add(2);
    arr.add(3);
    arr.add(5);
    arr.add(7);
    int tar = 10;
    String ans = "";
    int res = coinChangePermutationInfi(arr, tar, ans);
    System.out.println(res);
  }
}