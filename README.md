# DicewareChecker

I recently discovered Diceware ([http://world.std.com/~reinhold/diceware.html](http://world.std.com/~reinhold/diceware.html)), it is a nice way to come up with strong passphrases. 

The author provides an [official word list](http://world.std.com/~reinhold/diceware.wordlist.asc), which is signed by his PGP key. But who knows, maybe he is actually an undercover NSA agent :) ! So, to go all the way, why not check that the list does indeed contains 7776 different words each associated with a different 5 dice roll sequence. As the strenght of the Diceware method relies only on the fact each 5 dice roll sequence gives a different word, this is sufficient.

I wrote this little script to test it, but of course if you want the check the list you downloaded you should write your own script because who knows if I can be trusted !

(On a side note it would be nice if the Diceware website had a certificate. The little lock on the browser is more reassuring to non tech-saavy people than the fact that the list is signed by a PGP private key)
