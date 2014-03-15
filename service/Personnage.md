service: Personnage
use: Object
types : String,int,boolean 
observators:
	const nom: [Personnage] -> String
	const largeur: [Personnage] -> int
	const hauteur: [Personnage] -> int
	const profonder: [Personnage] -> int
	const force: [Personnage] -> int
	hp:[Personnage] -> int
	money:[Personnage] -> int
	alive:[Personnage] -> boolean
	equiped:[Personnage] -> boolean
	object?:[Personnage] -> Object
	
Constructors:
	init: String * int * int * int * int -> Personnage
	 pre init(nom,largeur,hauter,profondeur,force) require nom != "" AND force > 0
	