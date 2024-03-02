/*
Problem: LeetCode 981 - Time Based Key-Value Store

Description:
Design a time-based key-value data structure that can store multiple values for the same key and retrieve the value of a key at a certain time.
Implement the TimeMap class:
- TimeMap() Initializes the object of the data structure.
- void set(String key, String value, int timestamp) Stores the key, value pair in the data structure.
- String get(String key, int timestamp) Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
   If there are multiple such values, it returns the value associated with the largest timestamp_prev.
   If there are no values, it returns an empty string ("").

Intuition:
To implement the TimeMap, we can utilize a hashmap data structure to store the key-value pairs. Each key will map to a list of timestamps and corresponding values.
By using binary search within the list of timestamps, we can efficiently retrieve the value associated with a given key and timestamp.

Approach:
1. Implement the TimeMap class.
2. Create a hashmap, where each key maps to a list of pairs containing timestamps and values.
3. Implement the set function:
   - If the key does not exist in the hashmap, create a new list with the first pair of (timestamp, value).
   - If the key already exists, append the new pair of (timestamp, value) to the existing list.
4. Implement the get function:
   - If the key does not exist in the hashmap, return an empty string.
   - If the key exists, perform binary search within the list of pairs:
     - If the timestamp at the middle index is equal to the target timestamp, return the corresponding value.
     - If the timestamp at the middle index is greater than the target timestamp, update the right pointer to middle - 1 and continue searching in the left half.
     - If the timestamp at the middle index is less than the target timestamp, update the left pointer to middle + 1 and continue searching in the right half.
5. If the binary search does not find an exact match, return the value at the index of the right pointer.

Time Complexity:
The time complexity of set is O(1), as it only involves hashmap operations.
The time complexity of get is O(log n), where n is the number of entries for a given key in the hashmap. The binary search is performed within the list of timestamps.

Space Complexity:
The space complexity is O(n), where n is the total number of entries in the hashmap. Each entry occupies space for the key and a list of timestamp-value pairs.
*/

class TimeMap {
private:
    map<string, vector<pair<string, int>>> hMap;

public:
    TimeMap() {
        
    }
    
    void set(string key, string value, int timestamp) {
        hMap[key].push_back(make_pair(value, timestamp));
    }
    
    string get(string key, int timestamp) {
        if (hMap.find(key) == hMap.end()) {
            return "";
        }

        vector<pair<string, int>>& list = hMap[key];

        int low = 0;
        int high = list.size() - 1;

        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (list[mid].second <= timestamp) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return list[low].second <= timestamp ? list[low].first : "";
    }
};
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */