from heapq import heappush, heappop, heapify
arrLen, K = map(int, raw_input().split(' '))
arr = map(int, raw_input().split(' '))
heapify(arr)

while len(arr)>1 and arr[0]<K:
    sweetness = heappop(arr) + 2*heappop(arr)
    heappush(arr, sweetness)

if len(arr) < 2 and arr[0] < K:
    print -1
else:
    print arrLen - len(arr)