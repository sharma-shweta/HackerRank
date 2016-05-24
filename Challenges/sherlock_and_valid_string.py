input_string = raw_input()

track_letters = {}
track_unique_totals = {}

for letter in input_string:
	if letter in track_letters:
		track_letters[letter] = track_letters[letter] + 1
	else:
		track_letters[letter] = 1


for value in track_letters.values():
	if value in track_unique_totals:
		track_unique_totals[value] = track_unique_totals[value] + 1
	else:
		track_unique_totals[value] = 1

if len(track_unique_totals.keys()) > 2:
	print "NO"
elif len(track_unique_totals.keys()) < 2:
	print "YES"
else:
	if 1 not in track_unique_totals.values():
		print "NO"
	else:
		key1, val1 = track_unique_totals.keys()[0], track_unique_totals.values()[0]
		key2, val2 = track_unique_totals.keys()[1], track_unique_totals.values()[1]
	
		if(val1<val2):
			smaller_key = key1
			larger_key = key2
		else:
			smaller_key=key2
			larger_key=key1

		if smaller_key==1 or smaller_key-larger_key==1:
			print "YES"
		else:
			print "NO"