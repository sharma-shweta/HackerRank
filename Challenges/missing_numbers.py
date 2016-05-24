#Input for array 1
len1 = input()
arr_str1 = raw_input()
arr1 = arr_str1.split(' ')
arr1 = [int(x) for x in arr1]

#Input for array 2
len2 = input()
arr_str2 = raw_input()
arr2 = arr_str2.split(' ')
arr2 = [int(x) for x in arr2]

if (len2 > len1):
	smaller_arr = arr1
	larger_arr = arr2
else:
	smaller_arr = arr2
	larger_arr = arr1

"""
Tacker to count the references of a number in the larger_arr.
Subtract the reference count while iterating through smaller array. 
The keys with ref. > 0 are missing in the smallare array.
"""
tracker = {}
for i in larger_arr:
	if i in tracker:
		tracker[i] = tracker[i] + 1
	else:
		tracker[i] = 1

for i in smaller_arr:
	tracker[i] = tracker[i] - 1

missing_nums = []
for key in tracker:
	if tracker[key] > 0:
		missing_nums.append(key)

print(" ".join(str(x) for x in missing_nums))
