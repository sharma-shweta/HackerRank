def isVowel(char):
	if char.lower() in ['a', 'e', 'i', 'o', 'u']:
		return True
	return False


STUART_PTS = 0
KEVIN_PTS = 0
index = 0

word = raw_input()

for letter in word:
	if(isVowel(letter)):
		KEVIN_PTS = KEVIN_PTS + (len(word) - index)
	else:
		STUART_PTS = STUART_PTS + (len(word) - index)
	index = index + 1

if KEVIN_PTS > STUART_PTS:
	print "Kevin", KEVIN_PTS
elif KEVIN_PTS < STUART_PTS:
	print "Stuart", STUART_PTS
else:
    print "Draw"